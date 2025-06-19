package components.header;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import controller.client.HomeController;
import service.SearchService;
import java.util.List;
import java.util.ArrayList;
import service.MediaService;
import model.Media;


public class HeaderController {
	private HomeController homeController;

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }
    @FXML
    private TextField searchField;

    @FXML
    private Button cartButton;

    @FXML
    private Label cartCountLabel;
    
    @FXML
    public void handleSearchButtonAction() {
        String keyword = searchField.getText().trim(); // Lấy từ khóa từ ô tìm kiếm
        System.out.println("Từ khóa tìm kiếm: " + keyword); 
    }
    
    @FXML
    private void handleCartButtonAction() {
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/client/cart/cartView.fxml"));
        	Pane cartView = loader.load();
        	cartButton.getScene().setRoot(cartView);
        } catch (IOException e) {
			e.printStackTrace();
		}
        // TODO: navigate to cartView.fxml
    }
}
