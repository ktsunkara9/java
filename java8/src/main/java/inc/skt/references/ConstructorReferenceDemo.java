package inc.skt.references;

public class ConstructorReferenceDemo {

	public static void main(String[] args) {
		Inter i1 = () -> new Sample();
		i1.m1().run();
		Inter i2 = Sample::new;
		i2.m1().run();
		
		Interf i3 = s -> new ArgsDemo(s.toUpperCase());
		i3.get("Krishna").run();
		
		Interf i4 = ArgsDemo::new;
		i4.get("Krishna").run();
		
		Inte i5 = s -> new NoArg();
		i5.get("Teja").run();;
		
	}

}

class Sample {
	public Sample() {
		System.out.println("In Sample Constructor");
	}

	public void run() {
		System.out.println("run() method in Sample");
	}
}

interface Inter {
	public abstract Sample m1();
}

interface Interf {
	public abstract ArgsDemo get(String s);
}

class ArgsDemo {
	private String s;
	public ArgsDemo() {
		System.out.println("No Arg Costructor");
	}

	public ArgsDemo(String s) {
		super();
		this.s = s;
	}

	public void run() {
		System.out.println("Provide String is : " + s);
	}
}


interface Inte {
	public abstract NoArg get(String s);
}

class NoArg {
	public NoArg() {
		System.out.println("No Arg Constructor");
	}
	public void run() {
		System.out.println("run in NoArg");
	}
}

