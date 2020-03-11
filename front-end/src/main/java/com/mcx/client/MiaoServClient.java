package com.mcx.client;

import com.alibaba.fastjson.JSONArray;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("miao-service")
public interface MiaoServClient {
    @GetMapping("/all")
    JSONArray getAll();
    @GetMapping("/small")
    JSONArray getSmall();
    @GetMapping("/medium")
    JSONArray getMedium();
    @GetMapping("/large")
    JSONArray getLarge();

}

