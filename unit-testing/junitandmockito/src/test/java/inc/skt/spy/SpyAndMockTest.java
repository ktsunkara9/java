package inc.skt.spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SpyAndMockTest {

//	@Spy
//	private List<String> spyList = new ArrayList<>();
	
	@Mock
	private List<String> mockedList = new ArrayList<>();

//	@Test
//	public void test() {
//		spyList.add("Krishna");
//		doReturn(3).when(spyList).size();
//		assertEquals(3, spyList.size());
//	}
	
	@Test
	public void testMockedList() {
		when(mockedList.get(0)).thenReturn("Krishna");
		when(mockedList.size()).thenCallRealMethod();
		assertEquals(3, mockedList.size());
	}

}
