package prog.fichiers.Controller.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import prog.fichiers.Config.ConnectionUtil;

public class Questionnaire5Controller {

	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    
    @FXML
    private Label Timer;
    
    
	public Questionnaire5Controller() {
        connection = ConnectionUtil.connectdb();
    }
	
	
}
