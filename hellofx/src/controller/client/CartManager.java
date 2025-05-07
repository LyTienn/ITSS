package controller.client;

import java.util.ArrayList;
import java.util.List;
import model.CartItem;
import model.Media;


public class CartManager {
    private static CartManager instance;
    private List<CartItem> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addToCart(Media media, int quantity) {
        // Kiểm tra xem media đã có trong giỏ chưa
        for (CartItem item : cartItems) {
            if (item.getMedia().getId() == media.getId()) {
                // Nếu có, cộng thêm số lượng
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        // Nếu chưa có, thêm mới
        cartItems.add(new CartItem(media, quantity));
    }

    public void removeFromCart(Media media) {
        cartItems.removeIf(item -> item.getMedia().getId() == media.getId());
    }
    
    public double getTotalCartPrice() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void clearCart() {
        cartItems.clear();
    }
}
