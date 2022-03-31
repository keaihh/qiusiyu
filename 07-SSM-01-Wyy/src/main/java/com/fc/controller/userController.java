package com.fc.controller;

import com.fc.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("users")
public class userController {
    @RequestMapping("update")
    public Map<String ,Object> update(@RequestBody User user){
        HashMap<String, Object> map = new HashMap<>();

        System.out.println(user);
        map.put("code",200);
        map.put("message","注册成功");
        map.put("success",true);
        map.put("data","姐不狂但拽");

        return map;
    }

}
