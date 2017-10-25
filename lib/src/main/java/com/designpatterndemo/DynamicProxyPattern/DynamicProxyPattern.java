package com.designpatterndemo.DynamicProxyPattern;

//部门类
interface Department {

    //部门谈判
    public  void Negotiate();
    //部门签约
    public  void Sign();
}


//广告部门，真正的谈判对象，也就是被代理的对象
class AdvertisingDepartment implements Department {

    @Override
    public void Negotiate() {
        System.out.println("广告部正在和应聘者谈判");
    }
    @Override
    public void Sign() {
        System.out.println("广告部和应聘者签好了合约");
    }

}

//产品部门，真正的谈判对象，也就是被代理的对象
class ProductDepartment implements Department {

    @Override
    public void Negotiate() {
        System.out.println("产品部正在和应聘者谈判");
    }
    @Override
    public void Sign() {
        System.out.println("产品部和应聘者签好了合约");
    }

}


//人事部动态代理两个部门的招聘工作流程
public class DynamicProxyPattern {
    public static void main(String[] arg){

        PersonnelDepartment personnelDepartment = new PersonnelDepartment();
        Department mAdvertisingDepartment = (Department) personnelDepartment.newProxyInstance(new AdvertisingDepartment());
        mAdvertisingDepartment.Negotiate();
        mAdvertisingDepartment.Sign();

        Department mProductDepartment = (Department) personnelDepartment.newProxyInstance(new ProductDepartment());
        mProductDepartment.Negotiate();
        mProductDepartment.Sign();
    }
}
