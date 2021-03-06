package com.proto.prime;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: primenumber/prime.proto")
public final class PrimeCompositionServiceGrpc {

  private PrimeCompositionServiceGrpc() {}

  public static final String SERVICE_NAME = "prime.PrimeCompositionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.prime.PrimeCompositionRequest,
      com.proto.prime.PrimeCompositionResponse> getPrimeCompositionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PrimeComposition",
      requestType = com.proto.prime.PrimeCompositionRequest.class,
      responseType = com.proto.prime.PrimeCompositionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.prime.PrimeCompositionRequest,
      com.proto.prime.PrimeCompositionResponse> getPrimeCompositionMethod() {
    io.grpc.MethodDescriptor<com.proto.prime.PrimeCompositionRequest, com.proto.prime.PrimeCompositionResponse> getPrimeCompositionMethod;
    if ((getPrimeCompositionMethod = PrimeCompositionServiceGrpc.getPrimeCompositionMethod) == null) {
      synchronized (PrimeCompositionServiceGrpc.class) {
        if ((getPrimeCompositionMethod = PrimeCompositionServiceGrpc.getPrimeCompositionMethod) == null) {
          PrimeCompositionServiceGrpc.getPrimeCompositionMethod = getPrimeCompositionMethod =
              io.grpc.MethodDescriptor.<com.proto.prime.PrimeCompositionRequest, com.proto.prime.PrimeCompositionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PrimeComposition"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.prime.PrimeCompositionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.prime.PrimeCompositionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrimeCompositionServiceMethodDescriptorSupplier("PrimeComposition"))
              .build();
        }
      }
    }
    return getPrimeCompositionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.prime.MaximumInStreamRequest,
      com.proto.prime.MaximumInStreamResponse> getMaximumInStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MaximumInStream",
      requestType = com.proto.prime.MaximumInStreamRequest.class,
      responseType = com.proto.prime.MaximumInStreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.prime.MaximumInStreamRequest,
      com.proto.prime.MaximumInStreamResponse> getMaximumInStreamMethod() {
    io.grpc.MethodDescriptor<com.proto.prime.MaximumInStreamRequest, com.proto.prime.MaximumInStreamResponse> getMaximumInStreamMethod;
    if ((getMaximumInStreamMethod = PrimeCompositionServiceGrpc.getMaximumInStreamMethod) == null) {
      synchronized (PrimeCompositionServiceGrpc.class) {
        if ((getMaximumInStreamMethod = PrimeCompositionServiceGrpc.getMaximumInStreamMethod) == null) {
          PrimeCompositionServiceGrpc.getMaximumInStreamMethod = getMaximumInStreamMethod =
              io.grpc.MethodDescriptor.<com.proto.prime.MaximumInStreamRequest, com.proto.prime.MaximumInStreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MaximumInStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.prime.MaximumInStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.prime.MaximumInStreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrimeCompositionServiceMethodDescriptorSupplier("MaximumInStream"))
              .build();
        }
      }
    }
    return getMaximumInStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PrimeCompositionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrimeCompositionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrimeCompositionServiceStub>() {
        @java.lang.Override
        public PrimeCompositionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrimeCompositionServiceStub(channel, callOptions);
        }
      };
    return PrimeCompositionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrimeCompositionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrimeCompositionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrimeCompositionServiceBlockingStub>() {
        @java.lang.Override
        public PrimeCompositionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrimeCompositionServiceBlockingStub(channel, callOptions);
        }
      };
    return PrimeCompositionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PrimeCompositionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrimeCompositionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrimeCompositionServiceFutureStub>() {
        @java.lang.Override
        public PrimeCompositionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrimeCompositionServiceFutureStub(channel, callOptions);
        }
      };
    return PrimeCompositionServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PrimeCompositionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void primeComposition(com.proto.prime.PrimeCompositionRequest request,
        io.grpc.stub.StreamObserver<com.proto.prime.PrimeCompositionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPrimeCompositionMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.prime.MaximumInStreamRequest> maximumInStream(
        io.grpc.stub.StreamObserver<com.proto.prime.MaximumInStreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getMaximumInStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPrimeCompositionMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.proto.prime.PrimeCompositionRequest,
                com.proto.prime.PrimeCompositionResponse>(
                  this, METHODID_PRIME_COMPOSITION)))
          .addMethod(
            getMaximumInStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.proto.prime.MaximumInStreamRequest,
                com.proto.prime.MaximumInStreamResponse>(
                  this, METHODID_MAXIMUM_IN_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class PrimeCompositionServiceStub extends io.grpc.stub.AbstractAsyncStub<PrimeCompositionServiceStub> {
    private PrimeCompositionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrimeCompositionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrimeCompositionServiceStub(channel, callOptions);
    }

    /**
     */
    public void primeComposition(com.proto.prime.PrimeCompositionRequest request,
        io.grpc.stub.StreamObserver<com.proto.prime.PrimeCompositionResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getPrimeCompositionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.prime.MaximumInStreamRequest> maximumInStream(
        io.grpc.stub.StreamObserver<com.proto.prime.MaximumInStreamResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getMaximumInStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class PrimeCompositionServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<PrimeCompositionServiceBlockingStub> {
    private PrimeCompositionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrimeCompositionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrimeCompositionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.proto.prime.PrimeCompositionResponse> primeComposition(
        com.proto.prime.PrimeCompositionRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getPrimeCompositionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PrimeCompositionServiceFutureStub extends io.grpc.stub.AbstractFutureStub<PrimeCompositionServiceFutureStub> {
    private PrimeCompositionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrimeCompositionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrimeCompositionServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_PRIME_COMPOSITION = 0;
  private static final int METHODID_MAXIMUM_IN_STREAM = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PrimeCompositionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PrimeCompositionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PRIME_COMPOSITION:
          serviceImpl.primeComposition((com.proto.prime.PrimeCompositionRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.prime.PrimeCompositionResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MAXIMUM_IN_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.maximumInStream(
              (io.grpc.stub.StreamObserver<com.proto.prime.MaximumInStreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PrimeCompositionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrimeCompositionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.prime.Prime.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PrimeCompositionService");
    }
  }

  private static final class PrimeCompositionServiceFileDescriptorSupplier
      extends PrimeCompositionServiceBaseDescriptorSupplier {
    PrimeCompositionServiceFileDescriptorSupplier() {}
  }

  private static final class PrimeCompositionServiceMethodDescriptorSupplier
      extends PrimeCompositionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PrimeCompositionServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PrimeCompositionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PrimeCompositionServiceFileDescriptorSupplier())
              .addMethod(getPrimeCompositionMethod())
              .addMethod(getMaximumInStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
