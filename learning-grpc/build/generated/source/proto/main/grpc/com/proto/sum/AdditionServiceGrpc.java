package com.proto.sum;

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
    comments = "Source: sum/sum.proto")
public final class AdditionServiceGrpc {

  private AdditionServiceGrpc() {}

  public static final String SERVICE_NAME = "sum.AdditionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.sum.SumRequest,
      com.proto.sum.SumResponse> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add",
      requestType = com.proto.sum.SumRequest.class,
      responseType = com.proto.sum.SumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.sum.SumRequest,
      com.proto.sum.SumResponse> getAddMethod() {
    io.grpc.MethodDescriptor<com.proto.sum.SumRequest, com.proto.sum.SumResponse> getAddMethod;
    if ((getAddMethod = AdditionServiceGrpc.getAddMethod) == null) {
      synchronized (AdditionServiceGrpc.class) {
        if ((getAddMethod = AdditionServiceGrpc.getAddMethod) == null) {
          AdditionServiceGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<com.proto.sum.SumRequest, com.proto.sum.SumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.sum.SumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.sum.SumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdditionServiceMethodDescriptorSupplier("add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.sum.ComputeAverageRequest,
      com.proto.sum.ComputeAverageResponse> getAverageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Average",
      requestType = com.proto.sum.ComputeAverageRequest.class,
      responseType = com.proto.sum.ComputeAverageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.sum.ComputeAverageRequest,
      com.proto.sum.ComputeAverageResponse> getAverageMethod() {
    io.grpc.MethodDescriptor<com.proto.sum.ComputeAverageRequest, com.proto.sum.ComputeAverageResponse> getAverageMethod;
    if ((getAverageMethod = AdditionServiceGrpc.getAverageMethod) == null) {
      synchronized (AdditionServiceGrpc.class) {
        if ((getAverageMethod = AdditionServiceGrpc.getAverageMethod) == null) {
          AdditionServiceGrpc.getAverageMethod = getAverageMethod =
              io.grpc.MethodDescriptor.<com.proto.sum.ComputeAverageRequest, com.proto.sum.ComputeAverageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Average"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.sum.ComputeAverageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.sum.ComputeAverageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdditionServiceMethodDescriptorSupplier("Average"))
              .build();
        }
      }
    }
    return getAverageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.sum.SquareRootRequest,
      com.proto.sum.SquareRootResponse> getSquareRootMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SquareRoot",
      requestType = com.proto.sum.SquareRootRequest.class,
      responseType = com.proto.sum.SquareRootResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.sum.SquareRootRequest,
      com.proto.sum.SquareRootResponse> getSquareRootMethod() {
    io.grpc.MethodDescriptor<com.proto.sum.SquareRootRequest, com.proto.sum.SquareRootResponse> getSquareRootMethod;
    if ((getSquareRootMethod = AdditionServiceGrpc.getSquareRootMethod) == null) {
      synchronized (AdditionServiceGrpc.class) {
        if ((getSquareRootMethod = AdditionServiceGrpc.getSquareRootMethod) == null) {
          AdditionServiceGrpc.getSquareRootMethod = getSquareRootMethod =
              io.grpc.MethodDescriptor.<com.proto.sum.SquareRootRequest, com.proto.sum.SquareRootResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SquareRoot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.sum.SquareRootRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.sum.SquareRootResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdditionServiceMethodDescriptorSupplier("SquareRoot"))
              .build();
        }
      }
    }
    return getSquareRootMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdditionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdditionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdditionServiceStub>() {
        @java.lang.Override
        public AdditionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdditionServiceStub(channel, callOptions);
        }
      };
    return AdditionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdditionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdditionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdditionServiceBlockingStub>() {
        @java.lang.Override
        public AdditionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdditionServiceBlockingStub(channel, callOptions);
        }
      };
    return AdditionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdditionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdditionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdditionServiceFutureStub>() {
        @java.lang.Override
        public AdditionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdditionServiceFutureStub(channel, callOptions);
        }
      };
    return AdditionServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AdditionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void add(com.proto.sum.SumRequest request,
        io.grpc.stub.StreamObserver<com.proto.sum.SumResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.sum.ComputeAverageRequest> average(
        io.grpc.stub.StreamObserver<com.proto.sum.ComputeAverageResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAverageMethod(), responseObserver);
    }

    /**
     * <pre>
     * RPC to get the square root of a number.
     * returns error if the number is negative.
     * </pre>
     */
    public void squareRoot(com.proto.sum.SquareRootRequest request,
        io.grpc.stub.StreamObserver<com.proto.sum.SquareRootResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSquareRootMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.sum.SumRequest,
                com.proto.sum.SumResponse>(
                  this, METHODID_ADD)))
          .addMethod(
            getAverageMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.proto.sum.ComputeAverageRequest,
                com.proto.sum.ComputeAverageResponse>(
                  this, METHODID_AVERAGE)))
          .addMethod(
            getSquareRootMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.sum.SquareRootRequest,
                com.proto.sum.SquareRootResponse>(
                  this, METHODID_SQUARE_ROOT)))
          .build();
    }
  }

  /**
   */
  public static final class AdditionServiceStub extends io.grpc.stub.AbstractAsyncStub<AdditionServiceStub> {
    private AdditionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdditionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdditionServiceStub(channel, callOptions);
    }

    /**
     */
    public void add(com.proto.sum.SumRequest request,
        io.grpc.stub.StreamObserver<com.proto.sum.SumResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.sum.ComputeAverageRequest> average(
        io.grpc.stub.StreamObserver<com.proto.sum.ComputeAverageResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAverageMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * RPC to get the square root of a number.
     * returns error if the number is negative.
     * </pre>
     */
    public void squareRoot(com.proto.sum.SquareRootRequest request,
        io.grpc.stub.StreamObserver<com.proto.sum.SquareRootResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSquareRootMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AdditionServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AdditionServiceBlockingStub> {
    private AdditionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdditionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdditionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.sum.SumResponse add(com.proto.sum.SumRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * RPC to get the square root of a number.
     * returns error if the number is negative.
     * </pre>
     */
    public com.proto.sum.SquareRootResponse squareRoot(com.proto.sum.SquareRootRequest request) {
      return blockingUnaryCall(
          getChannel(), getSquareRootMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AdditionServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AdditionServiceFutureStub> {
    private AdditionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdditionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdditionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.sum.SumResponse> add(
        com.proto.sum.SumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * RPC to get the square root of a number.
     * returns error if the number is negative.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.sum.SquareRootResponse> squareRoot(
        com.proto.sum.SquareRootRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSquareRootMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;
  private static final int METHODID_SQUARE_ROOT = 1;
  private static final int METHODID_AVERAGE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AdditionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AdditionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD:
          serviceImpl.add((com.proto.sum.SumRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.sum.SumResponse>) responseObserver);
          break;
        case METHODID_SQUARE_ROOT:
          serviceImpl.squareRoot((com.proto.sum.SquareRootRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.sum.SquareRootResponse>) responseObserver);
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
        case METHODID_AVERAGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.average(
              (io.grpc.stub.StreamObserver<com.proto.sum.ComputeAverageResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AdditionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdditionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.sum.Sum.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AdditionService");
    }
  }

  private static final class AdditionServiceFileDescriptorSupplier
      extends AdditionServiceBaseDescriptorSupplier {
    AdditionServiceFileDescriptorSupplier() {}
  }

  private static final class AdditionServiceMethodDescriptorSupplier
      extends AdditionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AdditionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AdditionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdditionServiceFileDescriptorSupplier())
              .addMethod(getAddMethod())
              .addMethod(getAverageMethod())
              .addMethod(getSquareRootMethod())
              .build();
        }
      }
    }
    return result;
  }
}
