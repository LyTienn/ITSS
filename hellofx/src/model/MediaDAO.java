package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Testmysql.DatabaseConnection;

public class MediaDAO {
	public List<Media> getAllMedia(){
		List<Media> mediaList = new ArrayList<>();
        String query = "SELECT * FROM media";
        
        try (Connection connection = DatabaseConnection.getConnection();
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
