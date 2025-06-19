package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.client.HomeController;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/client/home/homepage.fxml"));
        Parent root = loader.load();
        HomeController homeController = loader.getController();

        // Set the scene
        Scene scene = new Scene(root);

        // Configure the stage
        primaryStage.setTitle("Homepage");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
