package inc.skt.threads;

public class SynchronizedDemo {

	public static void main(String[] args) {
		Writer writer = Writer.getInstance();
		Thread t1 = new Thread(new WriterThread(writer, "Java"));
		Thread t2 = new Thread(new WriterThread(writer, "Developer"));
		t1.start();
		t2.start();
	}

}

class Writer {
	private static Writer instance = null;
	private Writer() {}
	
	public static Writer getInstance() {
		if(instance == null) {
			instance = new Writer();
		}
		return instance;
	}
	
	synchronized public void write(String msg) {
		System.out.print("[ " + msg);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" ]");
	}
}

class WriterThread implements Runnable {
	Writer writer;
	String msg;
	
	public WriterThread(Writer writer, String msg) {
		this.writer = writer;
		this.msg = msg;
	}

	public void run() {
		writer.write(msg);
	}
}
