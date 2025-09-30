package com.example.resource_service.grpc;

import com.example.resource_service.grpc.ResourceServiceImpl;
import io.grpc.Server;
import net.devh.boot.grpc.server.serverfactory.GrpcServerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class GrpcMethodValidator {

    private static final Logger logger = LoggerFactory.getLogger(GrpcMethodValidator.class);
    
    @Autowired
    private GrpcServerFactory grpcServerFactory;
    
    @Autowired
    private ResourceServiceImpl resourceService;

    @EventListener(ApplicationReadyEvent.class)
    public void validateGrpcMethods() {
        logger.info("=== 🔍 gRPC Method Validation ===");
        
        try {
            // 检查服务实现类的方法
            Class<?> serviceClass = resourceService.getClass();
            Method[] methods = serviceClass.getDeclaredMethods();
            
            boolean hasCheckAvailability = false;
            for (Method method : methods) {
                if ("checkAvailability".equals(method.getName())) {
                    hasCheckAvailability = true;
                    logger.info("✅ Found checkAvailability method in ResourceServiceImpl");
                    break;
                }
            }
            
            if (!hasCheckAvailability) {
                logger.error("❌ checkAvailability method NOT found in ResourceServiceImpl");
            }
            
            // 检查服务器注册的服务
            Server server = grpcServerFactory.createServer();
            var services = server.getServices();
            logger.info("📊 Total gRPC services registered: {}", services.size());
            
            for (var service : services) {
                logger.info("🔧 Service: {}", service.getClass().getName());
                // 检查服务描述符
                var serviceDescriptor = service.getClass().getMethod("getServiceDescriptor").invoke(service);
                var methodsField = serviceDescriptor.getClass().getDeclaredField("methods");
                methodsField.setAccessible(true);
                var methodList = (java.util.List<?>) methodsField.get(serviceDescriptor);
                
                logger.info("📋 Available methods:");
                for (Object methodDesc : methodList) {
                    String methodName = methodDesc.toString();
                    logger.info("   - {}", methodName);
                    if (methodName.contains("CheckAvailability")) {
                        logger.info("     ✅ CheckAvailability method is REGISTERED!");
                    }
                }
            }
            
        } catch (Exception e) {
            logger.error("❌ Validation failed", e);
        }
        
        logger.info("=== Validation Complete ===");
    }
}