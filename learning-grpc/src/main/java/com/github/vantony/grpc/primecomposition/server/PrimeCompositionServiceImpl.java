package com.github.vantony.grpc.primecomposition.server;

import com.proto.prime.*;
import io.grpc.stub.StreamObserver;

public class PrimeCompositionServiceImpl extends PrimeCompositionServiceGrpc.PrimeCompositionServiceImplBase {
    private static PrimeCompositionResponse getPrimeCompositionResponse(int primeFactor) {
        return PrimeCompositionResponse.newBuilder().setPrimeFactor(primeFactor).build();
    }

    @Override
    public void primeComposition(PrimeCompositionRequest request,
                                 StreamObserver<PrimeCompositionResponse> responseObserver) {
        // extract values
        int number = request.getComposite();

        // find prime factor and respond
        try {
            for (int factor = 2; number > 1; factor++) {
                if (number % factor == 0) {
                    responseObserver.onNext(getPrimeCompositionResponse(factor));
                    while (number % factor == 0) {
                        number /= factor;
                    }
                    Thread.sleep(1000);

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<MaximumInStreamRequest> maximumInStream(StreamObserver<MaximumInStreamResponse> responseObserver) {

        return new StreamObserver<MaximumInStreamRequest>() {
            int maxYet = Integer.MIN_VALUE;

            @Override
            public void onNext(MaximumInStreamRequest value) {
                int max = Math.max(maxYet, value.getNumber());
                if (max > maxYet) {
                    maxYet = max;
                    MaximumInStreamResponse response = MaximumInStreamResponse.newBuilder().setMaxNumber(maxYet).build();
                    responseObserver.onNext(response);
                }
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error in finding max. Server side.");
                responseObserver.onCompleted();
            }

            @Override
            public void onCompleted() {
                System.out.println("Client has sent all requests. Server closing.");
                responseObserver.onCompleted();
            }
        };
    }
}
