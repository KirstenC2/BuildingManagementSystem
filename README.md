# Project Overview

This project is a microservice architecture for a building management system.

這是一個微服務架構的建物管理系統。


# Tech Stack (使用的技術)

1. Spring Boot
2. PostgreSQL
3. gRPC
4. Lombok
5. Maven

# Project Structure

resource-api: 提供REST API
resource-service: 提供gRPC service
reservation-service: 提供gRPC client

1. Resource Service
    - Manages resources in the building
    - Handles resource reservations
    - Provides resource availability checks
2. Reservation Service
    - Manages reservations for resources
    - Handles reservation requests
    - Provides reservation status updates
3. Resource API
    - Provides a REST API for resource management
    - Handles resource reservations
    - Provides resource availability checks
## Services

1. Resource Service
    - 管理建物中的資源
    - 處理資源預約
    - 提供資源可用性檢查
2. Reservation Service
    - 管理資源預約
    - 處理預約請求
    - 提供預約狀態更新
3. Resource API
    - 提供 REST API 供資源管理
    - 處理資源預約
    - 提供資源可用性檢查

