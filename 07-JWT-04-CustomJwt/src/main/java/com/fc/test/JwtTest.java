package com.fc.test;

import com.fc.util.JwtUtil;
import org.junit.Test;

import java.util.HashMap;

public class JwtTest {
    @Test
    public void testGetToken(){
        HashMap<String, Object> claim = new HashMap<>();

        claim.put("username","易烊千玺");
        String token = JwtUtil.getToken(claim, "yyqx");

        System.out.println(token);


    }
}
