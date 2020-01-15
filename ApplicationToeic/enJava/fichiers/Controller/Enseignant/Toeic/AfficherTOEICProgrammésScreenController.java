package enJava.fichiers.Controller.Enseignant.Toeic;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert.AlertType;
import enJava.fichiers.Config.ConnectionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AfficherTOEICProgrammésScreenController implements Initializable {

	@FXML
	ChoiceBox<String> choixProg;
	@FXML
	ChoiceBox<String> choixFiliere;
	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public AfficherTOEICProgrammésScreenController() {
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
	
	// Bouton pour aller programmer un TOEIC
	public void ProgrammerTOEIC(ActionEvent event) {
		try {	
			Node node = (Node)event.getSource();
			dialogStage = (Stage) node.getScene().getWindow();
			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Toeic/ProgrammerUnTOEICScreen.fxml")));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// Bouton supprimer
	public void Supprimer(ActionEvent event) {
		String nomTOEIC = (String) choixProg.getValue();
		String filiere = (String) choixFiliere.getValue();
		if(nomTOEIC != null) {
			if(filiere != null) {
				String numTO = "SELECT NumTOEIC FROM Toeic WHERE LibelleTOEIC = ?";
				try {
					preparedStatement = connection.prepareStatement(numTO);
					preparedStatement.setString(1, nomTOEIC);
					resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						int numTOEIC = resultSet.getInt(1);
						
						String vérif = "SELECT COUNT(*) FROM Programmer WHERE NumTOEIC = ? AND FiliereEtAnnee = ?";
						
						preparedStatement = connection.prepareStatement(vérif);
						preparedStatement.setInt(1, numTOEIC);
						preparedStatement.setString(2, filiere);
						resultSet = preparedStatement.executeQuery();
						if(resultSet.next()) {
							if(resultSet.getInt(1) != 0) {
								String del = "DELETE FROM Programmer WHERE NumTOEIC = ? AND FiliereEtAnnee = ?";

								preparedStatement = connection.prepareStatement(del);
								preparedStatement.setInt(1, numTOEIC);
								preparedStatement.setString(2, filiere);
								preparedStatement.executeUpdate();

								infoBox("Ce TOEIC programmé a été supprimé avec succès.", null, "Succès");
							}
							else {
								infoBox("Vous n'avez pas sélectionné la filère pour laquelle ce TOEIC est programmé", null, "Erreur");
							}
						}
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			else {
				infoBox("Veuillez sélectionner une filière.", null, "Erreur");
			}	
		}
		else {
			infoBox("Veuillez d'abord sélectionner un TOEIC programmé à supprimer.", null, "Erreur");
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
		String toeic = "SELECT NumTOEIC,FiliereEtAnnee FROM Programmer";
		try {
			preparedStatement = connection.prepareStatement(toeic);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int numTOEIC = resultSet.getInt(1);
				String prog = "SELECT LibelleTOEIC FROM Toeic WHERE NumTOEIC = ?";

				preparedStatement = connection.prepareStatement(prog);
				preparedStatement.setInt(1, numTOEIC);
				ResultSet resultSet2 = preparedStatement.executeQuery();
				if(resultSet2.next()) {
					choixProg.getItems().add(resultSet2.getString(1));
					choixFiliere.getItems().add(resultSet.getString(2));
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
