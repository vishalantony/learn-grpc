package com.github.vantony.grpc.primecomposition.client;

import com.proto.prime.MaximumInStreamRequest;
import com.proto.prime.MaximumInStreamResponse;
import com.proto.prime.PrimeCompositionRequest;
import com.proto.prime.PrimeCompositionServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class PrimeCompositionClient {

    static Random rand = new Random(System.currentTimeMillis());

    private static PrimeCompositionRequest getPrimeCompositionRequest(int number) {
        return PrimeCompositionRequest.newBuilder().setComposite(number).build();
    }

    private static int getCompositeNumber(Scanner scn) {
        System.out.print("Enter a number and we'll show you its prime factors: ");
        return scn.nextInt();
    }

    private static void findPrimeComposition(ManagedChannel channel, Scanner scn) {

        // create stub
        PrimeCompositionServiceGrpc.PrimeCompositionServiceBlockingStub primeCompositionClient =
                PrimeCompositionServiceGrpc.newBlockingStub(channel);

        // create request and send
        primeCompositionClient.primeComposition(getPrimeCompositionRequest(getCompositeNumber(scn))).forEachRemaining(
                primeCompositionResponse ->
                        System.out.println("prime factor: " + primeCompositionResponse.getPrimeFactor())
        );
    }

    private static void findStreamMax(ManagedChannel channel) throws InterruptedException {
        PrimeCompositionServiceGrpc.PrimeCompositionServiceStub asyncClient =
                PrimeCompositionServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<MaximumInStreamRequest> requestStreamObserver =
                asyncClient.maximumInStream(new StreamObserver<MaximumInStreamResponse>() {
                    @Override
                    public void onNext(MaximumInStreamResponse value) {
                        System.out.println("Maximum is : " + value.getMaxNumber());
                    }

                    @Override
                    public void onError(Throwable t) {
                        latch.countDown();
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Server has completed sending the stream. Closing.");
                        latch.countDown();
                    }
                });

        try {
            for (int i = 0; i < 10; i++) {
                int n = rand.nextInt(100);
                System.out.println("number : " + n);
                requestStreamObserver.onNext(MaximumInStreamRequest.newBuilder().setNumber(n).build());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            requestStreamObserver.onCompleted();
        }

        latch.await(3, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scn = new Scanner(System.in);

        // create channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50053)
                .usePlaintext()
                .build();

//        findPrimeComposition(channel, scn);
        findStreamMax(channel);


        // close channel
        channel.shutdown();

        System.out.println("Exiting...");
    }
}
