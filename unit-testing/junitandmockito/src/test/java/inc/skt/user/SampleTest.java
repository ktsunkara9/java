package inc.skt.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;


class SampleTest {

	@Test
	void test() {
		try (MockedStatic<Sample> mocked = Mockito.mockStatic(Sample.class, Mockito.CALLS_REAL_METHODS)) {
			mocked.when(() -> Sample.method1(Mockito.anyString())).thenReturn("bar");
			assertEquals("bar", Sample.method1("foo")); // mocked
			assertEquals("foo", Sample.method2("foo")); // not mocked
		}
	}

}
