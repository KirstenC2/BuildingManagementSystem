package com.example.resource_service.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: resource_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ResourceServiceGrpc {

  private ResourceServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ResourceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.resource_service.grpc.ResourceRequest,
      com.example.resource_service.grpc.ResourceResponse> getGetResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getResource",
      requestType = com.example.resource_service.grpc.ResourceRequest.class,
      responseType = com.example.resource_service.grpc.ResourceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.resource_service.grpc.ResourceRequest,
      com.example.resource_service.grpc.ResourceResponse> getGetResourceMethod() {
    io.grpc.MethodDescriptor<com.example.resource_service.grpc.ResourceRequest, com.example.resource_service.grpc.ResourceResponse> getGetResourceMethod;
    if ((getGetResourceMethod = ResourceServiceGrpc.getGetResourceMethod) == null) {
      synchronized (ResourceServiceGrpc.class) {
        if ((getGetResourceMethod = ResourceServiceGrpc.getGetResourceMethod) == null) {
          ResourceServiceGrpc.getGetResourceMethod = getGetResourceMethod =
              io.grpc.MethodDescriptor.<com.example.resource_service.grpc.ResourceRequest, com.example.resource_service.grpc.ResourceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getResource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.resource_service.grpc.ResourceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.resource_service.grpc.ResourceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ResourceServiceMethodDescriptorSupplier("getResource"))
              .build();
        }
      }
    }
    return getGetResourceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ResourceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResourceServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ResourceServiceStub>() {
        @java.lang.Override
        public ResourceServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ResourceServiceStub(channel, callOptions);
        }
      };
    return ResourceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ResourceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResourceServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ResourceServiceBlockingStub>() {
        @java.lang.Override
        public ResourceServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ResourceServiceBlockingStub(channel, callOptions);
        }
      };
    return ResourceServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ResourceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResourceServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ResourceServiceFutureStub>() {
        @java.lang.Override
        public ResourceServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ResourceServiceFutureStub(channel, callOptions);
        }
      };
    return ResourceServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getResource(com.example.resource_service.grpc.ResourceRequest request,
        io.grpc.stub.StreamObserver<com.example.resource_service.grpc.ResourceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetResourceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ResourceService.
   */
  public static abstract class ResourceServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ResourceServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ResourceService.
   */
  public static final class ResourceServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ResourceServiceStub> {
    private ResourceServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResourceServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResourceServiceStub(channel, callOptions);
    }

    /**
     */
    public void getResource(com.example.resource_service.grpc.ResourceRequest request,
        io.grpc.stub.StreamObserver<com.example.resource_service.grpc.ResourceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetResourceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ResourceService.
   */
  public static final class ResourceServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ResourceServiceBlockingStub> {
    private ResourceServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResourceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResourceServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.resource_service.grpc.ResourceResponse getResource(com.example.resource_service.grpc.ResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetResourceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ResourceService.
   */
  public static final class ResourceServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ResourceServiceFutureStub> {
    private ResourceServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResourceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResourceServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.resource_service.grpc.ResourceResponse> getResource(
        com.example.resource_service.grpc.ResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetResourceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_RESOURCE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_RESOURCE:
          serviceImpl.getResource((com.example.resource_service.grpc.ResourceRequest) request,
              (io.grpc.stub.StreamObserver<com.example.resource_service.grpc.ResourceResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetResourceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.resource_service.grpc.ResourceRequest,
              com.example.resource_service.grpc.ResourceResponse>(
                service, METHODID_GET_RESOURCE)))
        .build();
  }

  private static abstract class ResourceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ResourceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.resource_service.grpc.ResourceServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ResourceService");
    }
  }

  private static final class ResourceServiceFileDescriptorSupplier
      extends ResourceServiceBaseDescriptorSupplier {
    ResourceServiceFileDescriptorSupplier() {}
  }

  private static final class ResourceServiceMethodDescriptorSupplier
      extends ResourceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ResourceServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ResourceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ResourceServiceFileDescriptorSupplier())
              .addMethod(getGetResourceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
