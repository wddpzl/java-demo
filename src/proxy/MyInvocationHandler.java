package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
    //要被代理的对象
    private Object target;
    MyInvocationHandler(){
 
    }
    MyInvocationHandler(Object target){
        super();
        this.target=target;
    }
 
    /**
     *
     * @param proxy 代理者
     * @param method 被执行的方法
     * @param args  执行方法时，要用到的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        if("getName".equals(name)){
            System.out.println("----before "+method.getName());
            Object res = method.invoke(target, args);
            System.out.println("----after"+method.getName());
            return res;
 
        }else{
            return method.invoke(target,args);
        }
    }
    
    public static void main(String[] args) {
        MyInterface myInterface=new MyInterfaceImpl();
        MyInvocationHandler myInvocationHandler= new MyInvocationHandler(myInterface);
        MyInterface inter= (MyInterface) Proxy.newProxyInstance(myInterface.getClass().getClassLoader(),myInterface.getClass().getInterfaces(),myInvocationHandler);
        inter.getName();
        inter.getAge();
    }
}
