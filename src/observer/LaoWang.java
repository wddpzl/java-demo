package observer;

public class LaoWang implements Person {

   private String name = "С��";

   public LaoWang() {
   }

   @Override
   public void getMessage(String s) {
       System.out.println(name + "�ӵ���С��������ĵ绰���绰�����ǣ�" + s);
   }

}
