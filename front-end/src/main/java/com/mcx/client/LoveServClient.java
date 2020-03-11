package com.mcx.client;

import com.alibaba.fastjson.JSONArray;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("love-service")
public interface LoveServClient {

    @GetMapping("/love/{userId}")
    JSONArray findLoved(@PathVariable int userId);

    @DeleteMapping("/love/{multiId}")
    int deleteLoved(@PathVariable String multiId);

    @PostMapping("/love/{multiId}")
    int setLoved(@PathVariable String multiId);


}

