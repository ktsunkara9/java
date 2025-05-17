package inc.skt.threads;

public class SynchronizationDemo {

	// Run it multiple times to see the problem without syncronization
	public static void main(String[] args) {

		Printer p = Printer.getInstance();
		Thread t1 = new Thread(new PrintThread(p, "Java"));
		Thread t2 = new Thread(new PrintThread(p, "Developer"));
		Thread t3 = new Thread(new PrintThread(p, "Java"));
		Thread t4 = new Thread(new PrintThread(p, "Developer"));
		Thread t5 = new Thread(new PrintThread(p, "Java"));
		Thread t6 = new Thread(new PrintThread(p, "Developer"));
		Thread t7 = new Thread(new PrintThread(p, "Java"));
		Thread t8 = new Thread(new PrintThread(p, "Developer"));
		Thread t9 = new Thread(new PrintThread(p, "Java"));
		Thread t10 = new Thread(new PrintThread(p, "Developer"));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
	}

}

class PrintThread implements Runnable {

	Printer p;
	String msg;

	public PrintThread(Printer p, String msg) {
		this.p = p;
		this.msg = msg;
	}

	public void run() {
		p.printMsg(msg);
		p.printSynchronizedMsg(msg);
	}

}

class Printer {

	private static Printer printer = null;

	private Printer() {
	}

	public static Printer getInstance() {
		if (printer == null) {
			printer = new Printer();
		}
		return printer;
	}

	public void printMsg(String msg) {
		System.out.print("[ " + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" ]");
	}
	
	synchronized public void printSynchronizedMsg(String msg) {
		System.out.print("[ " + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" ]");
	}
	

}
