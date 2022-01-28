package inc.skt.spring.junit.services;

import org.springframework.stereotype.Service;

import inc.skt.spring.junit.dao.TicketDAO;
import inc.skt.spring.junit.dto.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	TicketDAO dao;

	public int buyTicket(String passengerName, String phone) {

		Ticket ticket = new Ticket();
		ticket.setPassengerName(passengerName);
		ticket.setPhone(phone);
		return dao.createTicket(ticket);

	}

}
