package inc.skt.order.dao;

import java.sql.SQLException;

import inc.skt.order.dto.Order;

public interface OrderDAO {

	public abstract int create(Order order) throws SQLException;
	public abstract Order read(int id) throws SQLException;
	public abstract int update(Order order) throws SQLException;
	public abstract int delete(int id) throws SQLException;
	
}
