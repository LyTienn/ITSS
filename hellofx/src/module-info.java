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
    
    exports components.mediaItem;
    opens components.mediaItem to javafx.fxml;
    exports components.header;
    opens components.header to javafx.fxml;
    exports controller.client;  
    opens controller.client to javafx.fxml;
    opens Main to javafx.fxml;
    opens model to javafx.fxml;
    
    exports model;
    exports Main;
}