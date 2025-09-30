package com.example.resource_service.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class ResourceServiceImpl extends ResourceServiceGrpc.ResourceServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);
    
    // 暂时注释掉 Repository 避免其他错误
    // @Autowired
    // private ResourceRepository resourceRepository;

    @Override
    public void checkAvailability(
            com.example.resource_service.grpc.ResourceRequest request,
            StreamObserver<com.example.resource_service.grpc.ResourceResponse> responseObserver) {
        
        logger.info("🎯 gRPC CheckAvailability METHOD CALLED!");
        logger.info("📥 Request - resourceId: {}, tenantId: {}", 
                   request.getResourceId(), request.getTenantId());
        
        try {
            // 简单实现 - 直接返回成功
            com.example.resource_service.grpc.ResourceResponse response = 
                com.example.resource_service.grpc.ResourceResponse.newBuilder()
                    .setExists(true)
                    .setAvailable(true)
                    .build();
            
            logger.info("📤 Response - exists: true, available: true");
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
            logger.info("✅ gRPC call completed successfully");
            
        } catch (Exception e) {
            logger.error("❌ Error in CheckAvailability", e);
            responseObserver.onError(io.grpc.Status.INTERNAL
                    .withDescription("Error: " + e.getMessage())
                    .asRuntimeException());
        }
    }
}