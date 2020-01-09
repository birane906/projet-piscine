package loginScreen.Etudiant;

import java.net.URL;
import java.util.ResourceBundle;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import loginScreen.Login.ConnectionUtil;
import loginScreen.Login.FXMLDocumentController;

public class AccueilEtudiantScreenController implements Initializable {
	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public AccueilEtudiantScreenController() {
        connection = ConnectionUtil.connectdb();
    }
	
	public void DeconnexionAction(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../Login/FXMLDocument.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public void LancerTest(ActionEvent event) {
		try {
			
			String sql = "SELECT numTOEIC FROM Programmer INNER JOIN Utilisateur ON Programmer.FiliereEtAnnee = Utilisateur.FiliereEtAnnee WHERE Utilisateur.MailUtilisateur = ? AND Utilisateur.MdpUtilisateur = ?";
			preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, FXMLDocumentController.mail());
            preparedStatement.setString(2, FXMLDocumentController.mdp());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
            	Node node = (Node)event.getSource();
            	dialogStage = (Stage) node.getScene().getWindow();
            	dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("./DémarrerTOEICScreen.fxml")));
            }
            else {
            	Node node = (Node)event.getSource();
            	dialogStage = (Stage) node.getScene().getWindow();
            	dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("./PasDeTOEICProgScreen.fxml")));
            }
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public void Resultat(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../StatsEtudiant/MesRésultatsEtudiantScreen.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public void Contact(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("./ContactEnseignant.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
