package com.designpatterndemo.AbstractFactoryPattern;

//容器产品抽象类
abstract class ContainerProduct extends Product{
    @Override
    public abstract void Show();
}

//模具产品抽象类
abstract class MouldProduct extends Product{
    @Override
    public abstract void Show();
}

//工厂抽象类
abstract class Factory{
    public abstract Product ManufactureContainer();
    public abstract Product ManufactureMould();
}

//抽象产品类
abstract class Product{
    public abstract void Show();
}

//容器产品A类
class ContainerProductA extends ContainerProduct{
    @Override
    public void Show() {
        System.out.println("生产出了容器产品A");
    }
}

//容器产品B类
class ContainerProductB extends ContainerProduct{
    @Override
    public void Show() {
        System.out.println("生产出了容器产品B");
    }
}


//模具产品A类
class MouldProductA extends MouldProduct{

    @Override
    public void Show() {
        System.out.println("生产出了模具产品A");
    }
}

//模具产品B类
class MouldProductB extends MouldProduct{

    @Override
    public void Show() {
        System.out.println("生产出了模具产品B");
    }
}


//容器工厂类
class FactoryA extends Factory{

    @Override
    public Product ManufactureContainer() {
        return new ContainerProductA();
    }

    @Override
    public Product ManufactureMould() {
        return new MouldProductA();
    }
}

//模具工厂类
class FactoryB extends Factory{

    @Override
    public Product ManufactureContainer() {
        return new ContainerProductB();
    }

    @Override
    public Product ManufactureMould() {
        return new MouldProductB();
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args){
        FactoryA mFactoryA = new FactoryA();
        FactoryB mFactoryB = new FactoryB();
        //客户需要容器产品A
        mFactoryA.ManufactureContainer().Show();

        //客户需要容器产品B
        mFactoryB.ManufactureContainer().Show();

        //客户需要模具产品A
        mFactoryA.ManufactureMould().Show();

        //客户需要模具产品B
        mFactoryB.ManufactureMould().Show();

    }
}
