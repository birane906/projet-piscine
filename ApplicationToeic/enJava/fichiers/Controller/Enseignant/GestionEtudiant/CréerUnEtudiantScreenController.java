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

public class CréerUnEtudiantScreenController implements Initializable{

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
	
	public CréerUnEtudiantScreenController() {
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
	
	// Bouton pour retourner à la gestion des étudiants
	public void RetourGérerEtudiant(ActionEvent event) {
		try {	
			Node node = (Node)event.getSource();
	        dialogStage = (Stage) node.getScene().getWindow();
	        dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/GestionEtudiant/GérerLesEtudiantsScreen.fxml")));
	        }
		catch(Exception e){
			e.printStackTrace();
	    }
	}
	
	// Bouton pour créer un étudiant
	public void Enregistrer(ActionEvent event) {
		String nomE = nomEtu.getText().toString();
		String prenomE = prenomEtu.getText().toString();
		String promoE = (String) choixPromo.getValue();
		if(!nomE.equals("Entrer le nom ici") && !nomE.isBlank()) {
			if(!prenomE.equals("Entrer le prénom ici") && !prenomE.isBlank()) {
				if(promoE != null){
					int idU = 1;
	            	Boolean rep = false;
	            	// On va chercher le premier idUtilisateur disponible en partant de 1
	            	while (!rep) {
	            		String test ="SELECT COUNT(*) FROM Utilisateur WHERE idUtilisateur = ?";
	            	
	            		try {
	            			preparedStatement = connection.prepareStatement(test);
	            			preparedStatement.setInt(1, idU);
	            			resultSet = preparedStatement.executeQuery();
	            			if(resultSet.next()) {
	            				int count = resultSet.getInt(1);
	            				if(count == 0) {
	            					rep = true;
	            				}	
	            				else {
	            					idU = idU + 1;
	            				}
	            			}
	            		}
	            		catch(Exception e){
        			      	e.printStackTrace();
        			   	}
	            	}
	      		
	        		String etu = "SELECT COUNT(*),idUtilisateur FROM Utilisateur WHERE NomUtilisateur = ? AND PrenomUtilisateur = ?";
	        	
	        		try {
    					preparedStatement = connection.prepareStatement(etu);
    			        preparedStatement.setString(1, nomE);
    			        preparedStatement.setString(2, prenomE);
    			        resultSet = preparedStatement.executeQuery();
    			        if (resultSet.next()) {
    			           	if(resultSet.getInt(1) == 0) {   		
    			           		String créationE = "INSERT into Utilisateur (idUtilisateur,NomUtilisateur,PrenomUtilisateur,MailUtilisateur,MdpUtilisateur,AdminUtilisateur,FiliereEtAnnee) VALUES (?,?,?,?,?,?,?)";
            	           		preparedStatement = connection.prepareStatement(créationE);
                           		preparedStatement.setInt(1, idU);
                                preparedStatement.setString(2, nomE);
                                preparedStatement.setString(3, prenomE);
                                String mailU = prenomE.toLowerCase()+"."+nomE.toLowerCase()+"@etu.umontpellier.fr";
                                String mdpU = prenomE+nomE;
                                preparedStatement.setString(4,mailU);
                                preparedStatement.setString(5,mdpU);
                                preparedStatement.setInt(6, 0);
                                preparedStatement.setString(7,promoE);
                                preparedStatement.executeUpdate();
                                créationE = "INSERT into Utilisateur (idUtilisateur,NomUtilisateur,PrenomUtilisateur,MailUtilisateur,MdpUtilisateur,AdminUtilisateur,FiliereEtAnnee,) VALUES (?,?,?,?,?,?,?)";
                                infoBox("Etudiant créé avec succès, le mot de passe initial est PrenomNom.", null,"Success");
    			            }
    			            else {
    				            infoBox("Cet étudiant existe déjà.", null,"Erreur");
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
	}
}
