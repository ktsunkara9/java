package inc.skt.order.bo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import inc.skt.order.bo.exception.BOException;
import inc.skt.order.dao.OrderDAO;
import inc.skt.order.dto.Order;

public class OrderBOImplTest {

	@Mock
	OrderDAO dao;

	private OrderBOImpl bo;

	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		bo = new OrderBOImpl();
		bo.setDao(dao);
	}

	@Test
	public void testPlaceOrderShouldCreateOrder() throws BOException, SQLException {

		Order order = new Order();
		when(dao.create(order)).thenReturn(1);

		boolean result = bo.placeOrder(order);
		assertTrue(result);
		verify(dao, times(1)).create(order);
	}

	@Test
	public void testPlaceOrderShouldNotCreateOrder() throws SQLException, BOException {

		Order order = new Order();
		when(dao.create(order)).thenReturn(0);

		boolean result = bo.placeOrder(order);
		assertFalse(result);
		verify(dao, times(1)).create(order);
	}

	@Test(expected = BOException.class)
	public void testPlaceOrderShouldThrowBOException() throws SQLException, BOException {

		Order order = new Order();
		when(dao.create(order)).thenThrow(SQLException.class);
		boolean result = bo.placeOrder(order);

		assertTrue(result);
	}

	@Test
	public void testCancelOrderShouldCancelOrder() throws SQLException, BOException {

		Order order = new Order();
		when(dao.read(1)).thenReturn(order);
		when(dao.update(order)).thenReturn(1);

		boolean result = bo.cancelOrder(1);
		assertTrue(result);
		verify(dao, times(1)).read(1);
		verify(dao, times(1)).update(order);
	}

	@Test
	public void testCancelOrderShouldNotCancelOrder() throws SQLException, BOException {

		Order order = new Order();
		when(dao.read(1)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);

		boolean result = bo.cancelOrder(1);

		assertFalse(result);
		verify(dao, times(1)).read(1);
		verify(dao, times(1)).update(order);
	}

	@Test(expected = BOException.class)
	public void testCancelOrderShoulThrowBOExcpetionOnRead() throws SQLException, BOException {
		
		when(dao.read(1)).thenThrow(SQLException.class);
		bo.cancelOrder(1);
	}

	@Test(expected = BOException.class)
	public void testCancelOrderShouldThrowBOExceptionOnUpdate() throws SQLException, BOException {

		Order order = new Order();
		when(dao.read(1)).thenReturn(order);
		when(dao.update(order)).thenThrow(SQLException.class);

		bo.cancelOrder(1);
	}
	
	@Test
	public void testDeleteOrderShouldDeleteTheOrder() throws SQLException, BOException {
		when(dao.delete(1)).thenReturn(1);
		boolean result = bo.deleteOrder(1);
		assertTrue(result);
		verify(dao, times(1)).delete(1);
	}
	
	@Test
	public void testDeleteOrderShouldNotDeleteTheOrder() throws SQLException, BOException {
		when(dao.delete(1)).thenReturn(0);
		boolean result = bo.deleteOrder(1);
		assertFalse(result);
		verify(dao, times(1)).delete(1);
	}
	
	@Test(expected = BOException.class)
	public void testDeleteOrderShouldThrowBOExceptionOnDelete() throws SQLException, BOException {
		when(dao.delete(1)).thenThrow(SQLException.class);
		bo.deleteOrder(1);
	}

}
