package com.fc.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.util.*;

public class JwTest {
    @Test
    public void encode1(){
        HashMap<String, Object> header = new HashMap<>();

        header.put("alg","HS256");
        header.put("type","JWT");


        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,30);

        String token = JWT
                .create()
                .withHeader(header)
                .withClaim("id",1)
                .withClaim("username","易烊千玺")
                .withClaim("info",new Date())
                .withClaim("lastAccessTime",new Date())
                .withClaim("exp",instance.getTime())
                //发布者
                .withIssuer("玛卡巴卡")
                //发布时间
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256("123456"));
        System.out.println(token);
    }
    @Test
    public void encode(){
        HashMap<String, Object> header = new HashMap<>();

        header.put("alg","HS256");
        header.put("type","JWT");

        HashMap<String, Object> payload = new HashMap<>();

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,40);

        payload.put("id",1);
        payload.put("username","易烊千玺");
        payload.put("info",new Date());
        payload.put("lastAccessTime",new Date());
        payload.put("exp",instance.getTime());



        String token = JWT
                .create()
                .withHeader(header)
                .withPayload(payload)
                .sign(Algorithm.HMAC256("123456"));
        System.out.println(token);
    }
    @Test
    public void decode(){
        //获取验证器
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("123456")).build();

        DecodedJWT decodedJWT = verifier.verify("eyJ0eXAiOiJKV1QiLCJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJsYXN0QWNjZXNzVGltZSI6MTY0OTAzNzY4MywiaWQiOjEsImV4cCI6MTY0OTAzNzcyMywidXNlcm5hbWUiOiLmmJPng4rljYPnjroiLCJpbmZvIjoxNjQ5MDM3NjgzfQ.G3xKxOvK8dRNGbUQBiZkwbPpUcCjA4O50Aax1qOmIv0");

        System.out.println(decodedJWT.getHeader());
        System.out.println(decodedJWT.getPayload());
        System.out.println(decodedJWT.getAlgorithm());
        System.out.println(decodedJWT.getSignature());
        System.out.println(decodedJWT.getExpiresAt());

        Map<String, Claim> map = decodedJWT.getClaims();
        Set<Map.Entry<String, Claim>> entries = map.entrySet();
        for (Map.Entry<String,Claim> entry:entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println(decodedJWT.getClaim("username"));
        System.out.println(decodedJWT.getClaim("password"));
        System.out.println(decodedJWT.getClaim("info"));
        System.out.println(decodedJWT.getClaim("lastAccessTime"));
    }
}
