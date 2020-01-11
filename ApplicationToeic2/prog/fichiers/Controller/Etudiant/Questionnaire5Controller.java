package prog.fichiers.Controller.Etudiant;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import prog.fichiers.Config.ConnectionUtil;
import prog.fichiers.Config.Timer;

public class Questionnaire5Controller implements Initializable {

	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    
    @FXML
    private Label Timer;
    
    
	public Questionnaire5Controller() {
        connection = ConnectionUtil.connectdb();
    }

	@FXML
    private void initialize() {
		Thread thread = new Thread(new Timer());
		Timer.setText(thread.run());
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
