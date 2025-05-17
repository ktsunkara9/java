package inc.skt.threads;

public class ThreadDemo {

	public static void main(String[] args) {
		Run thread1 = new Run();
		thread1.start();

		Run thread2 = new Run();
		thread2.start();
	}

}

class Run extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println("" + i);
		}
	}
}