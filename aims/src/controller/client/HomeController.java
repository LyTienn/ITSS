package controller.client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.Media;

import java.io.IOException;
import java.util.List;

import components.mediaItem.MediaItemController;

public class HomeController {

    @FXML
    private GridPane productGrid;

    private List<Media> mediaList;

    public void initialize() {
        // Load all media data
        mediaList = Media.getAllMedia();
        showMediaInGrid();
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
                if (column == 3) {
                    column = 0;
                    row++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @FXML
    private void handleCartButtonAction() {
        System.out.println("Cart button clicked!");
        // TODO: Thêm xử lý giỏ hàng tại đây
    }
}
