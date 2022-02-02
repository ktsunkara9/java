package inc.skt.solidprinciples;

public class LSPDemo1 {

	public static void main(String[] args) {

		Rectangle r1 = new Rectangle(3, 2);
		Rectangle r2 = new Square(5);

		checkAreaAfterIncrementingWidth(r1);
		checkAreaAfterIncrementingWidth(r2);

	}

	public static void checkAreaAfterIncrementingWidth(Rectangle r) {
		int width = r.getWidth();
		
		r.setHeight(10);
		
		System.out.println("Area Should be : " + r.getHeight() * width + " got Area : "+ r.getArea());
	}

}

class Rectangle {
	protected int height;
	protected int width;

	public Rectangle() {
	}

	public Rectangle(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + "]";
	}

	public int getArea() {
		return height * width;
	}
}

class Square extends Rectangle {

	public Square() {
	}

	public Square(int size) {
		height = width = size;
	}

	public void setHeight(int height) {
		super.setWidth(height);
		super.setHeight(height);
	}

	public void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width);
	}

}
