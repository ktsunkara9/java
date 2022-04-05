package inc.skt.generics;

public class GenericsWithClassesDemo {

	public static void main(String[] args) {
		IntegerPrinter integerPrinter = new IntegerPrinter(5);
		integerPrinter.print();
		StringPrinter stringPrinter = new StringPrinter("skt");
		stringPrinter.print();
		Cat cat = new Cat("meow", 2);
		CatPrinter catPrinter = new CatPrinter(cat);
		catPrinter.print();

		System.out.println("=======================Using a Generic Printer==============================");
		// Instead of creating multiple classes to print multiple types we create a
		// class Printer which takes anything & print it
		Printer<Integer> printer1 = new Printer<>(5);
		printer1.print();
		Printer<String> printer2 = new Printer<>("SKT");
		printer2.print();
		Printer<Cat> printer3 = new Printer<>(cat);
		printer3.print();
		
	}

}

class Printer<T> {
	T thingToPrint;

	public Printer(T thingToPrint) {
		super();
		this.thingToPrint = thingToPrint;
	}

	public void print() {
		System.out.println(thingToPrint);
	}
}

class IntegerPrinter {
	Integer i;

	public IntegerPrinter(Integer i) {
		this.i = i;
	}

	public void print() {
		System.out.println(i);
	}

}

class StringPrinter {
	String s;

	public StringPrinter(String s) {
		super();
		this.s = s;
	}

	public void print() {
		System.out.println(s);
	}
}

class Cat extends Animal{
	String name;
	int size;

	public Cat(String name, int size) {
		this.name = name;
		this.size = size;
	}

	@Override
	public String toString() {
		return "cat [name=" + name + ", size=" + size + "]";
	}
}

class CatPrinter {

	Cat cat;

	public CatPrinter(Cat cat) {
		this.cat = cat;
	}

	public void print() {
		System.out.println(cat);
	}
}

