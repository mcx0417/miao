package com.mcx.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mcx.mapper.CatMapper;
import com.mcx.pojo.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@CrossOrigin(origins = "*", methods = {GET, POST, PUT, DELETE}, maxAge = 60L)
public class MiaoController {

    @Resource
    private CatMapper catMapper;


    @GetMapping("/all")
    public JSONArray getDistinctAll() {
        QueryWrapper<Cat> queryWrapper = new QueryWrapper<Cat>();
        queryWrapper.groupBy("category");
        JSONArray ja = JSONArray.parseArray(JSON.toJSONString(catMapper.selectList(queryWrapper)));
        /**/
        return ja;
    }

    @GetMapping("/small")
    public JSONArray getSmall() {
        QueryWrapper<Cat> queryWrapper = new QueryWrapper<Cat>();
        queryWrapper.eq("sizeid", 1);
        JSONArray ja = JSONArray.parseArray(JSON.toJSONString(catMapper.selectList(queryWrapper)));
        return ja;
    }

    @GetMapping("/medium")
    public JSONArray getmedium() {
        QueryWrapper<Cat> queryWrapper = new QueryWrapper<Cat>();
        queryWrapper.eq("sizeid", 2);
        JSONArray ja = JSONArray.parseArray(JSON.toJSONString(catMapper.selectList(queryWrapper)));
        return ja;
    }

    @GetMapping("/large")
    public JSONArray getLarge() {
        QueryWrapper<Cat> queryWrapper = new QueryWrapper<Cat>();
        queryWrapper.eq("sizeid", 3);
        JSONArray ja = JSONArray.parseArray(JSON.toJSONString(catMapper.selectList(queryWrapper)));
        return ja;
    }

    @GetMapping("/isloved/{id}")
    public int setLoved(@PathVariable int id) {
        Cat cat = new Cat();
        cat.setLoved(1);
        cat.setId(id);
        return catMapper.updateById(cat);
    }


}
