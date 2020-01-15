package enJava.fichiers.Controller.Enseignant.GestionEtudiant;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import enJava.fichiers.Controller.Enseignant.GestionEtudiant.GérerLesEtudiantsScreenController;
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

public class ModifierEtudiantScreenController implements Initializable {

Stage dialogStage = new Stage();
	
	@FXML
	ChoiceBox<String> choixPromo;
	@FXML
	private TextField nomEtu;
	@FXML
	private TextField prenomEtu;

	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public ModifierEtudiantScreenController() {
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
	
	// Bouton retour
	public void RetourGérer(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
			dialogStage = (Stage) node.getScene().getWindow();
			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/GestionEtudiant/GérerLesEtudiantsScreen.fxml")));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	// Bouton pour enregistrer
	public void Enregistrer(ActionEvent event) {
		try {
			String NomE = nomEtu.getText().toString();
			String PrenomE = prenomEtu.getText().toString();
			String PromoE = (String) choixPromo.getValue();
			if(!NomE.isBlank()) {
				if(!PrenomE.isBlank()) {
					if(PromoE != null){
						String up = "UPDATE Utilisateur SET NomUtilisateur = ? WHERE NomUtilisateur = ? AND PrenomUtilisateur = ?";
					
						String MailE = PrenomE.toLowerCase()+"."+NomE.toLowerCase()+"@etu.umontpellier.fr";
						String mdpE = PrenomE+NomE;
						preparedStatement = connection.prepareStatement(up);
						preparedStatement.setString(1, NomE);
						preparedStatement.setString(2, GérerLesEtudiantsScreenController.nom());
						preparedStatement.setString(3, GérerLesEtudiantsScreenController.prenom());
						preparedStatement.executeUpdate();
						up = "UPDATE Utilisateur SET PrenomUtilisateur = ? WHERE NomUtilisateur = ? AND PrenomUtilisateur = ?";
						preparedStatement = connection.prepareStatement(up);
						preparedStatement.setString(1, PrenomE);
						preparedStatement.setString(2, NomE);
						preparedStatement.setString(3, GérerLesEtudiantsScreenController.prenom());
						preparedStatement.executeUpdate();
						up = "UPDATE Utilisateur SET MdpUtilisateur = ? WHERE NomUtilisateur = ? AND PrenomUtilisateur = ?";
						preparedStatement = connection.prepareStatement(up);
						preparedStatement.setString(1, mdpE);
						preparedStatement.setString(2, NomE);
						preparedStatement.setString(3, PrenomE);
						preparedStatement.executeUpdate();
						up = "UPDATE Utilisateur SET MailUtilisateur = ? WHERE NomUtilisateur = ? AND PrenomUtilisateur = ?";
						preparedStatement = connection.prepareStatement(up);
						preparedStatement.setString(1, MailE);
						preparedStatement.setString(2, NomE);
						preparedStatement.setString(3, PrenomE);
						preparedStatement.executeUpdate();
						up = "UPDATE Utilisateur SET FiliereEtAnnee = ? WHERE NomUtilisateur = ? AND PrenomUtilisateur = ?";
						preparedStatement = connection.prepareStatement(up);
						preparedStatement.setString(1, PromoE);
						preparedStatement.setString(2, NomE);
						preparedStatement.setString(3, PrenomE);
						preparedStatement.executeUpdate();
						infoBox("Le changement a bien été effectué, le mot de passe est désormais PrenomNom.", null,"Success");

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
	
	// Bouton pour supprimer
	public void Supprimer(ActionEvent event) {
		String nomE = nomEtu.getText().toString();
		String prenomE = prenomEtu.getText().toString();
		String promoE = (String) choixPromo.getValue();
		if(!nomE.isBlank()) {
			if(!prenomE.isBlank()) {
				if(promoE != null){
					
	        		String etu = "SELECT COUNT(*),idUtilisateur FROM Utilisateur WHERE NomUtilisateur = ? AND PrenomUtilisateur = ?";
	        	
	        		try {
    					preparedStatement = connection.prepareStatement(etu);
    			        preparedStatement.setString(1, nomE);
    			        preparedStatement.setString(2, prenomE);
    			        resultSet = preparedStatement.executeQuery();
    			        if (resultSet.next()) {
    			           	if(resultSet.getInt(1) != 0) {   		
    			           		int idU = resultSet.getInt(2);
    			           		
    			           		String del = "DELETE FROM Notes WHERE idUtilisateur = ?";
    			           		preparedStatement = connection.prepareStatement(del);
    	    			        preparedStatement.setInt(1, idU);
    	    			        preparedStatement.executeUpdate();
    	    			        
    	    			        del = "DELETE FROM Passer WHERE idUtilisateur = ?";
    			           		preparedStatement = connection.prepareStatement(del);
    	    			        preparedStatement.setInt(1, idU);
    	    			        preparedStatement.executeUpdate();
    	    			        
    	    			        del = "DELETE FROM Repondre WHERE idUtilisateur = ?";
    			           		preparedStatement = connection.prepareStatement(del);
    	    			        preparedStatement.setInt(1, idU);
    	    			        preparedStatement.executeUpdate();
                                infoBox("Etudiant supprimé avec succès.", null,"Success");
                                
                                del = "DELETE FROM Utilisateur WHERE idUtilisateur = ?";
    			           		preparedStatement = connection.prepareStatement(del);
    	    			        preparedStatement.setInt(1, idU);
    	    			        preparedStatement.executeUpdate();
    			            }
    			            else {
    				            infoBox("Cet étudiant n'existe pas.", null,"Erreur");
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
		nomEtu.setText(GérerLesEtudiantsScreenController.nom());
		prenomEtu.setText(GérerLesEtudiantsScreenController.prenom());
		
		String filiere = "SELECT FiliereEtAnnee FROM Utilisateur WHERE NomUtilisateur = ? AND PrenomUtilisateur =?";
		try {
			preparedStatement = connection.prepareStatement(filiere);
			preparedStatement.setString(1,nomEtu.getText().toString());
			preparedStatement.setString(2,prenomEtu.getText().toString());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				choixPromo.setValue(resultSet.getString(1));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
