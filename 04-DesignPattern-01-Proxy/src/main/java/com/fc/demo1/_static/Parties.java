package com.fc.demo1._static;
//当事人，原告
public class Parties implements Lawsuit{
    @Override
    public void submit() {
        System.out.println("老板跑路了……");
    }

    @Override
    public void defend() {
        System.out.println("进行辩护，还我血汗钱~~~");
    }
}
