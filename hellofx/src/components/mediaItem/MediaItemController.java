/*
Cohesion level: Functional Cohesion
→ Mọi phương thức đều liên quan đến việc quản lý hiển thị và hành động của từng media item.

SRP Violation: NO
- Lớp này có thể vi phạm **Single Responsibility Principle (SRP)**, vì ngoài việc hiển thị dữ liệu media, nó còn xử lý các sự kiện như thêm media vào giỏ hàng và chuyển cảnh để xem chi tiết media.

Solution:
    tách các phần xử lý sự kiện như thêm vào giỏ hàng và chuyển cảnh thành các lớp riêng biệt (ví dụ: `CartManager` cho việc xử lý giỏ hàng, và `NavigationManager` cho việc điều hướng giữa các view).
*/
package components.mediaItem;

import java.io.IOException;

import controller.client.MediaDetailController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Media;

public class MediaItemController {

    @FXML
    private ImageView mediaImage;

    @FXML
    private Label mediaTitle;

    @FXML
    private Label mediaPrice;

    @FXML
    private Button addButton;

    private Media media;

    // Set dữ liệu cho từng item
    public void setMedia(Media media) {
        this.media = media;
        mediaTitle.setText(media.getTitle());
        mediaPrice.setText(media.getPrice() + " VND");

        try {
        	Image image = new Image(getClass().getResource("/assets/" + media.getImageUrl()).toExternalForm(), 100, 100, false, false);
            /// book1.jpg
            mediaImage.setImage(image);
        } catch (Exception e) {
            System.err.println("Failed to set Image for media item");
            Image image = new Image("/assets/book.jpg");
            mediaImage.setImage(image);
        }
    }

    // Xử lý sự kiện khi nhấn nút "Add to Cart"
    @FXML
    private void handleAddToCart() {
        System.out.println("Added to cart: " + media.getTitle());
    }

    @FXML
    private void handleViewDetail() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/client/media/MediaDetailView.fxml"));

            // Load root node từ file FXML trước (chưa tạo Scene)
            javafx.scene.Parent root = loader.load();

            // Sau khi load mới lấy controller
            MediaDetailController controller = loader.getController();
            controller.setMedia(media); // safe để gọi tại đây

            // Tạo Scene mới từ root đã load
            Scene detailScene = new Scene(root);

            // Lấy Stage hiện tại từ Scene của nút
            Stage currentStage = (Stage) addButton.getScene().getWindow();
            currentStage.setScene(detailScene);
            currentStage.setTitle("Chi tiết Media");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
