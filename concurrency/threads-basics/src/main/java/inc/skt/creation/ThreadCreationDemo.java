package inc.skt.creation;

public class ThreadCreationDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> System.out.println("Thread 1"));
		t1.start();
		
		Thread t2 = new CustomThread();
		t2.start();
		
		Thread t3 = new Thread(new RunnableImpl());
		t3.start();
	}

}

class CustomThread extends Thread {
	public void run() {
		System.out.println("Custom Thread");
	}
}


class RunnableImpl implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable Thread");
	}
	
}