package com.github.vantony.grpc.greeting.server;

import com.proto.sum.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class AdditionServiceImpl extends AdditionServiceGrpc.AdditionServiceImplBase {
    @Override
    public void add(SumRequest request, StreamObserver<SumResponse> responseObserver) {
        // extract numbers:
        int n1 = request.getNumber1();
        int n2 = request.getNumber2();

        // generate response
        int sum = n1 + n2;
        SumResponse response = SumResponse.newBuilder().setSum(sum).build();

        // send response
        responseObserver.onNext(response);

        // complete sending the response
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<ComputeAverageRequest> average(StreamObserver<ComputeAverageResponse> responseObserver) {
        StreamObserver<ComputeAverageRequest> requestStreamObserver = new StreamObserver<ComputeAverageRequest>() {
            int sum = 0;
            int count = 0;

            @Override
            public void onNext(ComputeAverageRequest value) {
                System.out.println("Got another number in the stream [" + value.getNumber() + "]");
                sum += value.getNumber();
                count++;
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("error in requestObserver: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                double average;
                if (count == 0) {
                    average = 0;
                } else {
                    average = sum * 1.0 / count;
                }

                ComputeAverageResponse response = ComputeAverageResponse.newBuilder().setAverage(average).build();
                System.out.println("Sending the average: " + response.getAverage());

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };

        return requestStreamObserver;
    }

    @Override
    public void squareRoot(SquareRootRequest request, StreamObserver<SquareRootResponse> responseObserver) {
        int number = request.getNumber();

        if (number >= 0) {
            responseObserver.onNext(
                    SquareRootResponse
                            .newBuilder()
                            .setSquareRoot(Math.sqrt(number))
                            .build()
            );

            responseObserver.onCompleted();
        } else {
            responseObserver.onError(
                    Status.INVALID_ARGUMENT
                            .withDescription("The number sent is not positive!")
                            .augmentDescription("Number sent : " + number)
                            .asRuntimeException()
            );
        }
    }
}
