package inc.skt.spring.junit.dao;

import org.springframework.stereotype.Repository;

import inc.skt.spring.junit.dto.Ticket;

@Repository
public class TicketDAOImpl implements TicketDAO {

	public int createTicket(Ticket ticket) {
		return 1;
	}

}
