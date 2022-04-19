package com.fc.test;

import com.auth0.jwt.interfaces.Claim;
import com.fc.util.JwtUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JWTUtilTest {
    @Test
    public void testCreate(){
        HashMap<String, Object> claim = new HashMap<>();

        claim.put("id","1");
        claim.put("username","易烊千玺");

        String token = JwtUtil.createToken(claim,System.currentTimeMillis()+1000*60*30);
        System.out.println(token);
    }
    @Test
    public void testParse(){
        Map<String, Object> map = JwtUtil.getClaim("eyJ0eXAiOiJIUzI1NiIsImFsZyI6IkhTMjU2In0.eyIiOnsiaWQiOiIxIiwidXNlcm5hbWUiOiLmmJPng4rljYPnjroifSwiZXhwIjoxNjQ5MDQxOTM4ODUxfQ.-uNKaUNwNdEVmQnppxgIGFI5tV8ItMCOOji4BSLlUy0");

        Set<Map.Entry<String, Object>> entries = map.entrySet();

        for (Map.Entry<String, Object> entry:entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
