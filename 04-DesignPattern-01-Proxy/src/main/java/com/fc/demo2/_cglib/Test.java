package com.fc.demo2._cglib;

import com.fc.demo2._jdk.GamePlayer;
import net.sf.cglib.proxy.Enhancer;

public class Test {
    @org.junit.Test
    public void test(){

        GamePlayer gamePlayer = new GamePlayer();

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(GamePlayer.class);

        enhancer.setCallback(new GameOffice());

        GamePlayer proxy = (GamePlayer) enhancer.create();

        proxy.login();
        proxy.killBoss();
        proxy.upGrade();
    }
}
