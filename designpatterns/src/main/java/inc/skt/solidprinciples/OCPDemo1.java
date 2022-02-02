package inc.skt.solidprinciples;

import java.util.List;
import java.util.stream.Collectors;

public class OCPDemo1 {

	public static void main(String[] args) {

		Product p1 = new Product("Apple", Color.RED, Size.SMALL);
		Product p2 = new Product("House", Color.BLUE, Size.HUGE);
		Product p3 = new Product("Car", Color.BLUE, Size.HUGE);
		Product p4 = new Product("Building", Color.GREEN, Size.LARGE);

		List<Product> products = List.of(p1, p2, p3, p4);

		ProductFilter pf = new ProductFilter();
		System.out.println("Blue Products : " + pf.filterByColor(products, Color.BLUE));
		System.out.println("Large Products : " + pf.filterBySize(products, Size.LARGE));
		System.out.println("Blue & Huge Products : " + pf.filterByColorAndSize(products, Color.BLUE, Size.HUGE));

		System.out.println("<======== Using better filter =========>");
		BetterFilter bf = new BetterFilter();
		System.out.println("Blue Products : " + bf.filter(products, new ColorSpecification(Color.BLUE)));
		System.out.println("Large Products : " + bf.filter(products, new SizeSpecification(Size.LARGE)));
		System.out.println("Blue & Huge Products : " + bf.filter(products,
				new AndSpecification<>(new ColorSpecification(Color.BLUE), new SizeSpecification(Size.HUGE))));
	}

}

enum Color {
	RED, GREEN, BLUE;
}

enum Size {
	SMALL, LARGE, HUGE;
}

class Product {
	private String name;
	private Color color;
	private Size size;

	public Product(String name, Color color, Size size) {
		this.name = name;
		this.color = color;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", color=" + color + ", size=" + size + "]";
	}

}

/*
 * Every Time we need to come & modify this class when a new filter is required.
 * OCP is against it, instead we should create new filter classes when a new
 * filter is required
 */
class ProductFilter {

	List<Product> filterByColor(List<Product> products, Color color) {
		return products.stream().filter(p -> p.getColor() == color).collect(Collectors.toList());
	}

	List<Product> filterBySize(List<Product> products, Size size) {
		return products.stream().filter(p -> p.getSize() == size).collect(Collectors.toList());
	}

	List<Product> filterByColorAndSize(List<Product> products, Color color, Size size) {
		return products.stream().filter(p -> p.getColor() == color && p.getSize() == size).collect(Collectors.toList());
	}
}

interface Filter<T> {
	public abstract List<T> filter(List<T> items, Specification<T> spec);
}

interface Specification<T> {
	public abstract boolean isSatisfied(T item);
}

class ColorSpecification implements Specification<Product> {

	private Color color;

	public ColorSpecification(Color color) {
		this.color = color;
	}

	@Override
	public boolean isSatisfied(Product item) {
		return item.getColor() == color;
	}

}

class SizeSpecification implements Specification<Product> {

	private Size size;

	public SizeSpecification(Size size) {
		super();
		this.size = size;
	}

	@Override
	public boolean isSatisfied(Product item) {
		return item.getSize() == size;
	}

}

class AndSpecification<T> implements Specification<T> {

	private Specification<T> spec1, spec2;

	public AndSpecification(Specification<T> spec1, Specification<T> spec2) {
		this.spec1 = spec1;
		this.spec2 = spec2;
	}

	@Override
	public boolean isSatisfied(T item) {
		return spec1.isSatisfied(item) && spec2.isSatisfied(item);
	}

}

class BetterFilter implements Filter<Product> {

	@Override
	public List<Product> filter(List<Product> items, Specification<Product> spec) {
		return items.stream().filter(p -> spec.isSatisfied(p)).collect(Collectors.toList());
	}

}