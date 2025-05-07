package Main;
import java.io.IOException;
import controller.client.HomeController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    // override ham start 
    public void start(Stage primartStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/client/home/index.fxml"));
        primartStage.setTitle("Client - Home Page");
        primartStage.setScene((new Scene(root)));
        primartStage.show();
    }
    public static void main(String[] args) {
        launch(args); // launch(args) la ham cua Application, dung de khoi dong JavaFX
    }
}