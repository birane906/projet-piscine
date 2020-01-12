package prog.fichiers.Controller.Etudiant;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import prog.fichiers.Config.ConnectionUtil;

public class QuestionnaireController2 implements Initializable {

	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
    
	
	public QuestionnaireController2() {
        connection = ConnectionUtil.connectdb();
    }
	
	public void back(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Etudiant/Toeic/FXMLQuestionnaire.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
