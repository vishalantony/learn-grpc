package com.github.vantony.grpc.greeting.client;

import com.proto.greet.GreetRequest;
import com.proto.greet.GreetResponse;
import com.proto.greet.GreetServiceGrpc;
import com.proto.greet.Greeting;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {
    private static GreetRequest getGreetRequest(String firstName, String lastName) {
        Greeting greeting = Greeting.newBuilder().setFirstName(firstName).setSecondName(lastName).build();
        GreetRequest greetRequest = GreetRequest.newBuilder().setGreeting(greeting).build();
        return greetRequest;
    }

    public static void main(String[] args) {
        System.out.println("Hello from gRPC client!");

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        System.out.println("Creating stub");
        GreetServiceGrpc.GreetServiceBlockingStub greetClient = GreetServiceGrpc.newBlockingStub(channel);

        for(int i = 0; i < 100; i++) {
            // sending the message
            GreetResponse response = greetClient.greet(getGreetRequest("Vishal", "Antony"));
            // logging the response
            System.out.println(response.getResult());
        }

        System.out.println("Shutting down channel");
        channel.shutdown();
    }
}
