package controller.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button; // Thêm dòng này để sử dụng Button
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button cartButton;

    // Sự kiện khi nhấn vào nút "Cart"

    @FXML
    private void handleCartButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/client/cart/index.fxml")); // sửa đường dẫn
        Parent root = loader.load();

        Stage stage = (Stage) cartButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Cart");
        stage.show();
    }
}
