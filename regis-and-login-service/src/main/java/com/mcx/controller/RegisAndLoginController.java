package com.mcx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mcx.pojo.User;
import com.mcx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin(origins = "*", methods = {GET, POST, PUT, DELETE}, maxAge = 60L)
@Controller
public class RegisAndLoginController {

    @Resource
    private UserService userService;

    @ResponseBody
    @GetMapping("/register/{username}")
    public String getByUsername(@PathVariable String username) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        userQueryWrapper.allEq(params);
        User one = userService.getOne(userQueryWrapper);
        if (one != null) {
            return "register fail";
        } else {
            return "register success";
        }
    }

    @ResponseBody
    @PostMapping("/register/{multiUser}")
    public String UserRegister(@PathVariable String multiUser) {
        String[] split = multiUser.split("&");
        String username = split[0];
        String password = split[1];
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean save = userService.save(user);
        if (!save) {
            return "fault";
        } else {
            return "register success";
        }

    }

    @ResponseBody
    @GetMapping("/login/{multiUser}")
    public String getByUsernameAndPassword(@PathVariable String multiUser) {
        String[] split = multiUser.split("&");
        String username = split[0];
        String password = split[1];
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        params.put("password", password);
        userQueryWrapper.allEq(params);
        User one = userService.getOne(userQueryWrapper);
        if (one != null) {
            return "login success";
        } else {
            return "login fail";
        }
    }
}
