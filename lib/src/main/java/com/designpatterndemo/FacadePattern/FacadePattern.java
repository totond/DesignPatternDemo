package com.designpatterndemo.FacadePattern;

//工厂A的工作
class MoldingFactoryA {
    public void ProductAManufacture(){
        System.out.println("注塑产品工厂A生产产品！");
    }

    public void ProductADelivery(){
        System.out.println("注塑产品工厂A配送产品！");
    }

    public void ProductAReport(){
        System.out.println("注塑产品工厂A汇报工作！");
    }

}

//工厂B的工作
class MoldingFactoryB {
    public void ProducrBManufacture(){
        System.out.println("注塑产品工厂B生产产品！");
    }

    public void ProductBDelivery(){
        System.out.println("注塑产品工厂B配送产品！");
    }

    public void ProductBReport(){
        System.out.println("注塑产品工厂B汇报工作！");
    }

}

//工厂办事处，也就是两个加工厂的“外观”
class FactoryOffice{
    MoldingFactoryA mmoldingFactoryA;
    MoldingFactoryB mmoldingFactoryB;

    //构造函数建造工厂实例
    public FactoryOffice(){
        mmoldingFactoryA = new MoldingFactoryA();
        mmoldingFactoryB = new MoldingFactoryB();
    }

    //管理工厂生产
    public void FactoryManufacture(){
        mmoldingFactoryA.ProductAManufacture();
        mmoldingFactoryB.ProducrBManufacture();
    }

    //管理工厂配送
    public void FactoryDelivery(){
        mmoldingFactoryA.ProductADelivery();
        mmoldingFactoryB.ProductBDelivery();
    }

    //管理工厂汇报
    public void FactoryReport(){
        mmoldingFactoryA.ProductAReport();
        mmoldingFactoryB.ProductBReport();
    }
}

public class FacadePattern {
    //小成老板用办事处管理两间工厂的工作
    public static void main(String[] arg){
        FactoryOffice mfactoryOffice = new FactoryOffice();
        mfactoryOffice.FactoryManufacture();
        mfactoryOffice.FactoryDelivery();
        mfactoryOffice.FactoryReport();
    }
}


