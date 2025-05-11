package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseConnection;

public class Media {
	private int id;
	private String category;
	private int price;
	private int quantity;
	private String title;
	private String imageUrl;
	private int value;
	
	public Media(int id, String category, int price, int quantity, String title, int value, String imageUrl) {
		this.id = id;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.title = title;
		this.value = value;
		this.imageUrl = imageUrl;
	}
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	
	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public int getValue() { return value; }
	public void setValue(int value) { this.value = value; }
	
	public String getImageUrl() { return imageUrl; }
	public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl;
	}


  public static List<Media> getAllMedia(){
		List<Media> mediaList = new ArrayList<>();
				// Chỗ này nên tách phần query thành 1 class, mình muốn gọi query như nào thì chỉ cần gọi hàm được viết trong class QuerryQuerry
        String query = "SELECT * FROM media";
        
        try (
					Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {

               while (resultSet.next()) {
                   Media media = new Media(
                		   resultSet.getInt("id"),
						   resultSet.getString("category"),
						   resultSet.getInt("price"),
						   resultSet.getInt("quantity"),
						   resultSet.getString("title"),
						   resultSet.getInt("value"),
						   resultSet.getString("imageUrl")
				   );
                   
                   mediaList.add(media);
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
           return mediaList;
	}
}
