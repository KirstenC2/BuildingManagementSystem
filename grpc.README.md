
# 關於 gRPC

## GRPC Server (在resource-service中)
- 提供 RPC 方法給其他微服務

## GRPC Client (在reservation-service中)
- 使用 GRPC Server 提供的 RPC 方法

## 核心概念：
微服務之間直接溝通時，不用經過 REST
gRPC 提供：
- 高效能二進位序列化（Protobuf）
- 跨語言支援（Java、Node.js、Go…）
- 嚴格的介面契約（proto 定義 RPC）

## gRPC的核心： proto文件
其實就是json 的概念，但是更優化，可以定義
- data的結構
- message的結構


## 項目中的gRPC的部分  
1. 首先， 當reservation-service的對外API收到request的時候，會需要跟resource-service溝通
確認resource是否可以預約
```
POST /reservations
{
    "roomId": 123,
    "startTime": "...",
    "endTime": "...",
    "tenantId": "tenantA"
}
```
2.接著， reservation-service會透過gRPC client去跟resource-service溝通
```
ResourceRequest request = ResourceRequest.newBuilder()
    .setResourceId(roomId)
    .setTenantId(tenantId)
    .build();
ResourceResponse response = stub.checkAvailability(request);
```
3. Resource-service的gRPC server會回傳response給reservation-service
```
{
    "exists": true,
    "available": true
}

這樣的做法其實是分離了reservation 干涉resource 相關的business logic, db access logic, 以及依賴性，這樣才能達成微服務的獨立性。
```

## 如何create gRPC?

1. 定義proto文件
```
syntax = "proto3";
package resourceservice;

service ResourceService {
  rpc CheckAvailability(ResourceRequest) returns (ResourceResponse);
}

message ResourceRequest {
  int64 resourceId = 1;
  string tenantId = 2;
}

message ResourceResponse {
  bool exists = 1;
  bool available = 2;
}
```



