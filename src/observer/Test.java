package observer;

public class Test {
	public static void main(String[] args) {

       XiaoMei xiao_mei = new XiaoMei();
       LaoWang lao_wang = new LaoWang();
       LaoLi lao_li = new LaoLi();

       //С����С����С�����ﶼע����һ��
       xiao_mei.addPerson(lao_wang);
       xiao_mei.addPerson(lao_li);

       //С����С����С���֪ͨ
       xiao_mei.notifyPerson();
   }
}
