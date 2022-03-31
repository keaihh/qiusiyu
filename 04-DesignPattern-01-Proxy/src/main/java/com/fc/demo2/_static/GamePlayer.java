package com.fc.demo2._static;

public class GamePlayer implements GamePlay{
    @Override
    public void login() {
        System.out.println("我就是我");
    }

    @Override
    public void killBoss() {
        System.out.println("打怪");
    }

    @Override
    public void upGrade() {
        System.out.println("升级");
    }
}
