package test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class Test {

	transient String aa;
	volatile static int count;
	
	private Test() {
		System.out.println("123");
	}
	public static void main(String[] args) {
		Test t = new Test();
		// TODO Auto-generated method stub
		String str = "1212121313213u321p10";
		int u = str.indexOf("u");
		int p = str.indexOf("p");
		int userId = Integer.parseInt(str.substring(u + 1, p));
		double price = Double.parseDouble(str.substring(p + 1));
		System.out.println(userId);
		System.out.println(price);
		System.out.println(65 >>> 16);
		
		// ��ȡ Java �̹߳��� MXBean
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		// ����Ҫ��ȡͬ���� monitor �� synchronizer ��Ϣ������ȡ�̺߳��̶߳�ջ��Ϣ
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
		// �����߳���Ϣ������ӡ�߳� ID ���߳�������Ϣ
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
		}
		
		System.out.println(1 & 10);
		
		new Thread() {
			@Override
			public void run() {
				for (int i = 0;i<10;i++) {
					count++;
					System.out.println(Thread.currentThread().getName() + count);
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				for (int i = 0;i<10;i++) {
					count++;
					System.out.println(Thread.currentThread().getName() + count);
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}.start();
	}

}
