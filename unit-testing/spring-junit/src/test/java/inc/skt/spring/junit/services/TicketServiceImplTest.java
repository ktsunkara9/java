package inc.skt.spring.junit.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import inc.skt.spring.junit.dao.TicketDAO;
import inc.skt.spring.junit.dto.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TicketServiceImplTest {

	private static final int RESULT = 1;

	private static final String PHONE = "1234567890";

	private static final String PASSENGER_NAME = "Krishna";

	@Mock
	private TicketDAO dao;

	@Autowired
	@InjectMocks
	private TicketServiceImpl service;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testBuyTicketShouldCreateTicket() {
		when(dao.createTicket(any(Ticket.class))).thenReturn(1);
		int result = service.buyTicket(PASSENGER_NAME, PHONE);
		assertEquals(RESULT, result);
	}

}
