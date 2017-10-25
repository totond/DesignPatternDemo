package com.designpatterndemo.AdapterPattern;

//适配器接口
interface Adapter{
    public void Convert();
}

//机器抽象类
abstract class Machine{
    public abstract void Work();
}

//国内220V电源
class PowerPort220V{
    public void Output(){
        System.out.println("电源输出220V电压");
    }
}

//对象适配器
class Adapter220V  implements Adapter{
    private PowerPort220V powerPort220V;

    public Adapter220V (PowerPort220V powerPort220V){
        this.powerPort220V = powerPort220V;
    }

    public void Output() {
        powerPort220V.Output();
        System.out.println("适配器直接将220V电压输出给国产机器使用");
    }
    @Override
    public void Convert(){
        System.out.println("适配器将220V电压转换为110V电压，输出给进口机器使用");
    }
}


//国产机器类
class DomesticMachine extends Machine{

    @Override
    public void Work() {
        System.out.println("国产机器正常运行");
    }
}

//进口机器类
class ImportedMachine extends Machine{

    @Override
    public void Work() {
        System.out.println("进口机器正常运行");
    }
}

//机器供电启动流程
public class AdapterPattern {
    public static void main(String[] args){
        PowerPort220V mPowerPort220V = new PowerPort220V();
        Adapter220V mAdapter220V = new Adapter220V(mPowerPort220V);
        DomesticMachine mDomesticMachine = new DomesticMachine();
        ImportedMachine mImportedMachine = new ImportedMachine();
        mAdapter220V.Output();
        mDomesticMachine.Work();
        mAdapter220V.Convert();
        mImportedMachine.Work();
    }
}
