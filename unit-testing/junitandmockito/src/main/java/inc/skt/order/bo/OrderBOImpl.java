package inc.skt.order.bo;

import java.sql.SQLException;

import inc.skt.order.bo.exception.BOException;
import inc.skt.order.dao.OrderDAO;
import inc.skt.order.dto.Order;

public class OrderBOImpl implements OrderBO {

	private OrderDAO dao;

	@Override
	public boolean placeOrder(Order order) throws BOException {
		try {
			int id = dao.create(order);
			if (id == 0)
				return false;
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean cancelOrder(int id) throws BOException {

		try {
			Order order = dao.read(id);
			order.setstatus("Cancelled");
			int result = dao.update(order);
			if (result == 0)
				return false;
		} catch (SQLException e) {
			throw new BOException(e);
		}

		return true;
	}

	@Override
	public boolean deleteOrder(int id) throws BOException {
		try {
			int result = dao.delete(id);
			if (result == 0)
				return false;
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

}
