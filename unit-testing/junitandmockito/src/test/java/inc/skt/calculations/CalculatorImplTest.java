package inc.skt.calculations;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorImplTest {

	int num1, num2, expectedResult;

	public CalculatorImplTest(int num1, int num2, int expectedResult) {
		this.num1 = num1;
		this.num2 = num2;
		this.expectedResult = expectedResult;
	}

	@Parameters
	public static Collection<Integer[]> parameterProvider() {
		return Arrays.asList(new Integer[][] { { 1, 2, 3 }, { 20, 30, 50 }, { 2, -4, -2 } });
	}

	@Test
	public void test() {
		Calculator calc = new CalculatorImpl();
		int result = calc.add(num1, num2);
		assertEquals(expectedResult, result);
	}

}
