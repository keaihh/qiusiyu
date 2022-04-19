package com.fc.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

public class JwtUtil {
    //获取token
    public static String getToken(Map<String,Object> claim,String salt){
        claim.put("exp",System.currentTimeMillis());
        claim.put("iat",System.currentTimeMillis());
        //未编码的头部
        String jsonHeader="{\"alg\":\"HS256\"}";

        //编码后的头部
        String header = Base64.getEncoder().encodeToString(jsonHeader.getBytes(StandardCharsets.UTF_8));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPayload=null;
        try {
            jsonPayload = objectMapper.writeValueAsString(claim);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //编码后的载荷
        String payload = Base64.getEncoder().encodeToString(jsonPayload.getBytes(StandardCharsets.UTF_8));


        String signature = DigestUtils.md5Hex(header + "." + payload + salt);

        StringBuilder builder = new StringBuilder();

        builder.append(header)
                .append(".")
                .append(payload)
                .append(".")
                .append(signature);
        return new String(builder);


    }
    //验证token
//    public static Map<String,Object>
}
