package com.example.resource_service.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.resource_service.entity.Resource;
import com.example.resource_service.repository.ResourceRepository;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    @Autowired private ResourceRepository repo;

    @PostMapping
    public Resource create(@RequestBody Resource r) {
        System.out.println(r);
        return repo.save(r);
    }

    @GetMapping("/list")
    public List<Resource> list(@RequestParam String tenantId) {
        return repo.findByTenantId(tenantId);
    }

    @GetMapping("/info")
    public Resource get(@RequestParam(required = true) Long id) {
        if(id == null) {
            return null;
        }
        return repo.findById(id).orElse(null);
    }
}

