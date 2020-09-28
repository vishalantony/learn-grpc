package com.github.vantony.grpc.greeting.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class SumServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server sumServer = ServerBuilder
                .forPort(50052)
                .addService(new AdditionServiceImpl())
                .build();

        sumServer.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("shutting down sum server");
            sumServer.shutdown();
            System.out.println("sum server closed");
        }));

        sumServer.awaitTermination();
    }
}
