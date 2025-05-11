package model;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	private int id;
	private int quantity;
	private double price;
	private List<Product> products = new ArrayList<>();
	
	public Cart(int id, int quantity, double price, List<Product> products) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.products = products;
	}
	
	public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public List<Product> getProduct() { return products; }
    public void setProduct(List<Product> products) { this.products = products; }
    
    public boolean checkProductAvailability(Cart cart) {
    	return !products.isEmpty();
    }
	
}
