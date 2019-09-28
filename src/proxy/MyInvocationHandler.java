package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
    //Ҫ������Ķ���
    private Object target;
    MyInvocationHandler(){
 
    }
    MyInvocationHandler(Object target){
        super();
        this.target=target;
    }
 
    /**
     *
     * @param proxy ������
     * @param method ��ִ�еķ���
     * @param args  ִ�з���ʱ��Ҫ�õ��Ĳ���
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
