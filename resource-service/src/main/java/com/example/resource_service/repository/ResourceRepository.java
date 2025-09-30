package com.example.resource_service.repository;

import com.example.resource_service.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> findByTenantId(String tenantId);
    Optional<Resource> findById(Long id);
    Optional<Resource> findByIdAndTenantId(Long id, String tenantId);
    Optional<Resource> findByTenantIdAndName(String tenantId, String name);
    Optional<Resource> findByTenantIdAndType(String tenantId, String type);
    Optional<Resource> findByTenantIdAndDescription(String tenantId, String description);
    Optional<Resource> findByTenantIdAndAvailable(String tenantId, boolean available);
    Optional<Resource> findByTenantIdAndActive(String tenantId, boolean isActive);
}
