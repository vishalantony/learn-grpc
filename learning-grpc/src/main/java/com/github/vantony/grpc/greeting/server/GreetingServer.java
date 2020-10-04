package com.github.vantony.grpc.greeting.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.File;
import java.io.IOException;

public class GreetingServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello gRPC!");

        // Plaintext server
//        Server server = ServerBuilder
//                .forPort(50051)
//                .addService(new GreetServiceImpl())
//                .build();

        // secure server
        Server secureServer = ServerBuilder.forPort(50051)
                .addService(new GreetServiceImpl())
                .addService(ProtoReflectionService.newInstance())
                .useTransportSecurity(
                        new File("ssl/server.crt"),
                        new File("ssl/server.pem")
                )
                .build();

        secureServer.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("received shutdown request");
            secureServer.shutdown();
            System.out.println("Successfully stopped the server");
        }));
        secureServer.awaitTermination();
    }
}
