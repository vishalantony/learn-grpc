package com.github.vantony.grpc.primecomposition.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class PrimeServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        // create server
        Server primeServer = ServerBuilder
                .forPort(50053)
                .addService(new PrimeCompositionServiceImpl())
                .build();

        // start server
        primeServer.start();
        System.out.println("Server started");

        // Add runtime shutdown hook to shut down server
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutting down server...");
            primeServer.shutdown();
            System.out.println("server shut down...");
        }));

        // keep running the server till shutdown
        primeServer.awaitTermination();
    }
}
