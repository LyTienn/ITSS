package controller.client;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Media;
import controller.client.CartManager;
import java.util.List;
import model.CartItem;
import javafx.scene.control.Button;

public class CartController {
	@FXML
	private Button removeButton;
    @FXML
    private VBox cartItemsContainer;
    @FXML
    private void handleBackToHome(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/client/home/index.fxml"));
			Parent root = loader.load();
			Stage stage = (Stage) cartItemsContainer.getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    //@FXML
    //private void handleRemoveFromCart(ActionEvent event) {
    	//for (CartItem cartItem : CartItem) {
    	    //HBox itemBox = new HBox();

    	    //Label nameLabel = new Label(cartItem.getMedia());
    	    //Button removeButton = new Button("Remove");

    	    //removeButton.setOnAction(e -> {
    	        //CartManager.getInstance().removeFromCart(cartItem);
    	        //loadCartItems();
    	    //});

    	    //itemBox.getChildren().addAll(nameLabel, removeButton);
    	    //cartItemsContainer.getChildren().add(itemBox);
    	//}
    //}
    @FXML
    public void initialize() {
        loadCartItems();
    }

    private void loadCartItems() {
    	List<CartItem> cartItems = CartManager.getInstance().getCartItems();

        for (CartItem item : cartItems) {
            Media media = item.getMedia();
            int quantity = item.getQuantity();

            Label itemLabel = new Label(media.getTitle() + " - Quantity: " + quantity + " - Price: $" + CartManager.getInstance().getTotalCartPrice());
            cartItemsContainer.getChildren().add(itemLabel);
        }
    }
}