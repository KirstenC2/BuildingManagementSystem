package com.example.reservation_service.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;
import com.example.reservation_service.grpc.ResourceRequest;
import com.example.reservation_service.grpc.ResourceResponse;
import com.example.reservation_service.grpc.ResourceServiceGrpc;

@Service
public class ResourceGrpcClient {

    private final ResourceServiceGrpc.ResourceServiceBlockingStub stub;

    public ResourceGrpcClient() {
        ManagedChannel channel = ManagedChannelBuilder
                // 1️⃣ 建立 gRPC channel - 這邊是docker service name
                // 開給reservation-service 連結grpc port
                .forAddress("resource-service", 9090)
                .usePlaintext()
                .build();

        stub = ResourceServiceGrpc.newBlockingStub(channel);
    }

    public ResourceResponse checkAvailability(Long resourceId, String tenantId) {
        // 1️⃣ 建立 gRPC request
        ResourceRequest request = ResourceRequest.newBuilder()
                .setResourceId(resourceId)
                .setTenantId(tenantId)
                .build();
    
        // 2️⃣ 用 stub 呼叫 gRPC server
        ResourceResponse response = stub.checkAvailability(request);
    
        // 3️⃣ 回傳 server response
        return response;
    }
    
}
