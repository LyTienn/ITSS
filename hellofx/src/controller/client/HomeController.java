/*
Cohesion level: Procedural Cohesion
→ Các phương thức trong lớp được gọi theo một trình tự logic (khởi tạo, hiển thị, xử lý sự kiện),
   nhưng không cùng phục vụ một mục tiêu duy nhất.
→ Ví dụ: showMediaInGrid() và handleCartButtonAction() xử lý các nhiệm vụ hoàn toàn khác nhau.
*/

/*
SRP Violation: NO
- Lớp này có nhiều hơn một lý do để thay đổi:
   1. Nếu logic hiển thị media thay đổi, ta phải sửa lớp này.
   2. Nếu logic xử lý giỏ hàng thay đổi, ta cũng phải sửa lớp này.
*/

/*
Solution:
- Tách xử lý sự kiện giỏ hàng ra thành một lớp riêng, ví dụ: CartController.
- HomeController chỉ nên chịu trách nhiệm hiển thị media và tương tác liên quan đến media thôi.
*/
package controller.client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.Media;
import service.MediaService;
import service.SearchService;
import java.io.IOException;
import java.util.List;

import components.mediaItem.MediaItemController;

public class HomeController {

    @FXML
    private GridPane productGrid;
    
    @FXML
    private TextField searchField;
    
    private List<Media> mediaList;

    public void initialize() {
        // Load all media data
        mediaList = MediaService.getAllMedia();
        showMediaInGrid();
    }
    
    public void searchMedia(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            // If the keyword is empty, show all media
            showMediaInGrid(mediaList);
        } else {
            // Filter media based on the keyword
            List<Media> filteredMedia = SearchService.searchMediaByCategory(mediaList, keyword);
            showMediaInGrid(filteredMedia);
        }
    }
    
    private void showMediaInGrid(List<Media> mediaList) {
    	productGrid.getChildren().clear();
        int column = 0;
        int row = 0;

        for (Media media : mediaList) {
            try {
                // Cập nhật lại đường dẫn cho FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/components/mediaItem/MediaItem.fxml"));
                Pane mediaItemPane = loader.load();

                // Get the controller of the media item
                MediaItemController controller = loader.getController();
                controller.setMedia(media);

                // Add the mediaItemPane to the GridPane
                productGrid.add(mediaItemPane, column, row);
                column++;
                if (column == 4) {
                    column = 0;
                    row++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void showMediaInGrid() {
        productGrid.getChildren().clear();
        int column = 0;
        int row = 0;

        for (Media media : mediaList) {
            try {
                // Cập nhật lại đường dẫn cho FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/components/mediaItem/MediaItem.fxml"));
                Pane mediaItemPane = loader.load();

                // Get the controller of the media item
                MediaItemController controller = loader.getController();
                controller.setMedia(media);

                // Add the mediaItemPane to the GridPane
                productGrid.add(mediaItemPane, column, row);
                column++;
                if (column == 4) {
                    column = 0;
                    row++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
