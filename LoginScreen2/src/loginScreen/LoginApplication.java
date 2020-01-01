package loginScreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApplication extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Application TOEIC");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setResizable(false);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.show();
        stage.centerOnScreen();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}