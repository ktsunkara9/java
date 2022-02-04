package inc.skt.synchronization;

public class DeadlockDemo {

	public static void main(String[] args) {
		Factory factory = new Factory();
		Thread consumer = new Thread(new Consumer(factory, 5));
		consumer.start();
		Thread producer = new Thread(new Producer(factory, 10));
		producer.start();
	}

}

class Factory {
	int stock = 0;

	synchronized void produce(int n) {
		stock = stock + n;
		System.out.println("Stock is updated : " + stock);
	}

	synchronized void consume(int n) {
		System.out.println("Need " + n + " items, stock available is : " + stock);
		while (stock < n) {
			System.out.println("Waiting for Producer to update stock");
		}
		stock = stock - n;

		System.out.println("Consumed " + n + " items");
	}
}

class Producer implements Runnable {
	Factory factory;
	int n;

	public Producer(Factory factory, int n) {
		super();
		this.factory = factory;
		this.n = n;
	}

	public void run() {
		// update stock
		factory.produce(n);
	}

}

class Consumer implements Runnable {

	Factory factory;
	int n;

	public Consumer(Factory factory, int n) {
		super();
		this.factory = factory;
		this.n = n;
	}

	public void run() {
		// consume stock
		factory.consume(n);
	}

}