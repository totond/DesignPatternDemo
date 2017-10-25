package com.designpatterndemo.StrategyPattern;

//销售部门制定的策略抽象类
abstract class SalesStrategy {
    //把为客户定制的销售策略展示的方法
    public abstract void show();
}

//为A类公司准备的销售策略A
class StrategyA extends SalesStrategy{

    @Override
    public void show() {
        System.out.println("为客户展示销售策略A");
    }
}

//为B类公司准备的销售策略A
class StrategyB extends SalesStrategy{

    @Override
    public void show() {
        System.out.println("为客户展示销售策略B");
    }
}

class StrategyCostomied extends SalesStrategy{

    @Override
    public void show() {
        System.out.println("没有适合此类公司的销售策略,需要自定义策略");
    }
}

//销售员类，用于连接上下文，即把销售策略推荐给客户
class SalesMan{
    private SalesStrategy SalesStrategyImpl;

    //生成销售员实例，这里使用一个简单的工厂模式，让销售员根据传入的参数选择推荐策略
    public SalesMan(String Company) {
        switch (Company) {
            case "A":
                SalesStrategyImpl = new StrategyA();
                break;
            case "B":
                SalesStrategyImpl = new StrategyB();
                break;
            default:
                SalesStrategyImpl = new StrategyCostomied();

        }

    }

    //展示推荐的策略
    public void SalesManShow(){
        SalesStrategyImpl.show();
    }

}

public class StrategyPattern {
    public static void main(String[] args){
        SalesMan mSalesMan ;
        System.out.println("对于A类客户：");
        mSalesMan = new SalesMan("A");
        mSalesMan.SalesManShow();
        System.out.println("对于B类客户：");
        mSalesMan = new SalesMan("B");
        mSalesMan.SalesManShow();
        System.out.println("对于其他类客户：");
        mSalesMan = new SalesMan("其他");
        mSalesMan.SalesManShow();

    }
}
