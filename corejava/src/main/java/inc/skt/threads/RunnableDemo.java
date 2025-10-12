package inc.skt.threads;

public class RunnableDemo {

	public static void main(String[] args) {

		RunnableThread runnable1 = new RunnableThread();
		Thread t1 = new Thread(runnable1);

		Thread t2 = new Thread(runnable1);
		t1.start();
		t2.start();

	}

}

class RunnableThread implements Runnable {

	public void run() {
		for (int i = 1; i <= 25; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
