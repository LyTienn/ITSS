package model;
import java.util.ArrayList;
import java.util.List;
import model.Media;

public class Cart {
	private int id;
	private int quantity;
	private double price;
	private List<Media> media = new ArrayList<>();
	
	public Cart(int id, int quantity, double price, List<Product> products) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.media = media;
	}
	
	public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public List<Media> getMedia() { return media; }
    public void setMeida(List<Media> media) { this.media = media; }
    
    public boolean checkProductAvailability(Cart cart) {
    	return !media.isEmpty();
    }
	
}
