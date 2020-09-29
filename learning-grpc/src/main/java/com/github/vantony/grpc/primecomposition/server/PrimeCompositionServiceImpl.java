package com.github.vantony.grpc.primecomposition.server;

import com.proto.prime.PrimeCompositionRequest;
import com.proto.prime.PrimeCompositionResponse;
import com.proto.prime.PrimeCompositionServiceGrpc;
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
}
