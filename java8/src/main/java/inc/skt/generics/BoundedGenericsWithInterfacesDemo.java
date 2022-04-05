package inc.skt.generics;

import java.util.TreeSet;

public class BoundedGenericsWithInterfacesDemo {

	public static void main(String[] args) {
		TwoWheelrVehicle<Bike> bike = new TwoWheelrVehicle<>(new Bike("Pulsar", 99000.0));
		bike.print();
		
		TwoWheelrVehicle<Cycle> cycle = new TwoWheelrVehicle<>(new Cycle("Hero", 5000.0));
		cycle.print();
		
		TreeSet<String> hashSet = new TreeSet<>();
		hashSet.add("SKT");
	}

}

interface TwoWheeler {

}

class Bike implements TwoWheeler {
	String Company;
	Double price;

	public Bike(String company, Double price) {
		super();
		Company = company;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Bike [Company=" + Company + ", price=" + price + "]";
	}

}

class Cycle implements TwoWheeler {
	String name;
	Double price;

	public Cycle(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cycle [name=" + name + ", price=" + price + "]";
	}
}

class TwoWheelrVehicle<T extends TwoWheeler> {
	T twoWheeler;

	public TwoWheelrVehicle(T twoWheeler) {
		super();
		this.twoWheeler = twoWheeler;
	}

	public void print() {
		System.out.println("TwoWheelrVehicle [" + twoWheeler + "]");
	}

}