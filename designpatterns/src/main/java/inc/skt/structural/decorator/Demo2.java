package inc.skt.structural.decorator;

import java.util.function.Supplier;

class ColoredShape1<T extends Shape> implements Shape {

	private Shape shape;
	private String color;

	public ColoredShape1() {
	}

	public ColoredShape1(Supplier<? extends T> ctor, String color) {
		shape = ctor.get();
		this.color = color;
	}

	@Override
	public String info() {
		return shape.info() + " has Color " + color;
	}

}

class TransparentShape1<T extends Shape> implements Shape {
	private Shape shape;
	private int transparency;

	public TransparentShape1() {
	}

	public TransparentShape1(Supplier<? extends T> ctor, int transparency) {
		shape = ctor.get();
		this.transparency = transparency;
	}

	@Override
	public String info() {
		return shape.info() + " has transparency of " + transparency + " %";
	}

}

public class Demo2 {

	public static void main(String[] args) {
		ColoredShape1<Square> coloredSquare = new ColoredShape1<>(() -> new Square(20), "Blue");
		System.out.println(coloredSquare.info());

		TransparentShape1<ColoredShape1<Circle>> transparentCircle = new TransparentShape1<>(
				() -> new ColoredShape1<>(() -> new Circle(20), "Blue"), 50);

		System.out.println(transparentCircle.info());

	}

}
