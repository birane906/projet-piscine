package enJava.fichiers.Controller.Enseignant.Toeic;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import enJava.fichiers.Config.ConnectionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AfficherTousLesTOEICSScreenController implements Initializable{

Stage dialogStage = new Stage();
	
	@FXML
	ChoiceBox<String> choixTOEIC;

	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
	public AfficherTousLesTOEICSScreenController() {
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
	
	// Bouton retour page Gérer TOEIC
	public void RetourGérerTOEIC(ActionEvent event) {
		try {	
			Node node = (Node)event.getSource();
	        dialogStage = (Stage) node.getScene().getWindow();
	        dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Toeic/GérerLesTOEICScreen.fxml")));
		}
		catch(Exception e){
			e.printStackTrace();
	    }
	}

	// Bouton créer TOEIC
	public void CréerTOEIC(ActionEvent event) {
		try {	
			Node node = (Node)event.getSource();
	        dialogStage = (Stage) node.getScene().getWindow();
	        dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Toeic/CréerUnTOEICScreen.fxml")));
		}
		catch(Exception e){
			e.printStackTrace();
	    }
	}
	
	// Bouton supprimer
	public void Supprimer(ActionEvent event) {
		String nomTOEIC = (String) choixTOEIC.getValue();
		if(nomTOEIC != null) {
			String numTO = "SELECT NumTOEIC FROM Toeic WHERE LibelleTOEIC = ?";
			
			try {
				preparedStatement = connection.prepareStatement(numTO);
				preparedStatement.setString(1, nomTOEIC);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					int numTOEIC = resultSet.getInt(1);
										
					String del = "DELETE FROM Notes WHERE NumTOEIC = ?";
					
					preparedStatement = connection.prepareStatement(del);
					preparedStatement.setInt(1, numTOEIC);
					preparedStatement.executeUpdate();
					
					del = "DELETE FROM Question WHERE NumTOEIC = ?";
					
					preparedStatement = connection.prepareStatement(del);
					preparedStatement.setInt(1, numTOEIC);
					preparedStatement.executeUpdate();
					
					del = "DELETE FROM Partie WHERE NumTOEIC = ?";
					
					preparedStatement = connection.prepareStatement(del);
					preparedStatement.setInt(1, numTOEIC);
					preparedStatement.executeUpdate();
					
					del = "DELETE FROM Programmer WHERE NumTOEIC = ?";
					
					preparedStatement = connection.prepareStatement(del);
					preparedStatement.setInt(1, numTOEIC);
					preparedStatement.executeUpdate();
					
					del = "DELETE FROM Passer WHERE NumTOEIC = ?";
					
					preparedStatement = connection.prepareStatement(del);
					preparedStatement.setInt(1, numTOEIC);
					preparedStatement.executeUpdate();
					
					del = "DELETE FROM Toeic WHERE NumTOEIC = ?";
					
					preparedStatement = connection.prepareStatement(del);
					preparedStatement.setInt(1, numTOEIC);
					preparedStatement.executeUpdate();
					
					infoBox("Ce TOEIC a été supprimé avec succès.", null, "Succès");

				}
				else {
					infoBox("TOEIC déjà supprimé, sélectionnez-en un autre à supprimer.", null, "Erreur");
				}
			}
			catch(Exception e){
				e.printStackTrace();
		    }
		}
		else {
			infoBox("Veuillez d'abord sélectionner un TOEIC à supprimer.", null, "Erreur");
		}
	}
	
	public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// On initialise la choice box des promos
		String toeic = "SELECT LibelleTOEIC FROM Toeic";
		try {
			preparedStatement = connection.prepareStatement(toeic);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				choixTOEIC.getItems().add(resultSet.getString(1));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
