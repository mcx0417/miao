package com.mcx.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("regis-and-login-service")
public interface RegisAndLoginServClient {

    @GetMapping("/register/{username}")
    String registerCheck(@PathVariable String username);

    @PostMapping("/register/{multiUser}")
    String UserRegister(@PathVariable String multiUser);

    @GetMapping("/login/{multiUser}")
    String getByUsernameAndPassword(@PathVariable String multiUser);
}