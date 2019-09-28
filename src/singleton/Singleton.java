package singleton;

public class Singleton {
	private static class SingletonHolder {  
		private static final Singleton INSTANCE = new Singleton();
	}
	
	private Singleton (){}; // ���췽��˽��
	
	public static final Singleton getInstance() {  
		return SingletonHolder.INSTANCE;  
	}
}
