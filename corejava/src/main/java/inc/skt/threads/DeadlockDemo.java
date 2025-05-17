package inc.skt.threads;

public class DeadlockDemo {
	public static void main(String[] args) {
		Factory factory = new Factory();
		Thread t1 = new Thread(new ConsumerThread(factory, 5));
		t1.start();
		Thread t2 = new Thread(new ProducerThread(factory, 10));
		t2.start();
	}
}

class Factory {

	int stock = 0;

	synchronized public void produce(int n) {
		stock += n;
		System.out.println("Produced " + n + " cars");
		notify();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized public void consume(int n) {
		System.out.println("Got an order for " + n + " cars " + "Current Stock is: " + stock);
		while (stock < n) {
			System.out.println("Waiting for producer to update stock");
			try {
				System.out.println("Calling wait ...");
				wait();
			} catch (Exception e) {}
		}
		stock -= n;
		System.out.println("Consumed " + n + " cars");
	}
}

class ProducerThread implements Runnable {

	Factory f;
	int n;

	public ProducerThread(Factory f, int n) {
		this.f = f;
		this.n = n;
	}

	public void run() {
		f.produce(n);
	}
}

class ConsumerThread implements Runnable {

	Factory f;
	int n;

	public ConsumerThread(Factory f, int n) {
		this.f = f;
		this.n = n;
	}

	public void run() {
		f.consume(n);
	}
}