package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.DatabaseConnection;
import java.util.ArrayList;
import java.util.List;
import model.Media;

public class MediaService extends Media {
		
	public MediaService(int id, String category, int price, int quantity, String title, int value, String imageUrl) {
		super(id, category, price, quantity, title, value, imageUrl);
	}

	// Lấy danh sách tất cả các media
	public static List<Media> getAllMedia(){
		List<Media> mediaList = new ArrayList<>();
		// Nên tách query thành 1 class riêng để quản lý truy vấn SQL
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
