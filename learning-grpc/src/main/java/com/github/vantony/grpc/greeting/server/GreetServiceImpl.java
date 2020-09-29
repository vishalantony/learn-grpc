package com.github.vantony.grpc.greeting.server;

import com.proto.greet.*;
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
}
