package inc.skt.generics;

public class BoudedGenericsWithClassesDemo {

	public static void main(String[] args) {
		Creature<Cat> cat = new Creature<>(new Cat("Meow", 2));
		cat.eat();

		Creature<Dog> dog = new Creature<>(new Dog("BowBow", 4));
		dog.eat();
	}

}

class Animal {
}

class Dog extends Animal {
	private String name;
	private int size;

	public Dog(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", size=" + size + "]";
	}

}

class Creature<T extends Animal> {
	T animal;

	public Creature(T animal) {
		this.animal = animal;
	}

	public void eat() {
		System.out.println(animal + " eats");
	}
}