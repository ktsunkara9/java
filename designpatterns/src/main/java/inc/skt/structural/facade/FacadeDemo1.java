package inc.skt.structural.facade;

import java.util.ArrayList;
import java.util.List;

public class FacadeDemo1 {

	public static void main(String[] args) {

		Buffer buffer = new Buffer(30, 20);
		ViewPort viewPort = new ViewPort(buffer, 30, 20, 0, 0);
		Console console = new Console(30, 20);
		console.addViewPort(viewPort);
		console.render();

		// Instead of letting the client create the buffer, the view port & the console
		// use the facade
		Console console2 = Console.newConsole(30, 20);
		console2.render();
	}

}

class Buffer {
	private int lineWidht;
	private char[] chars;

	public Buffer(int lineWidht, int lineHeight) {
		super();
		this.lineWidht = lineWidht;
		this.chars = new char[lineWidht * lineHeight];
	}

	public char charAt(int x, int y) {
		return chars[x + lineWidht * y];
	}
}

class ViewPort {
	private Buffer buffer;
	private int width;
	private int height;
	private int offSetX;
	private int offSetY;

	public ViewPort(Buffer buffer, int width, int height, int offSetX, int offSetY) {
		super();
		this.buffer = buffer;
		this.setWidth(width);
		this.setHeight(height);
		this.offSetX = offSetX;
		this.offSetY = offSetY;
	}

	public char charAt(int x, int y) {
		return buffer.charAt(x + offSetX, y + offSetY);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}

class Console {
	private List<ViewPort> viewPorts = new ArrayList<>();
	private int width;
	private int height;

	public Console() {
	}

	public Console(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public void addViewPort(ViewPort vp) {
		viewPorts.add(vp);
	}

	public void render() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				for (ViewPort vp : viewPorts) {
					System.out.print(vp.charAt(x, y));
				}
			}
			System.out.println();
		}
	}

	public static Console newConsole(int width, int height) {
		Buffer buffer = new Buffer(width, height);
		ViewPort viewPort = new ViewPort(buffer, width, height, 0, 0);
		Console console = new Console(width, height);
		console.addViewPort(viewPort);
		return console;
	}
}