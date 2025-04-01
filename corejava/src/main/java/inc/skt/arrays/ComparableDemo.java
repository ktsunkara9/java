package inc.skt.arrays;

import java.util.Arrays;

public class ComparableDemo {

	public static void main(String[] args) {

		Dog[] dogs = new Dog[4];

		dogs[0] = new Dog(2);
		dogs[1] = new Dog(6);
		dogs[2] = new Dog(4);
		dogs[3] = new Dog(8);
		System.out.println(Arrays.toString(dogs));
		Arrays.sort(dogs);
		System.out.println(Arrays.toString(dogs));

	}

}

class Dog implements Comparable<Dog> {
	int size;

	Dog(int size) {
		this.size = size;
	}

	public String toString() {
		return this.size + "";
	}

	@Override
	public int compareTo(Dog dog) {
		if (this.size > dog.size) {
			return +1;
		}
		if (this.size < dog.size) {
			return -1;
		}
		return 0;
	}
}
