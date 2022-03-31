package com.fc.demo2._static;

public class GamePlayProxy implements GamePlay{
    private GamePlay gamePlayer;

    public GamePlayProxy(GamePlay gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login() {
       gamePlayer.login();
    }

    @Override
    public void killBoss() {
       gamePlayer.killBoss();
    }

    @Override
    public void upGrade() {
       gamePlayer.upGrade();

       this.lickDraw();
    }
    public void lickDraw(){
        System.out.println("抽到了一个皮肤");
    }

}
