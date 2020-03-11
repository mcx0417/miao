package com.mcx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mcx.mapper.LoveMapper;
import com.mcx.pojo.Love;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin(origins = "*", methods = {GET, POST, PUT, DELETE}, maxAge = 60L)
@RestController
public class LoveController {

    @Resource
    private LoveMapper loveMapper;


    @PostMapping("/love/{multiId}")
    public int setLoved(@PathVariable String multiId) {
        String[] split = multiId.split("&");
        int i1 = Integer.parseInt(split[0]);
        int i2 = Integer.parseInt(split[1]);
        Love love = new Love();
        love.setUserid(i1);
        love.setMiaoid(i2);
        return loveMapper.insert(love);
    }

    @DeleteMapping("/love/{multiId}")
    public int deleteLoved(@PathVariable String multiId) {
        String[] split = multiId.split("and");
        int i1 = Integer.parseInt(split[0]);
        int i2 = Integer.parseInt(split[1]);
        QueryWrapper queryWrapper = new QueryWrapper();
        Map<String, Object> params = new HashMap<>();
        params.put("userid", i1);
        params.put("miaoid", i2);
        queryWrapper.allEq(params);
        return loveMapper.delete(queryWrapper);
    }

    @GetMapping("/love/{userId}")
    public JSONArray findLoved(@PathVariable int userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        Map<String, Integer> params = new HashMap<>();
        params.put("userid", userId);
        queryWrapper.allEq(params);
        JSONArray ja = JSONArray.parseArray(JSON.toJSONString(loveMapper.selectList(queryWrapper)));
        return ja;
    }

}
