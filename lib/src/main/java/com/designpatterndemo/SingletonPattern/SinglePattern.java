package com.designpatterndemo.SingletonPattern;

//单例仓库类
class StoreHouse {

    //仓库商品数量
    private int quantity = 100;
    private static StoreHouse ourInstance  = new StoreHouse();;

    public static StoreHouse getInstance() {

        return ourInstance;
    }

    //封闭构造函数
    private StoreHouse() {
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}

//仓库类
//class StoreHouse {
//    private int quantity = 100;
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//}

//搬货工人类
class Carrier{
    public StoreHouse mStoreHouse;
    public Carrier(StoreHouse storeHouse){
        mStoreHouse = storeHouse;
    }
    //搬货进仓库
    public void MoveIn(int i){
        mStoreHouse.setQuantity(mStoreHouse.getQuantity()+i);
    }
    //搬货出仓库
    public void MoveOut(int i){
        mStoreHouse.setQuantity(mStoreHouse.getQuantity()-i);
    }
}

//工人搬运测试
public class SinglePattern {
    public static void main(String[] args){
        StoreHouse mStoreHouse1 = StoreHouse.getInstance();
        StoreHouse mStoreHouse2 = StoreHouse.getInstance();
//        StoreHouse mStoreHouse1 = new StoreHouse();
//        StoreHouse mStoreHouse2 = new StoreHouse();
        Carrier Carrier1 = new Carrier(mStoreHouse1);
        Carrier Carrier2 = new Carrier(mStoreHouse2);

        System.out.println("两个是不是同一个？");

        if(mStoreHouse1.equals(mStoreHouse2)){
            System.out.println("是同一个");
        }else {
            System.out.println("不是同一个");
        }
        //搬运工搬完货物之后出来汇报仓库商品数量
        Carrier1.MoveIn(30);
        System.out.println("仓库商品余量："+Carrier1.mStoreHouse.getQuantity());
        Carrier2.MoveOut(50);
        System.out.println("仓库商品余量："+Carrier2.mStoreHouse.getQuantity());
    }
}
