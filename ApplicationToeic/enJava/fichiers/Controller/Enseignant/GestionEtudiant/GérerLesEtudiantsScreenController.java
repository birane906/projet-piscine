package enJava.fichiers.Controller.Enseignant.GestionEtudiant;

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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class GérerLesEtudiantsScreenController implements Initializable{

	@FXML
	ChoiceBox<String> choixPromo;
	@FXML
	private TextField nomEtu;
	@FXML
	private TextField prenomEtu;
	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public GérerLesEtudiantsScreenController() {
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
	
	// Bouton pour aller ajouter un étudiant
	public void AjoutEtudiant(ActionEvent event) {
		try {	
			Node node = (Node)event.getSource();
	        dialogStage = (Stage) node.getScene().getWindow();
	        dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/GestionEtudiant/CréerUnEtudiantScreen.fxml")));
	        }
		catch(Exception e){
			e.printStackTrace();
	    }
	}
	
	// Bouton pour aller modifier un étudiant
	public void ModifierEtu(ActionEvent event) {
		try {
			String NomE = nomEtu.getText().toString();
			String PrenomE = prenomEtu.getText().toString();
			String PromoE = (String) choixPromo.getValue();
			if(NomE != null) {
				if(PrenomE != null) {
					if(PromoE != null){
						String etu = "SELECT COUNT(*),idUtilisateur FROM Utilisateur WHERE NomUtilisateur = ? AND PrenomUtilisateur = ? AND FiliereEtAnnee = ?";
					
						try {
							preparedStatement = connection.prepareStatement(etu);
				            preparedStatement.setString(1, NomE);
				            preparedStatement.setString(2, PrenomE);
				            preparedStatement.setString(3, PromoE);
				            resultSet = preparedStatement.executeQuery();
				            if (resultSet.next()) {
				            	if(resultSet.getInt(1) == 0) {
				            		infoBox("Il n'existe pas d'étudiant ayant ces informations, veuillez réessayer.", null,"Erreur");
				            	}
				            	else {     
				            		Node node = (Node)event.getSource();
				        			dialogStage = (Stage) node.getScene().getWindow();
				        			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/GestionEtudiant/ModifierEtudiantScreen.fxml")));
				            	}
				            }
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
					else {
						infoBox("Vous devez rentrer la filière de l'étudiant.", null,"Erreur");
					}
				}
				else {
					infoBox("Vous devez rentrer le prénom de l'étudiant.", null,"Erreur");
				}	
			}
			else {
				infoBox("Vous devez rentrer le nom de l'étudiant.", null,"Erreur");
			}
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
		// On initialise la choice box des participants et des promos
				String participant = "SELECT FiliereEtAnnee FROM Filiere WHERE FiliereEtAnnee <> 'Enseignant'";
				try {
					preparedStatement = connection.prepareStatement(participant);
					resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
					    choixPromo.getItems().add(resultSet.getString(1));
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
	}

}
