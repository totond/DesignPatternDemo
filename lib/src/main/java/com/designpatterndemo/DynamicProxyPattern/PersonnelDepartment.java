package com.designpatterndemo.DynamicProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class PersonnelDepartment implements InvocationHandler {

    // 代理对象
    private Object ProxyObject;
    //绑定关系，也就是关联到哪个接口（与具体的实现类绑定）的哪些方法将被调用时，执行invoke方法。

    public Object newProxyInstance(Object ProxyObject){
        this.ProxyObject =ProxyObject;
        //该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
        //第一个参数指定产生代理对象的类加载器，需要将其指定为和目标对象同一个类加载器
        //第二个参数要实现和目标对象一样的接口，所以只需要拿到目标对象的实现接口
        //第三个参数表明这些被拦截的方法在被拦截时需要执行哪个InvocationHandler的invoke方法
        //根据传入的目标返回一个代理对象
        return Proxy.newProxyInstance(ProxyObject.getClass().getClassLoader(),
                ProxyObject.getClass().getInterfaces(),this);
    }
    @Override
    //关联的这个实现类的方法被调用时将被执行
    //InvocationHandler接口的方法，proxy表示代理，method表示原对象被调用的方法，args表示方法的参数
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("人事部准备场地");
        Object result=null;

        switch (method.getName()) {
            case "Negotiate":
            try {
            /*原对象方法调用前代理的动作*/
                System.out.println("人事部邀请应聘者面试谈判");

                //运用java反射机制调用目标方法
                result = method.invoke(ProxyObject, args);

            /*原对象方法调用后代理的动作*/
                System.out.println("谈判成功，人事部制定合同");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("谈判失败");
                throw e;
            }
                break;
            case "Sign":
                try {
            //原对象方法调用前代理的动作
                    System.out.println("人事部邀请应聘者面试签约");

                    //运用java反射机制调用目标方法
                    result = method.invoke(ProxyObject, args);

            //原对象方法调用后代理的动作
                    System.out.println("签约成功，人事部安排新同事上班");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("签约失败");
                    throw e;
                }
                break;
        }
        System.out.println("----------------");
        return result;
    }

}