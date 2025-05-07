package controller.client;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;  
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import model.MediaDAO;
import model.Media;

import java.util.List;
public class HomeController {
	private MediaDAO mediaDAO = new MediaDAO();
	@FXML
	private Button addToCart;
	@FXML
	private Button cartButton;
    @FXML
    private GridPane productGrid;

    @FXML
    public void initialize() {
		loadMediaData();
	}
    
    public void loadMediaData() {
        List<Media> mediaList = mediaDAO.getAllMedia();
        int column = 0;
        int row = 0;

        for (Media media : mediaList) {
            VBox productBox = new VBox(10);  //Gán id cho mỗi sản phẩm tương ứng với VBOX (Lấy từ db)
            productBox.setStyle("-fx-background-color: #f9f9f9; -fx-padding: 10; -fx-border-color: #cccccc; -fx-border-width: 1;");
            productBox.setPrefWidth(200);
            productBox.setPrefHeight(300);

            ImageView imageView = new ImageView();
            try {
            	String fullPath = getClass().getResource("/assets/" + media.getImageUrl()).toExternalForm();
                Image image = new Image(fullPath, true);
                imageView.setImage(image);
            } catch (Exception e) {
                imageView.setImage(new Image(getClass().getResource("/assets/book.jpg").toExternalForm()));
            }
            imageView.setFitWidth(150);
            imageView.setFitHeight(150);

            Label titleLabel = new Label(media.getTitle());
            Label priceLabel = new Label("$" + media.getPrice());

            Spinner<Integer> quantitySpinner = new Spinner<>();
            quantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 15, 1));

            addToCart = new Button("Add to Cart");

            productBox.getChildren().addAll(imageView, titleLabel, priceLabel, quantitySpinner, addToCart);
            productGrid.add(productBox, column, row);

            column++;
            if (column == 4) {
                column = 0;
                row++;
            }
            addToCart.setOnAction(event -> {
            	int quantity = quantitySpinner.getValue();
            	CartManager.getInstance().addToCart(media, quantity);
            });
        }
    }
 
    // Sự kiện khi nhấn vào nút "Cart"
    @FXML
    private void handleCartButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/client/cart/index.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) cartButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}