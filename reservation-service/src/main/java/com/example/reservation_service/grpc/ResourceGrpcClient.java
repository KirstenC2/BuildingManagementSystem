package com.example.reservation_service.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.example.resource_service.grpc.ResourceServiceGrpc;
import com.example.resource_service.grpc.ResourceRequest;
import com.example.resource_service.grpc.ResourceResponse;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ResourceGrpcClient {

    private ManagedChannel channel;
    private ResourceServiceGrpc.ResourceServiceBlockingStub stub;

    @Value("${grpc.client.resource-service.host:localhost}")
    private String host;

    @Value("${grpc.client.resource-service.port:9095}")
    private int port;

    @PostConstruct
    public void init() {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.stub = ResourceServiceGrpc.newBlockingStub(channel);
    }

    public ResourceResponse checkAvailability(Long resourceId, String tenantId) {
        ResourceRequest request = ResourceRequest.newBuilder()
                .setResourceId(resourceId)
                .setTenantId(tenantId)
                .build();
        return stub.checkAvailability(request);
    }

    @PreDestroy
    public void shutdown() {
        if (channel != null) {
            channel.shutdown();
        }
    }
}
