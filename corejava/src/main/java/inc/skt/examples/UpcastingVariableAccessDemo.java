package inc.skt.examples;

public class UpcastingVariableAccessDemo {

	public static void main(String[] args) {
		
		Box box = new BoxWeight(1, 2, 3, 4);
		
		// You can not access weight attribute of BoxWeight object from a superclass reference variable as its not present in the super class
		System.out.println("box Weight : "+ box.weight);
	}

}

class Box {
	private int h;
	private int w;
	private int d;

	public Box(int h, int w, int d) {
		super();
		this.h = h;
		this.w = w;
		this.d = d;
	}
}

class BoxWeight extends Box {
	private int weight;

	public BoxWeight(int h, int w, int d, int weight) {
		super(h, w, d);
		this.weight = weight;
	}
}