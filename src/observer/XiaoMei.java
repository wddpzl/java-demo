package observer;

import java.util.ArrayList;
import java.util.List;

public class XiaoMei {
	List<Person> list = new ArrayList<Person>();
    public XiaoMei(){
    }

    public void addPerson(Person person){
        list.add(person);
    }

    //����list�����Լ���֪ͨ���͸����а����Լ�����
    public void notifyPerson() {
        for(Person person:list){
            person.getMessage("���ǹ����ɣ�˭�ȹ���˭��������һ�������Ϸ!");
        }
    }
}
