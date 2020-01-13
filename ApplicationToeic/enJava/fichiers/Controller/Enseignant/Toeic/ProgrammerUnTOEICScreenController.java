package enJava.fichiers.Controller.Enseignant.Toeic;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import enJava.fichiers.Config.ConnectionUtil;
import enJava.fichiers.Controller.Login.FXMLDocumentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ProgrammerUnTOEICScreenController implements Initializable{

	@FXML
	ChoiceBox<String> NomTOEIC;
	@FXML
	ChoiceBox<String> choixParticipants;
	@FXML
	DatePicker date;

	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public ProgrammerUnTOEICScreenController() {
        connection = ConnectionUtil.connectdb();
    }
	
	// Fonction permettant de programmer un TOEIC
	
	public void Enregistrer(ActionEvent event) {
		// On r�cup�re le nom de toeic dans la choice box, et on v�rifie qu'il y a bien eu une s�lection
		String nom = (String) NomTOEIC.getValue();
		if(nom != null) {
			// On r�cup�re les participants dans la choice box, et on v�rifie qu'il y a bien eu une s�lection
			String participants = (String) choixParticipants.getValue();
			if(participants != null) {
				// On r�cup�re la date dans la choice box, et on v�rifie qu'il y a bien eu une s�lection
				LocalDate da = date.getValue();
				if(da != null) {
					// On r�cup�re le numTOEIC qui correspond au libelleTOEIC s�lectionn�
					String numT = "SELECT NumTOEIC FROM Toeic WHERE LibelleTOEIC = ?";
					try {
						preparedStatement = connection.prepareStatement(numT);
	    	            preparedStatement.setString(1, nom);
	    	            resultSet = preparedStatement.executeQuery();
	    	            if(resultSet.next()) {
	    	            	int numTOEIC = resultSet.getInt(1);
	    	            	// On r�cup�re l'idUtilisateur du prof
            				String sql2 = "SELECT idUtilisateur FROM Utilisateur WHERE Utilisateur.MailUtilisateur = ? AND Utilisateur.MdpUtilisateur = ?";
            				preparedStatement = connection.prepareStatement(sql2);
            	            preparedStatement.setString(1, FXMLDocumentController.mail());
            	            preparedStatement.setString(2, FXMLDocumentController.mdp());
            	            resultSet = preparedStatement.executeQuery();
            	            if (resultSet.next()) {
            	            	int idU = resultSet.getInt(1);
            	            	// On v�rifie qu'il n'y a pas ce toeic programm� la m�me date pour les participants
    	    	            	String prog = "SELECT COUNT(*) FROM Programmer WHERE FiliereEtAnnee = ? AND NumTOEIC = ? AND Date = ?";
    		    				preparedStatement = connection.prepareStatement(prog);
    		    	            preparedStatement.setString(1, participants);
    		    	            preparedStatement.setInt(2, numTOEIC);
    		    	            preparedStatement.setString(3, da.toString());
    		    	            resultSet = preparedStatement.executeQuery();
    		    	            if(resultSet.next()) {
    		    	            	if(resultSet.getInt(1)==0) {
    		    	            		// C'est bon, on peut l'ins�rer dans la BDD
    		    	            		String toeicProg = "INSERT into Programmer (Date,FiliereEtAnnee,NumTOEIC,Enseignant) VALUES (?,?,?,?)";
    	        	            		preparedStatement = connection.prepareStatement(toeicProg);
    	                        		preparedStatement.setString(1, da.toString());
    	                                preparedStatement.setString(2, participants);
    	                                preparedStatement.setInt(3, numTOEIC);
    	                                preparedStatement.setInt(4, idU);
    	                                preparedStatement.executeUpdate();
    	                                toeicProg = "INSERT into Programmer (Date,FiliereEtAnnee,NumTOEIC) VALUES (?,?,?)";
    	                                
    	                                infoBox("Le TOEIC a �t� enregistr� avec succ�s.", null, "Success");
    		    	            	}
    		    	            	else {
    		    	            		infoBox("Un TOEIC est d�j� programm� pour cette date et cette fili�re.", null ,"Erreur");
    		    	            	}
    		    	            }
            	            }
	    	            }
					}
					catch(Exception e){
		            	e.printStackTrace();
					}
				}
				else {
					infoBox("Veuillez s�lectionner une date.", null ,"Erreur");
				}
			}
			else {
				infoBox("Veuillez choisir une fili�re.", null ,"Erreur");
			}
		}
		else {
			infoBox("Veuillez choisir un TOEIC.", null ,"Erreur");
		}
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

	// Bouton retour page G�rer TOEIC
	public void RetourTOEICProgramm�(ActionEvent event) {
		try {	
			Node node = (Node)event.getSource();
		    dialogStage = (Stage) node.getScene().getWindow();
		    dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Toeic/AfficherTOEICProgramm�sScreen.fxml")));
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
		// Initialise la choice box des noms de toeic
		String nom = "SELECT LibelleTOEIC FROM Toeic";
		try {
			preparedStatement = connection.prepareStatement(nom);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	NomTOEIC.getItems().add(resultSet.getString(1)); 
            }
        }
		catch(Exception e){
        	e.printStackTrace();
        }
		
		// Initialise la choice box des participants
		String participant = "SELECT FiliereEtAnnee FROM Filiere WHERE FiliereEtAnnee <> 'Enseignant'";
		try {
			preparedStatement = connection.prepareStatement(participant);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	choixParticipants.getItems().add(resultSet.getString(1));
            }
        }
		catch(Exception e){
        	e.printStackTrace();
        }
	}

}
