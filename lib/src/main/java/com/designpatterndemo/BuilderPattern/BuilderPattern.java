package com.designpatterndemo.BuilderPattern;

//产品生产线抽象类
abstract class Builder{
    public abstract void GetMaterial();
    public abstract void Making();
    public abstract Product Getresult();
}

//产品类
class Product{
    public void Show(){
        System.out.println("生产出了产品");
    }
}

//产品生产线
class ProductBuilder extends Builder{
    private Product product = new Product() ;
    @Override
    public void GetMaterial() {
        System.out.println("获取产品原料");
        //这里进行获取操作...
    }

    @Override
    public void Making() {
        System.out.println("制造产品");
        //这里进行制造操作...
    }

    @Override
    public Product Getresult() {
        return product;
    }

}


//控制者类
class Controler{
    public void Construct(ProductBuilder builder){
        builder.GetMaterial();
        builder.Making();
    }
}

//使用生产流水线
public class BuilderPattern {
    public static void main(String[] args){
        ProductBuilder mProductBuilder = new ProductBuilder();
        Controler mControler = new Controler();
        //生产产品
        mControler.Construct(mProductBuilder);
        Product product = mProductBuilder.Getresult();
        product.Show();

    }
}
