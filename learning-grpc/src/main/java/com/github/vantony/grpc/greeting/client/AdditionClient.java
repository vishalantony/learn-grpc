package com.github.vantony.grpc.greeting.client;

import com.proto.sum.AdditionServiceGrpc;
import com.proto.sum.SumRequest;
import com.proto.sum.SumResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AdditionClient {
    private static SumRequest getSumRequest(int a, int b) {
        return SumRequest.newBuilder().setNumber1(a).setNumber2(b).build();
    }

    public static void main(String[] args) {
        //create channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();

        // create stub
        AdditionServiceGrpc.AdditionServiceBlockingStub additionStub = AdditionServiceGrpc.newBlockingStub(channel);

        int a = 12;
        int b = 123;

        // call RPC and get response
        SumResponse response = additionStub.add(getSumRequest(a, b));
        System.out.println(String.format("Sum of %d and %d is %d", a, b, response.getSum()));

        // close channel
        channel.shutdown();
    }
}
