package com.example.user.feignClient;

import com.example.user.config.FeignConfig;
import com.example.user.dto.ProfileDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "profile-service", url = "http://localhost:8081", configuration = FeignConfig.class)
public interface ProfileClient {

    @GetMapping(value="/profiles/{id}", produces = "application/json")
    ProfileDTO getProfileById(@PathVariable Long id);
}
