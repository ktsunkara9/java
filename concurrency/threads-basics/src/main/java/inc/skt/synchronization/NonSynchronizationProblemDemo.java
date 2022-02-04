package inc.skt.synchronization;

public class NonSynchronizationProblemDemo {

	public static void main(String[] args) {

		Printer printer = Printer.getPrinterInstance();
		Thread t1 = new Thread(new PrinterThread(printer, "Java"));
		t1.start();
		Thread t2 = new Thread(new PrinterThread(printer, "Developer"));
		t2.start();
	}

}

class Printer {

	static Printer printer;

	private Printer() {
	}

	public static Printer getPrinterInstance() {
		if (printer == null)
			printer = new Printer();
		return printer;
	}

	void print(String msg) {
		System.out.println("[ " + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("]");
	}
}

class PrinterThread implements Runnable {

	private Printer printer;
	private String msg;

	public PrinterThread(Printer printer, String msg) {
		this.printer = printer;
		this.msg = msg;
	}

	public void run() {
		printer.print(msg);
	}

}