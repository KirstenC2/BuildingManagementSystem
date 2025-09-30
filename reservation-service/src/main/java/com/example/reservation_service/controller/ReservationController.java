package com.example.reservation_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.reservation_service.entity.Reservation;
import com.example.reservation_service.repository.ReservationRepository;
import com.example.reservation_service.grpc.ResourceGrpcClient;

@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired 
    private ReservationRepository repo;
    
    @Autowired 
    private ResourceGrpcClient resourceGrpcClient;

    @PostMapping("/reservations")
    public Reservation create(@RequestBody Reservation r) {
        return repo.save(r);
    }

    @GetMapping("/resource/check")
    public String checkResourceAvailability(
            @RequestParam Long resourceId,
            @RequestParam String tenantId) {
        return resourceGrpcClient.checkAvailability(resourceId, tenantId).toString();
    }
}