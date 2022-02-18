package inc.skt.parellelstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

public class ParellelStreamTests {

	@State(Scope.Thread)
	public static class BenchmarkState {
		List<Integer> list;

		@Setup(Level.Trial)
		public void initialize() {

			Random rand = new Random();

			list = new ArrayList<>();
			for (int i = 0; i < 1000; i++)
				list.add(rand.nextInt());
		}
	}

	@Benchmark
	public void benchmark1(BenchmarkState state, Blackhole bh) {

		List<Integer> list = state.list;

		for (int i = 0; i < 1000; i++)
			bh.consume(list.get(i));
	}

	@Test
	public void sequentialStream() {
		long start = System.currentTimeMillis();
		IntStream.rangeClosed(1, 100).forEach(System.out::println);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken By Sequential Stream : " + (end - start) + " ms");
	}

	@Test
	public void parellelStream() {
		long start = System.currentTimeMillis();
		IntStream.range(1, 100).parallel().forEach(System.out::println);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken By Sequential Stream : " + (end - start) + " ms");
	}

}
