package enJava.fichiers.Controller.Enseignant.Toeic;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import enJava.fichiers.Config.ConnectionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

public class G�rerLesTOEICScreenController implements Initializable{

Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public G�rerLesTOEICScreenController() {
        connection = ConnectionUtil.connectdb();
    }
	
	// Bouton Home
	public void Home(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/AccueilProfScreen.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	// Bouton pour afficher les TOEIC existants
		public void AfficherTOEIC(ActionEvent event) {
			try {	
				Node node = (Node)event.getSource();
	            dialogStage = (Stage) node.getScene().getWindow();
	            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Toeic/AfficherTousLesTOEICSScreen.fxml")));
			}
			catch(Exception e){
	            e.printStackTrace();
	        }
		}

		// Bouton pour afficher les TOEIC programm�s
		public void AfficherTOEICProg(ActionEvent event) {
			try {	
				Node node = (Node)event.getSource();
	            dialogStage = (Stage) node.getScene().getWindow();
	            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Toeic/AfficherTOEICProgramm�sScreen.fxml")));
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
