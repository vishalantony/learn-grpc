package com.github.vantony.grpc.greeting.client;

import com.proto.sum.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdditionClient {
    static Random rand = new Random(System.currentTimeMillis());

    private static SumRequest getSumRequest(int a, int b) {
        return SumRequest.newBuilder().setNumber1(a).setNumber2(b).build();
    }

    private static void additionRPCImplementation(ManagedChannel channel) {
        // create stub
        AdditionServiceGrpc.AdditionServiceBlockingStub additionStub = AdditionServiceGrpc.newBlockingStub(channel);

        int a = 12;
        int b = 123;

        // call RPC and get response
        SumResponse response = additionStub.add(getSumRequest(a, b));
        System.out.println(String.format("Sum of %d and %d is %d", a, b, response.getSum()));

    }

    private static void computerAverageRPCImpl(ManagedChannel channel) {
        AdditionServiceGrpc.AdditionServiceStub asyncClient = AdditionServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<ComputeAverageResponse> responseStreamObserver = new StreamObserver<ComputeAverageResponse>() {
            @Override
            public void onNext(ComputeAverageResponse value) {
                System.out.println("Got the response [Average] = " + value.getAverage());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error in response observer" + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Server has completed sending us the response.");
                latch.countDown();
            }
        };

        StreamObserver<ComputeAverageRequest> requestStreamObserver = asyncClient.average(responseStreamObserver);

        for(int i = 0; i < 10; i++) {
            int number = rand.nextInt(100);
            System.out.println("number: " + number);
            requestStreamObserver.onNext(ComputeAverageRequest.newBuilder().setNumber(number).build());
        }

        requestStreamObserver.onCompleted();

        try {
            latch.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //create channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();

//        additionRPCImplementation(channel);
        computerAverageRPCImpl(channel);

        // close channel
        channel.shutdown();
    }
}
