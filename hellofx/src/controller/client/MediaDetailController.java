/*
Cohesion level: Functional Cohesion
→ Tất cả các phương thức và thuộc tính trong class này đều phục vụ một nhiệm vụ duy nhất:
   hiển thị chi tiết của một đối tượng Media.
*/

/*
SRP Violation: YES
→ Class này chỉ có một lý do để thay đổi: khi logic hiển thị chi tiết media thay đổi.
*/
package controller.client;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Media;

public class MediaDetailController {

    @FXML
    private ImageView mediaImage;

    @FXML
    private Label mediaTitle;

    @FXML
    private Label mediaDescription;

    @FXML
    private Label mediaPrice;

    @FXML
    private Button backButton;

    private Media media;

    // Hàm này sẽ được gọi từ MediaItemController để hiển thị chi tiết media
    public void setMedia(Media media) {
        this.media = media;
        mediaTitle.setText(media.getTitle());
        mediaPrice.setText(media.getPrice() + " VND");

        try {
        	Image image = new Image(getClass().getResource("/assets/" + media.getImageUrl()).toExternalForm(), 200, 200, false, false);
            mediaImage.setImage(image);
        } catch (Exception e) {
            System.err.println("Failed to set Image for media detail");
            Image image = new Image("/assets/book.jpg");
            mediaImage.setImage(image);
        }
    }

    @FXML
    private void handleBackButton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/client/home/homepage.fxml"));
            javafx.scene.Parent root = loader.load();
            Scene homeScene = new Scene(root);

            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(homeScene);
            stage.setTitle("Trang chủ");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
