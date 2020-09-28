package com.github.vantony.grpc.greeting.server;

import com.proto.sum.AdditionServiceGrpc;
import com.proto.sum.SumRequest;
import com.proto.sum.SumResponse;
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
}
