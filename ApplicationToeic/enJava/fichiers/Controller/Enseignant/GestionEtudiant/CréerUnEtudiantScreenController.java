package enJava.fichiers.Controller.Enseignant.GestionEtudiant;

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

public class Cr�erUnEtudiantScreenController implements Initializable{

Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public Cr�erUnEtudiantScreenController() {
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
	
	// Bouton pour retourner � la gestion des �tudiants
	public void RetourG�rerEtudiant(ActionEvent event) {
		try {	
			Node node = (Node)event.getSource();
	        dialogStage = (Stage) node.getScene().getWindow();
	        dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/GestionEtudiant/G�rerLesEtudiantsScreen.fxml")));
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
