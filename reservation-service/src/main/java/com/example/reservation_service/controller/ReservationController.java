package com.example.reservation_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.reservation_service.entity.Reservation;
import com.example.reservation_service.repository.ReservationRepository;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired private ReservationRepository repo;

    @PostMapping
    public Reservation create(@RequestBody Reservation r) {
        return repo.save(r);
    }
}
