package com.example.resource_service.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.resource_service.entity.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> findByTenantId(String tenantId);
    Optional<Resource> findById(Long id);
}


