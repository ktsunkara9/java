package inc.skt.parellelstreams;

import java.util.stream.IntStream;

public class DemoApp1 {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		IntStream.range(1, 100).parallel().forEach(System.out::println);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken By Parellel Stream : " + (end - start) + " ms");

	}

}
