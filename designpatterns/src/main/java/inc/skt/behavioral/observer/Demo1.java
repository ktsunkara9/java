package inc.skt.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

	public static void main(String[] args) {
		new ConcreteObserver();
	}

}

class Observable<T> {

	List<Observer<T>> observers = new ArrayList<>();

	void attach(Observer<T> observer) {
		observers.add(observer);
	}

	public void notifyObservers(T source, String propertyName, int value) {
		for (Observer<T> o : observers) {
			o.handle(new PropertyChangedEvent<T>(source, propertyName, propertyName));
		}
	}
}

class Person extends Observable<Person> {

	private int age;

	public Person() {
		System.out.println("Person");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("Current Age : " + this.age);

		System.out.println("New Age : " + age);
		if (this.age == age) {
			return;
		}
		this.age = age;
		notifyObservers(this, "age", age);
	}

	@Override
	public String toString() {
		return "Person [age=" + age + "]";
	}

}

interface Observer<T> {
	public abstract void handle(PropertyChangedEvent<T> event);
}

class ConcreteObserver implements Observer<Person> {

	public ConcreteObserver() {
		System.out.println("Concrete Observer ");
		Person person = new Person();
		person.attach(this);
		for (int i = 20; i < 24; i++) {
			person.setAge(i);
		}
		person.setAge(23);
	}

	@Override
	public void handle(PropertyChangedEvent<Person> event) {
		System.out.println(event.getSource() + " - " + event.getPropertyName() + " - " + event.getPropertyValue());
	}

}

class PropertyChangedEvent<T> {
	private T Source;
	private String propertyName;
	private String propertyValue;

	public PropertyChangedEvent(T source, String propertyName, String propertyValue) {
		super();
		Source = source;
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
	}

	public T getSource() {
		return Source;
	}

	public void setSource(T source) {
		Source = source;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

}