package com.example.reservation_service.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.reservation_service.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByTenantId(String tenantId);
    Optional<Reservation> findById(Long id);
}
