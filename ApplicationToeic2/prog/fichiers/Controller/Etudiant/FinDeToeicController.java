package prog.fichiers.Controller.Etudiant;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import prog.fichiers.Config.ConnectionUtil;

public class FinDeToeicController implements Initializable{
	
	Stage dialogStage = new Stage();
	
	@FXML
	Label rep;
	
	Connection connection = null;
	//PreparedStatement preparedStatement = null;
    //ResultSet resultSet = null; //stocke les TOEIC programmés pour une promo
    //ResultSet resultSet1 = null; //stock les dates des toeic programmés
    //ResultSet resultSet2 = null; //stocke la différence entre la date actuelle et la date du futur toeic
	
	public FinDeToeicController() {
        connection = ConnectionUtil.connectdb();
    }
	
	public void home(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Etudiant/AccueilEtudiantScreen.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CalculNote.note();
		String noteE = Integer.toString(CalculNote.noteE());
		String noteO = Integer.toString(CalculNote.noteO());
		rep.setText(noteE +" "+ noteO);
	}

}
