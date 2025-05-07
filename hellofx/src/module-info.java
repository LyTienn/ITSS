/**
 * 
 */
/**
 * 
 */
module hellofx {
	requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires transitive javafx.base;
    requires java.sql;
    
    
    exports controller.client;  // Export package chứa HomeController
    opens controller.client to javafx.fxml;
    opens view.client.cart to javafx.fxml;
    //exports view.client.cart;
    opens Main to javafx.fxml;
    exports Main;
}