package prog.fichiers.Controller.Etudiant;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import prog.fichiers.Config.ConnectionUtil;
import prog.fichiers.Controller.Login.FXMLDocumentController;

public class FinDeToeicController implements Initializable{
	
	Stage dialogStage = new Stage();
	
	@FXML
	Label rep;
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    ResultSet resultSet1 = null;
    ResultSet resultSet2 = null; 
    ResultSet resultSet3 = null; 
    ResultSet resultSet4 = null; 
    ResultSet resultSet5 = null;
	
	public FinDeToeicController() {
        connection = ConnectionUtil.connectdb();
    }
	
	public void home(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Etudiant/AccueilEtudiantScreen.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CalculNote note = new CalculNote();
		int noteE=note.noteE();
		int noteO=note.noteE();
		int tot=noteE+noteO;
		int p1 = note.getScoreP1();
		int p2 = note.getScoreP2();
		int p3 = note.getScoreP3();
		int p4 = note.getScoreP4();
		int p5 = note.getScoreP5();
		int p6 = note.getScoreP6();
		int p7 = note.getScoreP7();
		String noteTot = Integer.toString(tot);
		rep.setText(tot+"/990");
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
                	if(resultSet2.next()) {
                		String sql1 = "SELECT idUtilisateur FROM Utilisateur WHERE Utilisateur.MailUtilisateur = ? AND Utilisateur.MdpUtilisateur = ?";
                		preparedStatement = connection.prepareStatement(sql1);
                		preparedStatement.setString(1, FXMLDocumentController.mail());
                		preparedStatement.setString(2, FXMLDocumentController.mdp());
                		resultSet3 = preparedStatement.executeQuery();
                		if(resultSet3.next()) {
                			String sql2 = "SELECT ReponseE,NumQuestion FROM Repondre WHERE Repondre.idUtilisateur = ? ";
                			preparedStatement = connection.prepareStatement(sql2);
                			preparedStatement.setInt(1,resultSet3.getInt(1));
                			resultSet4 = preparedStatement.executeQuery();
                			while(resultSet4.next()) {
                				String sql4 = "SELECT CorrectionQuestion FROM Question WHERE Question.NumTOEIC = ? AND Question.NumQuestion = ?";
                				preparedStatement = connection.prepareStatement(sql4);
                				preparedStatement.setInt(1, resultSet.getInt(1));
                				preparedStatement.setInt(2, resultSet4.getInt(2));
                				resultSet5 = preparedStatement.executeQuery();
                				
                    		}
                			
                		}
					}
				}
				
			}
        }
		catch(Exception e){
            e.printStackTrace();
        }
    }

}
