package com.example.resource_service.grpc;

import net.devh.boot.grpc.server.service.GrpcService;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.resource_service.repository.ResourceRepository;

@GrpcService
public class ResourceGrpcService extends ResourceServiceGrpc.ResourceServiceImplBase {

    @Autowired
    private ResourceRepository repository;

    @Override
    public void getResource(ResourceRequest request, StreamObserver<ResourceResponse> responseObserver) {
        // TODO: Implement actual resource retrieval logic here
        // This is a basic implementation that returns a mock response
        ResourceResponse response = ResourceResponse.newBuilder()
                .setId(request.getId())
                .setName("Resource " + request.getId())
                .setDescription("Description for resource " + request.getId())
                .build();
                
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
