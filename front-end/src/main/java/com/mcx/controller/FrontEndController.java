package com.mcx.controller;


import com.alibaba.fastjson.JSONArray;
import com.mcx.client.LoveServClient;
import com.mcx.client.MiaoServClient;
import com.mcx.client.RegisAndLoginServClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class FrontEndController {

    @Resource
    private MiaoServClient miaoServClient;
    @Resource
    private LoveServClient loveServClient;
    @Resource
    private RegisAndLoginServClient regisAndLoginServClient;

    /**
     * 页面跳转
     */
    @GetMapping("/loginPage")
    public String loginPage() {
        return "/login.html";
    }

    @GetMapping("/registerPage")
    public String registerPage() {
        return "/register.html";
    }

    @GetMapping("/miaoPage")
    public String mainPage() {
        return "/miao.html";
    }

    /**
     *注册登陆
     */
    @ResponseBody
    @GetMapping("/register/{username}")
    public String registerCheck(@PathVariable String username) {
        return regisAndLoginServClient.registerCheck(username);
    }

    @ResponseBody
    @PostMapping("/register/{multiUser}")
    public String UserRegister(@PathVariable String multiUser) {
        return regisAndLoginServClient.UserRegister(multiUser);
    }

    @ResponseBody
    @GetMapping("/login/{multiUser}")
    public String getByUsernameAndPassword(@PathVariable String multiUser) {
        return regisAndLoginServClient.getByUsernameAndPassword(multiUser);
    }

    /**
     *喜爱
     */
    @ResponseBody
    @GetMapping("/love/{id}")
    public JSONArray findLoved(@PathVariable int id) {
        return loveServClient.findLoved(id);
    }

    @ResponseBody
    @DeleteMapping("/love/{multiId}")
    public int deleteLoved(@PathVariable String multiId) {
        return loveServClient.deleteLoved(multiId);
    }

    @ResponseBody
    @PostMapping("/love/{multiId}")
    public int setLoved(@PathVariable String multiId) {
        return loveServClient.setLoved(multiId);
    }

    /**
     * 猫咪信息
     */
    @ResponseBody
    @GetMapping("/miao/all")
    public JSONArray getAll() {
        return miaoServClient.getAll();
    }

    @ResponseBody
    @GetMapping("/miao/small")
    public JSONArray getSmall() {
        return miaoServClient.getSmall();
    }

    @ResponseBody
    @GetMapping("/miao/medium")
    public JSONArray getMedium() {
        return miaoServClient.getMedium();
    }

    @ResponseBody
    @GetMapping("/miao/large")
    public JSONArray getLarge() {
        return miaoServClient.getLarge();
    }



}
