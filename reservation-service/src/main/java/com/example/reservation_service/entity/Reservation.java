package com.example.reservation_service.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long resourceId;
    private String tenantId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    
    // 构造函数
    public Reservation() {}
    
    public Reservation(Long resourceId, String tenantId, LocalDateTime startTime, LocalDateTime endTime) {
        this.resourceId = resourceId;
        this.tenantId = tenantId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = "PENDING";
    }
    
    // Getter 和 Setter 方法
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getResourceId() { return resourceId; }
    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }
    
    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
    
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}