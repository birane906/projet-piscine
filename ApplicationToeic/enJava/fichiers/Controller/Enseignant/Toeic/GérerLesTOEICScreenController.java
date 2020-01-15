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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GérerLesTOEICScreenController implements Initializable{

	@FXML
	Text nomTOEIC1;
	@FXML
	Text nomTOEIC2;
	@FXML
	Text nomTOEIC3;
	
	@FXML
	Text nomTOEIC12;
	@FXML
	Text nomTOEIC22;
	@FXML
	Text nomTOEIC32;
	
	@FXML
	Text nomEnseignant1;
	@FXML
	Text nomEnseignant2;
	@FXML
	Text nomEnseignant3;
	
	@FXML
	Text Date1;
	@FXML
	Text Date2;
	@FXML
	Text Date3;
	
	@FXML
	Text Participants1;
	@FXML
	Text Participants2;
	@FXML
	Text Participants3;
	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public GérerLesTOEICScreenController() {
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
	
	// Bouton pour afficher les TOEIC existants
		public void AfficherTOEIC(ActionEvent event) {
			try {	
				Node node = (Node)event.getSource();
	            dialogStage = (Stage) node.getScene().getWindow();
	            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Toeic/AfficherTousLesTOEICSScreen.fxml")));
			}
			catch(Exception e){
	            e.printStackTrace();
	        }
		}

		// Bouton pour afficher les TOEIC programmés
		public void AfficherTOEICProg(ActionEvent event) {
			try {	
				Node node = (Node)event.getSource();
	            dialogStage = (Stage) node.getScene().getWindow();
	            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Toeic/AfficherTOEICProgrammésScreen.fxml")));
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
			// Permet de montrer les derniers toeic de la BDD
			String TOEIC = "SELECT LibelleTOEIC FROM Toeic";			
			try {
				preparedStatement = connection.prepareStatement(TOEIC);
				resultSet = preparedStatement.executeQuery();
				String cou ="SELECT COUNT(*) FROM Toeic";
				preparedStatement = connection.prepareStatement(cou);
				ResultSet resultSetC = preparedStatement.executeQuery();
				resultSetC.next();
				int count = resultSetC.getInt(1);
				if(count == 0) {
					nomTOEIC1.setText("Pas de TOEIC existant");
					nomTOEIC2.setText("Pas de TOEIC existant");
					nomTOEIC3.setText("Pas de TOEIC existant");
				}
				if (resultSet.next()) {
					if(count == 1) {
						nomTOEIC1.setText(resultSet.getString(1));
						nomTOEIC2.setText("Pas de TOEIC existant");
						nomTOEIC3.setText("Pas de TOEIC existant");
					}
					if(count == 2) {
						nomTOEIC1.setText(resultSet.getString(1));
						resultSet.next();
						nomTOEIC2.setText(resultSet.getString(1));
						nomTOEIC3.setText("Pas de TOEIC existant");

					}
					if(count >=3) {
						nomTOEIC1.setText(resultSet.getString(1));
						resultSet.next();
						nomTOEIC2.setText(resultSet.getString(1));
						resultSet.next();
						nomTOEIC3.setText(resultSet.getString(1));
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			String prog = "SELECT Date, FiliereEtAnnee,NumTOEIC FROM Programmer ORDER BY Date";			
			try {
				preparedStatement = connection.prepareStatement(prog);
				resultSet = preparedStatement.executeQuery();
				String cou ="SELECT COUNT(*) FROM Programmer";
				preparedStatement = connection.prepareStatement(cou);
				ResultSet resultSetC = preparedStatement.executeQuery();
				resultSetC.next();
				int count = resultSetC.getInt(1);
				if(count == 0) {
					nomTOEIC12.setText("Pas de TOEIC existant");
					nomTOEIC22.setText("Pas de TOEIC existant");
					nomTOEIC32.setText("Pas de TOEIC existant");
				}
				if (resultSet.next()) {
					String nom = "SELECT LibelleTOEIC FROM Toeic WHERE NumTOEIC = ?";
					preparedStatement = connection.prepareStatement(nom);
					preparedStatement.setInt(1, resultSet.getInt(3));
					ResultSet resultSetD = preparedStatement.executeQuery();
					resultSetD.next();
					if(count == 1) {
						Date1.setText(resultSet.getString(1));
						nomTOEIC12.setText(resultSetD.getString(1));
						Participants1.setText(resultSet.getString(2));
						nomTOEIC22.setText("Pas de TOEIC existant");
						nomTOEIC32.setText("Pas de TOEIC existant");
					}
					if(count == 2) {
						Date1.setText(resultSet.getString(1));
						nomTOEIC12.setText(resultSetD.getString(1));
						Participants1.setText(resultSet.getString(2));
						resultSet.next();
						nom = "SELECT LibelleTOEIC FROM Toeic WHERE NumTOEIC = ?";
						preparedStatement = connection.prepareStatement(nom);
						preparedStatement.setInt(1, resultSet.getInt(3));
						resultSetD = preparedStatement.executeQuery();
						resultSetD.next();
						Date2.setText(resultSet.getString(1));
						nomTOEIC22.setText(resultSetD.getString(1));
						Participants2.setText(resultSet.getString(2));
						nomTOEIC32.setText("Pas de TOEIC existant");

					}
					if(count >=3) {
						Date1.setText(resultSet.getString(1));
						nomTOEIC12.setText(resultSetD.getString(1));
						Participants1.setText(resultSet.getString(2));
						resultSet.next();
						nom = "SELECT LibelleTOEIC FROM Toeic WHERE NumTOEIC = ?";
						preparedStatement = connection.prepareStatement(nom);
						preparedStatement.setInt(1, resultSet.getInt(3));
						resultSetD = preparedStatement.executeQuery();
						resultSetD.next();
						Date2.setText(resultSet.getString(1));
						nomTOEIC22.setText(resultSetD.getString(1));
						Participants2.setText(resultSet.getString(2));
						resultSet.next();
						nom = "SELECT LibelleTOEIC FROM Toeic WHERE NumTOEIC = ?";
						preparedStatement = connection.prepareStatement(nom);
						preparedStatement.setInt(1, resultSet.getInt(3));
						resultSetD = preparedStatement.executeQuery();
						resultSetD.next();
						Date3.setText(resultSet.getString(1));
						nomTOEIC32.setText(resultSetD.getString(1));
						Participants3.setText(resultSet.getString(2));
						
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
}
