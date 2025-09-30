package com.example.resource_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Resource {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private String type;

    private boolean active;

    private boolean available;

    private String tenantId;  // assuming tenantId is a string

    // getters and setters
    public Long getResourceId() { return id; }
    public void setResourceId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }
}
