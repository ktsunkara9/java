package inc.skt.synchronization;

public class DeadlockSolutionDemo {

	public static void main(String[] args) {
		CarFactory factory = new CarFactory();
		Thread consumer = new Thread(new CarConsumer(factory, 5));
		consumer.start();
		Thread producer = new Thread(new CarProducer(factory, 10));
		producer.start();
	}

}

class CarFactory {
	int stock = 0;

	synchronized void produce(int n) {
		stock += n;
		System.out.println("updated stock : " + stock);
		notify();
	}

	synchronized void consume(int n) {
		System.out.println("need " + n + " cars, stock is " + stock);
		while (stock < n) {
			System.out.println("Waiting for Producer to update Stock");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stock -= n;
		System.out.println("Consumed " + n+ " Cars");
	}
}

class CarProducer implements Runnable {

	CarFactory factory;
	int n;

	public CarProducer(CarFactory factory, int n) {
		super();
		this.factory = factory;
		this.n = n;
	}

	public void run() {
		factory.produce(n);
	}
}

class CarConsumer implements Runnable {
	CarFactory factory;
	int n;

	public CarConsumer(CarFactory factory, int n) {
		super();
		this.factory = factory;
		this.n = n;
	}

	public void run() {
		factory.consume(n);
	}

}