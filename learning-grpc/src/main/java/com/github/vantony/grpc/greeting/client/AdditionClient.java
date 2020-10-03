package com.github.vantony.grpc.greeting.client;

import com.proto.sum.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdditionClient {
    Random rand = new Random(System.currentTimeMillis());

    private SumRequest getSumRequest(int a, int b) {
        return SumRequest.newBuilder().setNumber1(a).setNumber2(b).build();
    }

    private void additionRPCImplementation(ManagedChannel channel) {
        // create stub
        AdditionServiceGrpc.AdditionServiceBlockingStub additionStub = AdditionServiceGrpc.newBlockingStub(channel);

        int a = 12;
        int b = 123;

        // call RPC and get response
        SumResponse response = additionStub.add(getSumRequest(a, b));
        System.out.println(String.format("Sum of %d and %d is %d", a, b, response.getSum()));

    }

    private void computeAverageRPCImpl(ManagedChannel channel) {
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

        for(int i = 0; i < 158750; i++) {
            int number = rand.nextInt(100);
//            System.out.println("number: " + number);
            requestStreamObserver.onNext(ComputeAverageRequest.newBuilder().setNumber(number).build());
        }

        requestStreamObserver.onCompleted();

        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doErrorCall(ManagedChannel channel) {
        // create stub
        AdditionServiceGrpc.AdditionServiceBlockingStub client = AdditionServiceGrpc.newBlockingStub(channel);

        try {
            client.squareRoot(SquareRootRequest.newBuilder().setNumber(-1).build());
        } catch (StatusRuntimeException e) {
            System.out.println("Call to get square root failed. Exception : " + e.getMessage());
            e.getStatus();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AdditionClient clientSide = new AdditionClient();

        //create channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();

//        clientSide.additionRPCImplementation(channel);
//        clientSide.computeAverageRPCImpl(channel);

        clientSide.doErrorCall(channel);

        // close channel
        channel.shutdown();
    }
}
