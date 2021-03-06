package com.github.vantony.grpc.greeting.server;

import com.proto.greet.*;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        Greeting greeting = request.getGreeting();
        String firstName = greeting.getFirstName();
        String lastName = greeting.getSecondName();

        // create response
        String result = String.format("Hello %s %s!", firstName, lastName);
        GreetResponse response = GreetResponse.newBuilder().setResult(result).build();

        // send response
        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }

    @Override
    public void greetManyTimes(GreetManyTimesRequest request,
                               StreamObserver<GreetManyTimesResponse> responseObserver) {
        // extract information from request
        String firstName = request.getGreeting().getFirstName();
        String lastName = request.getGreeting().getSecondName();

        try {
            for (int i = 0; i < 10; i++) {
                // generate response string
                String result = String.format("Hello %s %s!", firstName, lastName);
                result = String.format("response: \"\"\"%s\"\"\" response_index: %d", result, i);

                // generate response message
                GreetManyTimesResponse response =
                        GreetManyTimesResponse
                                .newBuilder()
                                .setResult(result)
                                .build();

                // send response
                responseObserver.onNext(response);

                // wait for 1 second
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // mark the stream completed
            responseObserver.onCompleted();
        }
    }

    @Override
    public StreamObserver<LongGreetRequest> longGreet(StreamObserver<LongGreetResponse> responseObserver) {
        // we are creating the request observer here and sending it to the client. Client calls the methods on it.

        StreamObserver<LongGreetRequest> requestObserver = new StreamObserver<LongGreetRequest>() {
            StringBuffer result = new StringBuffer();

            @Override
            public void onNext(LongGreetRequest value) {
                // client sends a message
                System.out.println("got message from client " + value.toString());
                result.append(String.format("Hello %s %s!\n",
                        value.getGreeting().getFirstName(), value.getGreeting().getSecondName()));
            }

            @Override
            public void onError(Throwable t) {
                // client sends an error
            }

            @Override
            public void onCompleted() {

                String resultString = result.toString();
                // client is done.
                System.out.println("Client is done sending the messages...");
                System.out.println("Sending response ::\n" + resultString);

                responseObserver.onNext(
                        LongGreetResponse
                                .newBuilder()
                                .setResult(resultString)
                                .build()
                );

                responseObserver.onCompleted();
                // this is when we want to return a response.
            }
        };

        return requestObserver;
    }

    @Override
    public StreamObserver<GreetEveryoneRequest> greetEveryone(StreamObserver<GreetEveryoneResponse> responseObserver) {
        StreamObserver<GreetEveryoneRequest> requestStreamObserver = new StreamObserver<GreetEveryoneRequest>() {
            @Override
            public void onNext(GreetEveryoneRequest value) {
                System.out.println("received GreetEveryoneRequest " + value.toString());
                GreetEveryoneResponse response = GreetEveryoneResponse
                        .newBuilder()
                        .setResult(String.format("Hello %s %s!",
                                value.getGreeting().getFirstName(), value.getGreeting().getSecondName()))
                        .build();

                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Client has stopped sending messages. Completing response.");
                responseObserver.onCompleted();
            }
        };

        return requestStreamObserver;
    }

    @Override
    public void greetWithDeadline(GreetWithDeadlineRequest request, StreamObserver<GreetWithDeadlineResponse> responseObserver) {
        try {
            // get rpc context
            Context currentContext = Context.current();

            // extract information
            String firstName = request.getGreeting().getFirstName();
            String lastName = request.getGreeting().getSecondName();

            for (int i = 0; i < 3; i++) {
                if (currentContext.isCancelled()) {
                    System.out.println("Context is cancelled.");
                    return;
                }
                System.out.println("Going to sleep...");
                Thread.sleep(100);
            }

            // send response
            System.out.println("Sending response...");
            responseObserver.onNext(
                    GreetWithDeadlineResponse
                            .newBuilder()
                            .setResult(String.format("Hello %s %s!", firstName, lastName))
                            .build()
            );

            // complete request
            responseObserver.onCompleted();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
