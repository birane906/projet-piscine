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

public class CréerUnTOEICScreenController implements Initializable {

	// Il faut créer un tableau de TextField de taille 200 pour les réponses du TOEIC
	// Il faut le textField du nom de TOEIC
	// Si tous les champs sont remplis, qu'il y a seulement des A, B, C et D et que le nom n'existe pas déjà, on créé le nouveau TOEIC
	// Il faut donc les 7 parties dans ce TOIEC, avec chacune leur lots de questions
	
Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public CréerUnTOEICScreenController() {
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
	
	// Bouton retour page tous les TOEIC
	public void RetourToutTOEIC(ActionEvent event) {
		try {	
			Node node = (Node)event.getSource();
	        dialogStage = (Stage) node.getScene().getWindow();
	        dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Toeic/AfficherTousLesTOEICSScreen.fxml")));
	        }
		catch(Exception e){
			e.printStackTrace();
	    }
	}	
	
	// Bouton Permettant de créer le TOEIC à partir de ce qu'il y a d'entrer
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
