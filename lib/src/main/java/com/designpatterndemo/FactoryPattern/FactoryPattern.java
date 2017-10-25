package com.designpatterndemo.FactoryPattern;

//工厂抽象类
abstract class Factory{
    public abstract Product Manufacture();
}

//抽象产品类
abstract class Product{
    public abstract void Show();
}

class  ProductA extends  Product{

    @Override
    public void Show() {
        System.out.println("生产出了产品A");
    }
}

//产品B类
class  ProductB extends  Product{

    @Override
    public void Show() {
        System.out.println("生产出了产品B");
    }
}

//工厂A类
class  FactoryA extends Factory{

    @Override
    public Product Manufacture() {
        return new ProductA();
    }
}

//工厂B类
class  FactoryB extends Factory{

    @Override
    public Product Manufacture() {
        return new ProductB();
    }
}

//生产工作流程
public class FactoryPattern {
    public static void main(String args[]){
        //客户要产品A
        FactoryA mFactoryA = new FactoryA();
        mFactoryA.Manufacture().Show();

        //客户要产品B
        FactoryB mFactoryB = new FactoryB();
        mFactoryB.Manufacture().Show();
    }
}
