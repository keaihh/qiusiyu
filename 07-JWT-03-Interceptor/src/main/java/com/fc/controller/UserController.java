package com.fc.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.util.JwtUtil;
import com.fc.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("login")
    public Map<String,Object> login(User user) {
        UserVo vo = userService.login(user.getUsername(), user.getPassword());
        HashMap<String, Object> map = new HashMap<>();
        if (vo == null) {
            map.put("message", "登陆失败");
            map.put("code", "-1");
            map.put("success", false);
        } else {
            HashMap<String, Object> claim = new HashMap<>();
            claim.put("username",vo.getUsername());
            claim.put("lastAccessTime",vo.getLastAccessTime());
            String token = JwtUtil.createToken(claim, System.currentTimeMillis() + 1000 * 10);
            map.put("message", "登陆成功");
            map.put("code", 200);
            map.put("success", true);
            map.put("data", vo);
            map.put("token",token);


        }
        return map;
    }
    @RequestMapping("verifyToken")
    public Map<String ,Object> verifyToken(String token){
        HashMap<String, Object> map = new HashMap<>();
        map.put("success",true);
        map.put("code",-1);
        map.put("message","该干啥干啥");

        return map;

    }
}
