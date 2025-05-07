package controller.client;
import model.Cart;
import model.Order;

public class PlaceOrderController {
	public void handlePlaceOrder (Cart cart) {
		Order order = Order.createOrder(cart);
	}
}
