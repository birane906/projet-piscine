package enJava.fichiers.Controller.Etudiant.Toeic;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import enJava.fichiers.Config.ConnectionUtil;
import enJava.fichiers.Controller.Login.FXMLDocumentController;

public class QuestionnaireController implements Initializable{

	

	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    ResultSet resultSet2= null;
    
    @FXML
    private ToggleGroup q1,q2,q3,q4,q5,q6;
    private ArrayList<ToggleGroup> listeTog = new ArrayList<ToggleGroup>();
    
    @FXML
    RadioButton A1,A2,A3,A4,A5,A6;
    @FXML
    RadioButton B1,B2,B3,B4,B5,B6;
    @FXML
    RadioButton C1,C2,C3,C4,C5,C6;
    @FXML
    RadioButton D1,D2,D3,D4,D5,D6;
    
	
	public QuestionnaireController() {
        connection = ConnectionUtil.connectdb();
    }
	
	
	public void next(ActionEvent event) {
		try {
			String sql = "SELECT idUtilisateur FROM Utilisateur WHERE Utilisateur.MailUtilisateur = ? AND Utilisateur.MdpUtilisateur = ?";
			preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, FXMLDocumentController.mail());
            preparedStatement.setString(2, FXMLDocumentController.mdp());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
            	/*listeTog.add(q1);
            	listeTog.add(q2);
            	listeTog.add(q3);
            	listeTog.add(q4);
            	listeTog.add(q5);
            	listeTog.add(q6);*/
            	
            	String sql2 = "INSERT INTO Repondre (NumPart,NumQuestion,idUtilisateur,ReponseE) VALUES (?, ?, ?, ?)";
            	String sql3 = "UPDATE Repondre SET Repondre.ReponseE = ? WHERE Repondre.idUtilisateur = ? AND Repondre.NumPart = ? AND Repondre.NumQuestion = ? ";
            	String sql4 = "SELECT * FROM Repondre WHERE Repondre.idUtilisateur = ? AND Repondre.NumPart = ? AND Repondre.NumQuestion = ?";
            	
            	for(int i = 1; i <= 6; i++) {
            		preparedStatement = connection.prepareStatement(sql4);
                	preparedStatement.setInt(1,resultSet.getInt(1));
                	preparedStatement.setInt(2,1);
                	preparedStatement.setInt(3,i);
                	resultSet2 = preparedStatement.executeQuery();
                	if(!resultSet2.next()) {
                	
                		preparedStatement = connection.prepareStatement(sql2);
                		preparedStatement.setInt(1, 1);
                		preparedStatement.setInt(2, i);
                		preparedStatement.setInt(3,resultSet.getInt(1));
                		RadioButton rb = (RadioButton)listeTog.get(i-1).getSelectedToggle();
                		if (rb !=null) {
                			preparedStatement.setString(4,rb.getText());
                			preparedStatement.executeUpdate();
                		}
                		sql2 = "INSERT INTO Repondre (NumPart,NumQuestion,idUtilisateur,ReponseE) VALUES (?, ?, ?, ?)";
                	}
                	else {
                		preparedStatement = connection.prepareStatement(sql3);
                		preparedStatement.setInt(2,resultSet.getInt(1));
                		preparedStatement.setInt(3,1);
                		preparedStatement.setInt(4,i);
                		RadioButton rb = (RadioButton)listeTog.get(i-1).getSelectedToggle();
                		if (rb !=null) {
                			preparedStatement.setString(1,rb.getText());
                			preparedStatement.executeUpdate();
                		}
                		sql3 = "UPDATE Repondre SET Repondre.ReponseE = ? WHERE Repondre.idUtilisateur = ? AND Repondre.NumPart = ? AND Repondre.NumQuestion = ? ";
                		
                	}
                	sql4 = "SELECT * FROM Repondre WHERE Repondre.idUtilisateur = ? AND Repondre.NumPart = ? AND Repondre.NumQuestion = ?";
            	}
            }
            Node node = (Node)event.getSource();
        	dialogStage = (Stage) node.getScene().getWindow();
        	dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Etudiant/Toeic/FXMLQuestionnaire2.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	try {
    		
    		listeTog.add(q1);
        	listeTog.add(q2);
        	listeTog.add(q3);
        	listeTog.add(q4);
        	listeTog.add(q5);
        	listeTog.add(q6);
    		String sql = "SELECT idUtilisateur FROM Utilisateur WHERE Utilisateur.MailUtilisateur = ? AND Utilisateur.MdpUtilisateur = ?";
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setString(1, FXMLDocumentController.mail());
    		preparedStatement.setString(2, FXMLDocumentController.mdp());
    		resultSet = preparedStatement.executeQuery();
    		if(resultSet.next()) {
    			String sql4 = "SELECT * FROM Repondre WHERE Repondre.idUtilisateur = ? AND Repondre.NumPart = ? AND Repondre.NumQuestion = ?";
    			for(int i = 1; i <= 6; i++) {
            		preparedStatement = connection.prepareStatement(sql4);
                	preparedStatement.setInt(1,resultSet.getInt(1));
                	preparedStatement.setInt(2,1);
                	preparedStatement.setInt(3,i);
                	resultSet2 = preparedStatement.executeQuery();
                	if(resultSet2.next()) { //problème en dessous, rentre pas dans les if
                		if(resultSet2.getString(4).equals("A")) {
                			if(i==1) {A1.setSelected(true);}
                			else if(i==2) {A2.setSelected(true);}
                			else if(i==3) {A3.setSelected(true);}
                			else if(i==4) {A4.setSelected(true);}
                			else if(i==5) {A5.setSelected(true);}
                			else if(i==6) {A6.setSelected(true);}
                			
                		}
                		else if(resultSet2.getString(4).equals("B")) {
                			if(i==1) {B1.setSelected(true);}
                			else if(i==2) {B2.setSelected(true);}
                			else if(i==3) {B3.setSelected(true);}
                			else if(i==4) {B4.setSelected(true);}
                			else if(i==5) {B5.setSelected(true);}
                			else if(i==6) {B6.setSelected(true);}
                			
                		}
                		else if(resultSet2.getString(4).equals("C")) {
                			if(i==1) {C1.setSelected(true);}
                			else if(i==2) {C2.setSelected(true);}
                			else if(i==3) {C3.setSelected(true);}
                			else if(i==4) {C4.setSelected(true);}
                			else if(i==5) {C5.setSelected(true);}
                			else if(i==6) {C6.setSelected(true);}
                			
                		}
                		else if(resultSet2.getString(4).equals("D")) {
                			if(i==1) {D1.setSelected(true);}
                			else if(i==2) {D2.setSelected(true);}
                			else if(i==3) {D3.setSelected(true);}
                			else if(i==4) {D4.setSelected(true);}
                			else if(i==5) {D5.setSelected(true);}
                			else if(i==6) {D6.setSelected(true);}
                			
                		}
                	}
                	sql4 = "SELECT * FROM Repondre WHERE Repondre.idUtilisateur = ? AND Repondre.NumPart = ? AND Repondre.NumQuestion = ?";
    			}
    		}
    	}
    	catch(Exception e){
            e.printStackTrace();
        }
		
	}

}
