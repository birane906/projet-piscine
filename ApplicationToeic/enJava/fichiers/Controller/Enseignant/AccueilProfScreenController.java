package enJava.fichiers.Controller.Enseignant;

import enJava.fichiers.Config.ConnectionUtil;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AccueilProfScreenController implements Initializable {
	
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
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Enseignant//GestionEtudiant/G�rerLesEtudiantsScreen.fxml")));
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
