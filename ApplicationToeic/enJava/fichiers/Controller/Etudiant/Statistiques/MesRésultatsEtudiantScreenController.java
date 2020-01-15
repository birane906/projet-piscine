package enJava.fichiers.Controller.Etudiant.Statistiques;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import enJava.fichiers.Config.ConnectionUtil;
import enJava.fichiers.Controller.Login.FXMLDocumentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

public class MesRésultatsEtudiantScreenController implements Initializable {


	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public MesRésultatsEtudiantScreenController() {
        connection = ConnectionUtil.connectdb();
    }
	
	// Bouton Home
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
	
	// Bouton bulletin
	public void Bulletin(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
			dialogStage = (Stage) node.getScene().getWindow();
			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Etudiant/Statistiques/BulletinEtudiantScreen.fxml")));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// Bouton progression par partie
	public void PPP(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
			dialogStage = (Stage) node.getScene().getWindow();
			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Etudiant/Statistiques/ProgressionParPartieEtudiantScreen.fxml")));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	// Bouton progression par sous partie
	public void PPSP(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
			dialogStage = (Stage) node.getScene().getWindow();
			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Etudiant/Statistiques/ProgressionSousPartieEtudiantScreen.fxml")));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	// Bouton pour voir le recap du dernier TOEIC passé
	public void Récap(ActionEvent event) {
		try {
			String sql ="SELECT NomUtilisateur, PrenomUtilisateur FROM Utilisateur WHERE MailUtilisateur = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, FXMLDocumentController.mail());
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			String NomE = resultSet.getString(1);
			String PrenomE = resultSet.getString(2);
			try {
				String id = "SELECT idUtilisateur FROM Utilisateur WHERE NomUtilisateur = ? AND PrenomUtilisateur = ?";
				
				preparedStatement = connection.prepareStatement(id);
				preparedStatement.setString(1, NomE);
				preparedStatement.setString(2, PrenomE);
				ResultSet resultSet2 = preparedStatement.executeQuery();
				resultSet2.next();
				int idU = resultSet2.getInt(1);

				String passer = "SELECT COUNT(*) FROM Passer WHERE idUtilisateur = ?";

				preparedStatement = connection.prepareStatement(passer);
				preparedStatement.setInt(1, idU);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					if(resultSet.getInt(1) == 0) {
						Node node = (Node)event.getSource();
						dialogStage = (Stage) node.getScene().getWindow();
						dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Etudiant/Statistiques/RécapPasDeDernierTOEICEtudiantScreen.fxml")));
					}
					else {
						Node node = (Node)event.getSource();
						dialogStage = (Stage) node.getScene().getWindow();
						dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Etudiant/Statistiques/RécapDernierTOEICEtudiantScreen.fxml")));
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
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
