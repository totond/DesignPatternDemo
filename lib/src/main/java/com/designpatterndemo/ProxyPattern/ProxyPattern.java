package com.designpatterndemo.ProxyPattern;


//公司类
abstract class Company {
    //公司名字
    public String CompanyName;
    //公司谈判
    public abstract void Negotiate();
    //公司签约
    public abstract void Sign();
}

//小成的公司，真正的谈判对象，也就是被代理的对象
class XiaoChengCompany extends Company {

    @Override
    public void Negotiate() {
        System.out.println(CompanyName +"正在与其他公司谈判");
    }
    @Override
    public void Sign() {
        System.out.println(CompanyName +"签好了合约");
    }

}

//小成公司的代理
class XiaoChengCompanyProxy extends Company {
    private XiaoChengCompany mXiaoChengCompany;

    //代理建立的构造函数，建立一个公司实例，把公司名信息给它
    public XiaoChengCompanyProxy(String CompanyName){
        mXiaoChengCompany = new XiaoChengCompany();
        mXiaoChengCompany.CompanyName = CompanyName;
    }

    @Override
    public void Negotiate() {
        mXiaoChengCompany.Negotiate();
        ExtraBusiness();
    }

    @Override
    public void Sign() {
        mXiaoChengCompany.Sign();
    }

    //代理的额外动作
    public void ExtraBusiness(){
        System.out.println("代理额外谈好了一单生意");
    }
}

//使用代理和进行其他公司进行谈判签约的过程
public class ProxyPattern {
    public static void main(String[] arg){
        XiaoChengCompanyProxy mXiaoChengCompanyProxy = new XiaoChengCompanyProxy("小成的公司");
        mXiaoChengCompanyProxy.Negotiate();
        mXiaoChengCompanyProxy.Sign();
    }
}
