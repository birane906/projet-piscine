package prog.fichiers.Controller.Etudiant;

//import de fichier java
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import prog.fichiers.Config.ConnectionUtil;
import prog.fichiers.Controller.Login.FXMLDocumentController;

public class AccueilEtudiantScreenController implements Initializable {
	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null; //stocke les TOEIC programm�s pour une promo
    ResultSet resultSet1 = null; //stock les dates des toeic programm�s
    ResultSet resultSet2 = null; //stocke la diff�rence entre la date actuelle et la date du futur toeic
	
	public AccueilEtudiantScreenController() {
        connection = ConnectionUtil.connectdb();
    }

	
	public void DeconnexionAction(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/login/FXMLDocument.fxml")));
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
            
            
            if(resultSet.next()){ //si au moins un toeic est programm� pour un �tudiant d'une promo donn�e
            	
            	String sqlDate = "SELECT Date FROM Programmer WHERE Programmer.NumToeic = ?";
                preparedStatement = connection.prepareStatement(sqlDate);
                preparedStatement.setString(1, Integer.toString(resultSet.getInt(1)));
                resultSet1 = preparedStatement.executeQuery();
                if(resultSet1.next()) { //on r�cup�re les dates des toeic
                
                	String sqlDate1 = "SELECT DATEDIFF(?,?)";
                	preparedStatement = connection.prepareStatement(sqlDate1);
                	preparedStatement.setDate(1, resultSet1.getDate(1));
                	preparedStatement.setDate(2, new java.sql.Date(System.currentTimeMillis()));
                	resultSet2 = preparedStatement.executeQuery();
                	
                	if(resultSet2.next()) { //on v�rifie si le prochain toeic est programm� aujourd'hui
                		if(resultSet2.getInt(1) == 0) {
                			Node node = (Node)event.getSource();
                			dialogStage = (Stage) node.getScene().getWindow();
                			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Etudiant/Toeic/D�marrerTOEICScreen.fxml")));
                		}
                		else {
                			Node node = (Node)event.getSource();
                			dialogStage = (Stage) node.getScene().getWindow();
                			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Etudiant/Toeic/PasDeTOEICProgScreen.fxml")));
                		}
                	}
                }
            }
            else {
            	Node node = (Node)event.getSource();
            	dialogStage = (Stage) node.getScene().getWindow();
            	dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Etudiant/Toeic/PasDeTOEICProgScreen.fxml")));
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
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Etudiant/Statistiques/MesR�sultatsEtudiantScreen.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public void Contact(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Etudiant/InfosEnseignants/ContactEnseignant.fxml")));
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
