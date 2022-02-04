package inc.skt.synchronization;

public class SynchronizationDemo {

	public static void main(String[] args) {
		SynchronizedPrinter printer = SynchronizedPrinter.getPrinterInstance();
		Thread t1 = new Thread(new SynchronizedPrinterThread(printer, "Java"));
		t1.start();
		Thread t2 = new Thread(new SynchronizedPrinterThread(printer, "Developer"));
		t2.start();
	}

}

class SynchronizedPrinter {
	static SynchronizedPrinter printer;

	private SynchronizedPrinter() {
	}

	public static SynchronizedPrinter getPrinterInstance() {
		if (printer == null)
			printer = new SynchronizedPrinter();
		return printer;
	}

	synchronized public void print(String msg) {
		System.out.print("[ " + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" ]");
	}
}

class SynchronizedPrinterThread implements Runnable {
	SynchronizedPrinter printer;
	String msg;

	public SynchronizedPrinterThread(SynchronizedPrinter printer, String msg) {
		this.printer = printer;
		this.msg = msg;
	}

	public void run() {
		printer.print(msg);
	}

}