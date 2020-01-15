package enJava.fichiers.Controller.Etudiant.InfosEnseignants;

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

public class ContacterEnseignantController implements Initializable {

	@FXML
	Text nomE1;
	@FXML
	Text nomE2;
	
	@FXML
	Text mailE1;
	@FXML
	Text mailE2;
	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public ContacterEnseignantController() {
        connection = ConnectionUtil.connectdb();
    }

	public void Home(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Etudiant/AccueilEtudiantScreen.fxml")));
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
		// On affiche les deux enseignants
		String sql ="SELECT NomUtilisateur,PrenomUtilisateur,MailUtilisateur FROM Utilisateur WHERE AdminUtilisateur = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            nomE1.setText(resultSet.getString(1)+" "+ resultSet.getString(2));
            mailE1.setText(resultSet.getString(3));
            resultSet.next();
            nomE2.setText(resultSet.getString(1)+" "+ resultSet.getString(2));
            mailE2.setText(resultSet.getString(3));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
}
