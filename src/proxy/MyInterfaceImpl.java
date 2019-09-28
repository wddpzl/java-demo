package proxy;

public class MyInterfaceImpl implements  MyInterface {
    @Override
    public String getName() {
        System.out.println("tom");
        return "Tom";
    }
 
    @Override
    public int getAge() {
        System.out.println(11);
        return 11;
    }
}