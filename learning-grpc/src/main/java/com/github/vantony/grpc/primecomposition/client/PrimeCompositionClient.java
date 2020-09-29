package com.github.vantony.grpc.primecomposition.client;

import com.proto.prime.PrimeCompositionRequest;
import com.proto.prime.PrimeCompositionServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class PrimeCompositionClient {

    private static PrimeCompositionRequest getPrimeCompositionRequest(int number) {
        return PrimeCompositionRequest.newBuilder().setComposite(number).build();
    }

    private static int getCompositeNumber(Scanner scn) {
        System.out.print("Enter a number and we'll show you its prime factors: ");
        return scn.nextInt();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // create channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50053)
                .usePlaintext()
                .build();


        // create stub
        PrimeCompositionServiceGrpc.PrimeCompositionServiceBlockingStub primeCompositionClient =
                PrimeCompositionServiceGrpc.newBlockingStub(channel);

        // create request and send
        primeCompositionClient.primeComposition(getPrimeCompositionRequest(getCompositeNumber(scn))).forEachRemaining(
                primeCompositionResponse ->
                        System.out.println("prime factor: " + primeCompositionResponse.getPrimeFactor())
        );

        // close channel
        channel.shutdown();

        System.out.println("Exiting...");
    }
}
