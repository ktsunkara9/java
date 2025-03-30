package inc.skt.designpatterns;

public class SingletonDemo {

	public static void main(String[] args) {

		Singleton singleton1 = Singleton.getSingleton();
		Singleton singleton2 = Singleton.getSingleton();
		
		System.out.println(singleton1 == singleton2);
		
		Singleton.instance = null;
		System.out.println(singleton1);
		System.out.println(singleton2);
	}

}

class Singleton {
	
	static Singleton instance;
	
	private Singleton() {}
	
	public static Singleton getSingleton() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
}