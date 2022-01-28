package inc.skt.scrapbook;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClassUsingClassWithVoidsTest {

	@Mock
	ClassWithVoids voids;

	@InjectMocks
	private ClassUsingClassWithVoids a;
	
	/*
	 * @Before public void setUp() { MockitoAnnotations.openMocks(this); a = new
	 * ClassUsingClassWithVoids(voids); }
	 */

	@Test
	public void test() {
		doNothing().when(voids).doNothingMethod();
		int result = a.useDoNothing();
		verify(voids, times(1)).doNothingMethod();
		assertEquals(1, result);
	}

}
