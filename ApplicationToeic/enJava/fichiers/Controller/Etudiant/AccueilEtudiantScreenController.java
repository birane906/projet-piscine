package enJava.fichiers.Controller.Etudiant;

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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import enJava.fichiers.Config.ConnectionUtil;
import enJava.fichiers.Controller.Login.FXMLDocumentController;

public class AccueilEtudiantScreenController implements Initializable {
	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null; //stocke les TOEIC programmés pour une promo
    ResultSet resultSet1 = null; //stock les dates des toeic programmés
    ResultSet resultSet2 = null; //stocke la différence entre la date actuelle et la date du futur toeic
    ResultSet resultSet3 = null;
    ResultSet resultSet4 = null;
    ResultSet resultSet0 = null;
    @FXML
    Text NomPrenom;
    
    
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
            
            
            if(resultSet.next()){ //si au moins un toeic est programmé pour un étudiant d'une promo donnée
            	
            	String sqlDate = "SELECT Date FROM Programmer WHERE Programmer.NumToeic = ?";
                preparedStatement = connection.prepareStatement(sqlDate);
                preparedStatement.setString(1, Integer.toString(resultSet.getInt(1)));
                resultSet1 = preparedStatement.executeQuery();
                if(resultSet1.next()) { //on récupère les dates des toeic
                
                	String sqlDate1 = "SELECT DATEDIFF(?,?)";
                	preparedStatement = connection.prepareStatement(sqlDate1);
                	preparedStatement.setDate(1, resultSet1.getDate(1));
                	preparedStatement.setDate(2, new java.sql.Date(System.currentTimeMillis()));
                	resultSet2 = preparedStatement.executeQuery();
                	
                	if(resultSet2.next()) { //on vérifie si le prochain toeic est programmé aujourd'hui
                		if(resultSet2.getInt(1) == 0) {
                			String sql2="SELECT idUtilisateur FROM Utilisateur WHERE Utilisateur.MailUtilisateur = ? AND Utilisateur.MdpUtilisateur = ?";
                			preparedStatement = connection.prepareStatement(sql2);
                        	preparedStatement.setString(1, FXMLDocumentController.mail());
                        	preparedStatement.setString(2, FXMLDocumentController.mdp());
                        	resultSet3 = preparedStatement.executeQuery();
                        	if(resultSet3.next()) {
                        		String sql3 = "SELECT * FROM Passer WHERE Passer.NumTOEIC = ? AND Passer.idUtilisateur = ?";
                        		preparedStatement = connection.prepareStatement(sql3);
                            	preparedStatement.setInt(1, resultSet.getInt(1));
                            	preparedStatement.setInt(2, resultSet3.getInt(1));
                            	resultSet4=preparedStatement.executeQuery();
                            	if(!resultSet4.next()) {
                				Node node = (Node)event.getSource();
                				dialogStage = (Stage) node.getScene().getWindow();
                				dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Etudiant/Toeic/DémarrerTOEICScreen.fxml")));
                            	}
                            	else {
                            		Node node = (Node)event.getSource();
                        			dialogStage = (Stage) node.getScene().getWindow();
                        			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Etudiant/Toeic/PasDeTOEICProgScreen.fxml")));
                            		
                            	}
                        	}
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
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Etudiant/Statistiques/MesRésultatsEtudiantScreen.fxml")));
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
		try {
			String sqlNP="SELECT NomUtilisateur,PrenomUtilisateur FROM Utilisateur WHERE Utilisateur.MailUtilisateur = ? AND Utilisateur.MdpUtilisateur = ?";
			preparedStatement = connection.prepareStatement(sqlNP);
        	preparedStatement.setString(1, FXMLDocumentController.mail());
        	preparedStatement.setString(2, FXMLDocumentController.mdp());
        	resultSet0 = preparedStatement.executeQuery();
        	if(resultSet0.next()) {
        		NomPrenom.setText(resultSet0.getString(1)+ " " + resultSet0.getString(2));
        	}
		}
		catch(Exception e){
            e.printStackTrace();
        
		
		}

	}
}
