package inc.skt.behavioral.observer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeliverySystemDemo {

	public static void main(String[] args) {
		Publisher publisher = new Publisher();
		Store store = new Store("Future Group");
		publisher.subsribe(store);
		Customer cusomer = new Customer("Krishna");
		publisher.subsribe(cusomer);
		publisher.setLocation("Mumbai");
		publisher.setLocation("Hyderabad");
		publisher.setLocation("Vijayawada");
		publisher.setLocation("Desination");
	}

}

abstract class Subject {

	List<Subscriber> subscribers = new ArrayList<>();

	void subsribe(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	void unsubscribe(Subscriber subscriber) {
		subscribers.remove(subscriber);
	}

	abstract void notifyObservers(String location);
}

class Publisher extends Subject {

	private String location;

	public Publisher() {
	}

	public Publisher(String location) {
		super();
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		if (this.location == location) {
			return;
		}
		this.location = location;
		update();
	}

	void update() {
		notifyObservers(location);
	}

	@Override
	void notifyObservers(String location) {
		for (Subscriber s : subscribers) {
			s.update(location);
		}
	}
}

interface Subscriber {
	void update(String location);
}

class Store implements Subscriber {

	private String storeName;

	public Store() {
	}

	public Store(String storeName) {
		this.storeName = storeName;
	}

	@Override
	public void update(String location) {
		showLocation(location);
	}

	void showLocation(String location) {
		System.out.println("Hello " + storeName + ", your Package reached: " + location + " on "
				+ new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date()));
	}

}

class Customer implements Subscriber {
	private String customerName;

	public Customer() {
	}

	public Customer(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public void update(String location) {
		showLocation(location);
	}

	void showLocation(String location) {
		System.out.println("Hi " + customerName + ", your Package arrived at: " + location + " on "
				+ new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date()));
	}

}