package observer;

public class LaoLi implements Person {

   private String name = "С��";

   public LaoLi() {
   }

   @Override
   public void getMessage(String s) {
       System.out.println(name + "�ӵ���С��������ĵ绰���绰�����ǣ�" + s);
   }

}
