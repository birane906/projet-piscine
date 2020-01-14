package enJava.fichiers.Controller.Enseignant.Statistiques;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RésultatsProfPromoScreenController implements Initializable{

	@FXML
	ChoiceBox<String> choixParticipants;
	@FXML
	Text nomPromo;
	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public RésultatsProfPromoScreenController() {
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
	
	// Fonction pour le bouton valider, nous change d'écran selon si on veut par promo ou par étudiant
	public void Valider(ActionEvent event) {
		try {
			String participants = (String) choixParticipants.getValue();
			if(participants != null) {
				RésultatsProfScreenController.setParti(participants);
				if(participants.equals("Etudiant")) {
					Node node = (Node)event.getSource();
		            dialogStage = (Stage) node.getScene().getWindow();
		            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Statistiques/RésultatsEtudiantVueProfScreen.fxml")));
				}
				else {
					Node node = (Node)event.getSource();
		            dialogStage = (Stage) node.getScene().getWindow();
		            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Statistiques/RésultatsProfPromoScreen.fxml")));
				}
			}
			else {
				infoBox("Vous devez d'abord sélectionner une filière.", null, "Erreur");
			}
		}
		catch(Exception e){
	           e.printStackTrace();
		}
	}
	
	// Bouton Progression par partie
	public void PPP(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
	        dialogStage = (Stage) node.getScene().getWindow();
	        dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Statistiques/ProgressionParPartiePromoProfScreen.fxml")));
		}
		catch(Exception e){
			e.printStackTrace();
	    }
	}
		
	// Bouton Progression par partie
	public void PPSP(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
			dialogStage = (Stage) node.getScene().getWindow();
			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Statistiques/ProgressionSousPartiePromoProfScreen.fxml")));
			}
			catch(Exception e){
	        e.printStackTrace();
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
		// Initialise la choice box des participants
		String participant = "SELECT FiliereEtAnnee FROM Filiere WHERE FiliereEtAnnee <> 'Enseignant'";
			try {
				choixParticipants.getItems().add("Etudiant");
				preparedStatement = connection.prepareStatement(participant);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
				    choixParticipants.getItems().add(resultSet.getString(1));
				}
				
			}
			catch(Exception e){
				e.printStackTrace();
			}				
			String parti =  RésultatsProfScreenController.getParti();
			nomPromo.setText(parti);
	}
}
