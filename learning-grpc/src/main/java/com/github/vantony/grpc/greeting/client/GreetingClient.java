package com.github.vantony.grpc.greeting.client;

import com.proto.greet.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GreetingClient {
    private static Greeting getGreeting(String firstName, String lastName) {
        return Greeting.newBuilder().setFirstName(firstName).setSecondName(lastName).build();
    }

    private static GreetRequest getGreetRequest(String firstName, String lastName) {
        Greeting greeting = Greeting.newBuilder().setFirstName(firstName).setSecondName(lastName).build();
        GreetRequest greetRequest = GreetRequest.newBuilder().setGreeting(greeting).build();
        return greetRequest;
    }

    private static GreetManyTimesRequest getGreetManyTimesRequest(String firstName, String lastName) {
        Greeting greeting = Greeting.newBuilder().setFirstName(firstName).setSecondName(lastName).build();
        GreetManyTimesRequest greetRequest = GreetManyTimesRequest.newBuilder().setGreeting(greeting).build();
        return greetRequest;
    }

    private static ManagedChannel getChannel(String url, int port) {
        return ManagedChannelBuilder
                .forAddress(url, port)
                .usePlaintext()
                .build();
    }

    private static GreetServiceGrpc.GreetServiceBlockingStub getStub(ManagedChannel channel) {
        System.out.println("Creating stub");
        return GreetServiceGrpc.newBlockingStub(channel);
    }

    private static void unaryAPIImpl(GreetServiceGrpc.GreetServiceBlockingStub greetClient) {
        // Unary API
        // sending the message
        GreetResponse response = greetClient.greet(getGreetRequest("Vishal", "Antony"));
        // logging the response
        System.out.println(response.getResult());
    }

    private static void serverStreamingImpl(GreetServiceGrpc.GreetServiceBlockingStub greetClient) {
        // Server streaming
        greetClient.greetManyTimes(getGreetManyTimesRequest("Vishal", "Antony")).forEachRemaining(
                greetManyTimesResponse -> System.out.println(greetManyTimesResponse.getResult())
        );
    }

    private static void clientStreamingImpl(ManagedChannel channel) {
        // in client streaming, server can response any time. So the stub will be async.

        // create an async stub on the channel
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        // create request observer. Request Observer is used to send message to server.
        StreamObserver<LongGreetRequest> requestObserver =
                asyncClient.longGreet(new StreamObserver<LongGreetResponse>() {
                    // ResponseObserver observes the response from the server.

                    @Override
                    public void onNext(LongGreetResponse value) {
                        //we get a response from the server
                        System.out.println("received response from server\n" + value.getResult());
                        // onNext will be called only once.
                    }

                    @Override
                    public void onError(Throwable t) {
                        // we get error from the server
                        System.out.println("server error " + t.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        // server is done with sending the data
                        System.out.println("Server has completed sending us the response");
                        latch.countDown();
                        // one completed will be called right after onNext.
                    }
                });

        System.out.println("Sending messages to server");
        for (int i = 0; i < 10; i++) {
            requestObserver.onNext(
                    LongGreetRequest
                            .newBuilder()
                            .setGreeting(Greeting.newBuilder().setFirstName("Vishal" + i).build())
                            .build()
            );
        }

        // TELL THE SERVER THAT THE CLIENT IS DONE SENDING THE DATA
        requestObserver.onCompleted();

        try {
            latch.await(9, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void biDiStreamingImpl(ManagedChannel channel) {
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<GreetEveryoneRequest> requestStreamObserver =
                asyncClient.greetEveryone(new StreamObserver<GreetEveryoneResponse>() {
                    @Override
                    public void onNext(GreetEveryoneResponse value) {
                        System.out.println("Received response: " + value.toString());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Server has completed sending the response.");
                        latch.countDown();
                    }
                });


        List<Greeting> lg = Arrays.asList(
                getGreeting("Gandalf", "The Grey"), getGreeting("Bilbo", "Baggins"),
                getGreeting("Samwise", "Gamgee"), getGreeting("Lady", "Galadriel"),
                getGreeting("Aragorn", ""), getGreeting("Grima", "Wormtongue")
        );

        lg.forEach(greeting -> {
            System.out.println("Sending " + greeting);
            requestStreamObserver.onNext(GreetEveryoneRequest.newBuilder().setGreeting(
                    greeting
            ).build());

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        requestStreamObserver.onCompleted();

        try {
            latch.await(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello from gRPC client!");

        ManagedChannel channel = getChannel("localhost", 50051);

//        unaryAPIImpl(greetClient);
//        serverStreamingImpl(greetClient);
//        clientStreamingImpl(channel);
        biDiStreamingImpl(channel);


        System.out.println("Shutting down channel");
        channel.shutdown();
    }
}
