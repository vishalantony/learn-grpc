// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sum/sum.proto

package com.proto.sum;

public final class Sum {
  private Sum() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sum_SumRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sum_SumRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sum_SumResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sum_SumResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sum_ComputeAverageRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sum_ComputeAverageRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sum_ComputeAverageResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sum_ComputeAverageResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sum_SquareRootRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sum_SquareRootRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_sum_SquareRootResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_sum_SquareRootResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rsum/sum.proto\022\003sum\".\n\nSumRequest\022\017\n\007nu" +
      "mber1\030\001 \001(\005\022\017\n\007number2\030\002 \001(\005\"\032\n\013SumRespo" +
      "nse\022\013\n\003sum\030\001 \001(\005\"\'\n\025ComputeAverageReques" +
      "t\022\016\n\006number\030\001 \001(\005\")\n\026ComputeAverageRespo" +
      "nse\022\017\n\007average\030\001 \001(\001\"#\n\021SquareRootReques" +
      "t\022\016\n\006number\030\001 \001(\005\")\n\022SquareRootResponse\022" +
      "\023\n\013square_root\030\001 \001(\0012\306\001\n\017AdditionService" +
      "\022*\n\003add\022\017.sum.SumRequest\032\020.sum.SumRespon" +
      "se\"\000\022F\n\007Average\022\032.sum.ComputeAverageRequ" +
      "est\032\033.sum.ComputeAverageResponse\"\000(\001\022?\n\n" +
      "SquareRoot\022\026.sum.SquareRootRequest\032\027.sum" +
      ".SquareRootResponse\"\000B\021\n\rcom.proto.sumP\001" +
      "b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_sum_SumRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_sum_SumRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sum_SumRequest_descriptor,
        new java.lang.String[] { "Number1", "Number2", });
    internal_static_sum_SumResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_sum_SumResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sum_SumResponse_descriptor,
        new java.lang.String[] { "Sum", });
    internal_static_sum_ComputeAverageRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_sum_ComputeAverageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sum_ComputeAverageRequest_descriptor,
        new java.lang.String[] { "Number", });
    internal_static_sum_ComputeAverageResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_sum_ComputeAverageResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sum_ComputeAverageResponse_descriptor,
        new java.lang.String[] { "Average", });
    internal_static_sum_SquareRootRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_sum_SquareRootRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sum_SquareRootRequest_descriptor,
        new java.lang.String[] { "Number", });
    internal_static_sum_SquareRootResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_sum_SquareRootResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_sum_SquareRootResponse_descriptor,
        new java.lang.String[] { "SquareRoot", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
