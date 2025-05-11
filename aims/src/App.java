import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    // override ham start
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/client/home/homepage.fxml"));
        primaryStage.setTitle("Client - Home Page");
        primaryStage.setScene((new Scene(root)));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // launch(args) la ham cua Application, dung de khoi dong JavaFX
    }
}
