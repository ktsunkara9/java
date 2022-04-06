package inc.skt.structural.decorator;

interface Shape {
	public abstract String info();
}

class Circle implements Shape {

	private int radius;

	public Circle() {
	}

	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	void resize(int factor) {
		this.radius *= factor;
	}

	@Override
	public String info() {
		return "A Circle With Radius " + radius;
	}

}

class Square implements Shape {

	private int side;

	public Square() {
	}

	public Square(int side) {
		super();
		this.side = side;
	}

	@Override
	public String info() {
		return "A Square with side " + this.side;
	}

}

class ColoredShape implements Shape {

	private String color;
	private Shape shape;

	public ColoredShape() {
	}

	public ColoredShape(String color, Shape shape) {
		this.color = color;
		this.shape = shape;
	}

	@Override
	public String info() {
		return shape.info() + " has Color " + color;
	}
}

class TrasparentShape implements Shape {

	private int transparency;
	private Shape shape;

	public TrasparentShape() {
	}

	public TrasparentShape(int transparency, Shape shape) {
		super();
		this.transparency = transparency;
		this.shape = shape;
	}

	@Override
	public String info() {
		return shape.info() + " has transparency of " + transparency + " %";
	}

}

public class Demo1 {

	public static void main(String[] args) {
		Shape circle = new Circle(20);
		System.out.println(circle.info());

		Shape coloredSquare = new ColoredShape("Blue", new Square(5));
		System.out.println(coloredSquare.info());

		Shape transparentSquare = new TrasparentShape(50, new ColoredShape("Blue", new Square(5)));
		System.out.println(transparentSquare.info());
	}

}
