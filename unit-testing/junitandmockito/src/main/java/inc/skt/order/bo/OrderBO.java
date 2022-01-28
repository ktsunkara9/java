package inc.skt.order.bo;

import inc.skt.order.bo.exception.BOException;
import inc.skt.order.dto.Order;

public interface OrderBO {
	
	public abstract boolean placeOrder(Order order) throws BOException;

	public abstract boolean cancelOrder(int id) throws BOException;

	public abstract boolean deleteOrder(int id) throws BOException;

}
