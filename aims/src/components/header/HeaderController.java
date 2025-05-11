package components.header;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HeaderController {

    @FXML
    private TextField searchField;

    @FXML
    private Button cartButton;

    @FXML
    private Label cartCountLabel;

    @FXML
    private void handleCartButtonAction() {
        System.out.println("Cart button clicked");
        // Bạn có thể thêm navigation logic hoặc callback về HomeController nếu cần
    }
}
