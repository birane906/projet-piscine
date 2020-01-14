package enJava.fichiers.Controller.Enseignant;

import enJava.fichiers.Config.ConnectionUtil;
import enJava.fichiers.Controller.Login.FXMLDocumentController;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AccueilProfScreenController implements Initializable {
	
	
	@FXML
	Text NomPrenom;
	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public AccueilProfScreenController() {
        connection = ConnectionUtil.connectdb();
    }

	public void DeconnexionAction(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Login/FXMLDocument.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public void G�rerLesTOEIC(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Enseignant/Toeic/G�rerLesTOEICScreen.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public void Resultat(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Enseignant/Statistiques/R�sultatsProfScreen.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public void G�rerLesEtudiants(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Enseignant/GestionEtudiant/G�rerLesEtudiantsScreen.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Permet d'afficher le nom du prof sur l'accueil
		// On r�cup�re l'idUtilisateur du prof
		String sql2 = "SELECT NomUtilisateur,PrenomUtilisateur FROM Utilisateur WHERE Utilisateur.MailUtilisateur = ? AND Utilisateur.MdpUtilisateur = ?";
		try {
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setString(1, FXMLDocumentController.mail());
	        preparedStatement.setString(2, FXMLDocumentController.mdp());
	        resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	        	String nom = resultSet.getString(1);
	        	String prenom = resultSet.getString(2);
	        	NomPrenom.setText(nom + " " + prenom +  ".");
	        }
		}
	    catch (SQLException e) {
	    	e.printStackTrace();
		}
	}
}
