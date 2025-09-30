package com.example.resource_service.controller;

import net.devh.boot.grpc.server.serverfactory.GrpcServerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcHealthController {
    
    @Autowired
    private GrpcServerFactory grpcServerFactory;
    
    @GetMapping("/grpc-health")
    public String grpcHealth() {    
        try {
            int port = grpcServerFactory.getPort();
            return "gRPC Server is UP on port: " + port;
        } catch (Exception e) {
            return "gRPC Server is DOWN: " + e.getMessage();
        }
    }
}