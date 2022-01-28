package inc.skt.greeting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GreetingImplTest {

	@Mock
	private GreetingService greetingService;
	
	@InjectMocks
	private GreetingImpl greeting;
	
	@Test
	public void test() {
		assertNotNull(greetingService);
	}
	
	@Test
	public void testGreet() {
		
		when(greetingService.greet("Krishna")).thenReturn("Welcome Krishna !!!");
		String result = greeting.greet("Krishna");
		assertNotNull(result);
		assertEquals("Welcome Krishna !!!", result);
	}
	
	@Test
	public void testGreetShouldThrowIllegalArgumentExceptionWhenNameIsNull() {
		
		when(greetingService.greet(null)).thenThrow(IllegalArgumentException.class);
		assertThrows(IllegalArgumentException.class, () -> {
			greeting.greet(null);
		});
	}
	
	@Test
	public void testGreetShouldThrowIllegalArgumentExceptionWhenNameIsEmpty() {
		when(greetingService.greet("")).thenThrow(IllegalArgumentException.class);
		assertThrows(IllegalArgumentException.class, () -> {
			greeting.greet("");
		});
	}
	
		/***** Tests without Mockito *****/
	/*	
	 * private Greeting greeting;
	 * 
	 * @Before public void setUp() { greeting = new GreetingImpl(); }
	 * 
	 * @Test public void testGreet() { String actual = greeting.greet("Krishna");
	 * assertNotNull(actual); assertEquals("Welcome Krishna !!!", actual); }
	 * 
	 * @Test(expected = IllegalArgumentException.class) // Supported only in Junit4
	 * public void testGreetShouldThrowIllegalArgumentExceptionWhenNameIsNull() {
	 * greeting.greet(null); }
	 * 
	 * @Test public void
	 * testGreetShouldThrowIllegalArgumentExceptionWhenNameIsEmpty() { //expected is
	 * not supported in junit5 We can test Exceptions using Assertions.assertThrows
	 * Assertions.assertThrows(IllegalArgumentException.class, () -> {
	 * greeting.greet(""); }); }
	 * 
	 * @After public void tearDown() { greeting = null; }
	 */

}
