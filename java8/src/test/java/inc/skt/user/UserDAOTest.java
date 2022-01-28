package inc.skt.user;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IDGenerator.class)
public class UserDAOTest {

	@Test
	public void test() {
		UserDAO dao = new UserDAO();
		
		mockStatic(IDGenerator.class);
		when(IDGenerator.generateID()).thenReturn(1);
		
		int userID = dao.create(new User());
		assertEquals(1, userID);
		verifyStatic();
	}
	

}
