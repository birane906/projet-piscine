package enJava.fichiers.Controller.Etudiant.Toeic;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

/*
 * IMPORTANT NB Questions Partie 4 = NB Questions Partie 5
 * donc on reprend la même structure que dans la p4 A71 correspond à A101 par exemple et q100 à q130
 */

public class QuestionnaireController5 implements Initializable {

	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    ResultSet resultSet2= null;
    //correspond aux questions 101..130
    @FXML
    private ToggleGroup q71,q72,q73,q74,q75,q76,q77,q78,q79,q80,q81,q82,q83,q84,q85,q86,q87,q88,q89,q90,q91;
    @FXML
    private ToggleGroup q92,q93,q94,q95,q96,q97,q98,q99,q100;
    
    private ArrayList<ToggleGroup> listeTog1 = new ArrayList<ToggleGroup>();
    
    @FXML
    RadioButton A71,A72,A73,A74,A75,A76,A77,A78,A79,A80,A81,A82,A83,A84,A85,A86,A87,A88,A89,A90,A91,A92,A93,A94,A95,A96,A97,A98,A99,A100;
    @FXML
    RadioButton B71,B72,B73,B74,B75,B76,B77,B78,B79,B80,B81,B82,B83,B84,B85,B86,B87,B88,B89,B90,B91,B92,B93,B94,B95,B96,B97,B98,B99,B100;
    @FXML
    RadioButton C71,C72,C73,C74,C75,C76,C77,C78,C79,C80,C81,C82,C83,C84,C85,C86,C87,C88,C89,C90,C91,C92,C93,C94,C95,C96,C97,C98,C99,C100;
    @FXML
    RadioButton D71,D72,D73,D74,D75,D76,D77,D78,D79,D80,D81,D82,D83,D84,D85,D86,D87,D88,D89,D90,D91,D92,D93,D94,D95,D96,D97,D98,D99,D100;

    
    public QuestionnaireController5() {
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
            	
            	for(int i =71 ; i <= 100; i++) {
            		preparedStatement = connection.prepareStatement(sql4);
                	preparedStatement.setInt(1,resultSet.getInt(1));
                	preparedStatement.setInt(2,5);
                	preparedStatement.setInt(3,i+30);
                	resultSet2 = preparedStatement.executeQuery();
                	if(!resultSet2.next()) {
                	
                		preparedStatement = connection.prepareStatement(sql2);
                		preparedStatement.setInt(1, 5);
                		preparedStatement.setInt(2, i+30);
                		preparedStatement.setInt(3,resultSet.getInt(1));
                		RadioButton rb = (RadioButton)listeTog1.get(i-71).getSelectedToggle();
                		if (rb !=null) {
                			preparedStatement.setString(4,rb.getText());
                			preparedStatement.executeUpdate();
                		}
                		sql2 = "INSERT INTO Repondre (NumPart,NumQuestion,idUtilisateur,ReponseE) VALUES (?, ?, ?, ?)";
                	}
                	else {
                		preparedStatement = connection.prepareStatement(sql3);
                		preparedStatement.setInt(2,resultSet.getInt(1));
                		preparedStatement.setInt(3,5);
                		preparedStatement.setInt(4,i+30);
                		RadioButton rb = (RadioButton)listeTog1.get(i-71).getSelectedToggle();
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
        	dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Etudiant/Toeic/FXMLQuestionnaire6.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	
	
	
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	try {
    		
    		listeTog1.add(q71);
    		listeTog1.add(q72);
        	listeTog1.add(q73);
        	listeTog1.add(q74);
        	listeTog1.add(q75);
        	listeTog1.add(q76);
        	listeTog1.add(q77);
        	listeTog1.add(q78);
        	listeTog1.add(q79);
        	listeTog1.add(q80);
        	listeTog1.add(q81);
        	listeTog1.add(q82);
        	listeTog1.add(q83);
        	listeTog1.add(q84);
        	listeTog1.add(q85);
        	listeTog1.add(q86);
        	listeTog1.add(q87);
        	listeTog1.add(q88);
        	listeTog1.add(q89);
        	listeTog1.add(q90);
        	listeTog1.add(q91);
        	listeTog1.add(q92);
        	listeTog1.add(q93);
        	listeTog1.add(q94);
        	listeTog1.add(q95);
        	listeTog1.add(q96);
        	listeTog1.add(q97);
        	listeTog1.add(q98);
        	listeTog1.add(q99);
        	listeTog1.add(q100);
    		String sql = "SELECT idUtilisateur FROM Utilisateur WHERE Utilisateur.MailUtilisateur = ? AND Utilisateur.MdpUtilisateur = ?";
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setString(1, FXMLDocumentController.mail());
    		preparedStatement.setString(2, FXMLDocumentController.mdp());
    		resultSet = preparedStatement.executeQuery();
    		if(resultSet.next()) {
    			String sql4 = "SELECT * FROM Repondre WHERE Repondre.idUtilisateur = ? AND Repondre.NumPart = ? AND Repondre.NumQuestion = ?";
    			for(int i = 71; i <= 100; i++) {
            		preparedStatement = connection.prepareStatement(sql4);
                	preparedStatement.setInt(1,resultSet.getInt(1));
                	preparedStatement.setInt(2,5);
                	preparedStatement.setInt(3,i+30);
                	resultSet2 = preparedStatement.executeQuery();
                	if(resultSet2.next()) { //problème en dessous, rentre pas dans les if
                		if(resultSet2.getString(4).equals("A")) {
                			if(i==71) {A71.setSelected(true);}
                			else if(i==72) {A72.setSelected(true);}
                			else if(i==73) {A73.setSelected(true);}
                			else if(i==74) {A74.setSelected(true);}
                			else if(i==75) {A75.setSelected(true);}
                			else if(i==76) {A76.setSelected(true);}
                			else if(i==77) {A77.setSelected(true);}
                			else if(i==78) {A78.setSelected(true);}
                			else if(i==79) {A79.setSelected(true);}
                			else if(i==80) {A80.setSelected(true);}
                			else if(i==81) {A81.setSelected(true);}
                			else if(i==82) {A82.setSelected(true);}
                			else if(i==83) {A83.setSelected(true);}
                			else if(i==84) {A84.setSelected(true);}
                			else if(i==85) {A85.setSelected(true);}
                			else if(i==86) {A86.setSelected(true);}
                			else if(i==87) {A87.setSelected(true);}
                			else if(i==88) {A88.setSelected(true);}
                			else if(i==89) {A89.setSelected(true);}
                			else if(i==90) {A90.setSelected(true);}
                			else if(i==91) {A91.setSelected(true);}
                			else if(i==92) {A92.setSelected(true);}
                			else if(i==93) {A93.setSelected(true);}
                			else if(i==94) {A94.setSelected(true);}
                			else if(i==95) {A95.setSelected(true);}
                			else if(i==96) {A96.setSelected(true);}
                			else if(i==97) {A97.setSelected(true);}
                			else if(i==98) {A98.setSelected(true);}
                			else if(i==99) {A99.setSelected(true);}
                			else if(i==100) {A100.setSelected(true);}
                			
                		}
                		else if(resultSet2.getString(4).equals("B")) {
                			if(i==71) {B71.setSelected(true);}
                			else if(i==72) {B72.setSelected(true);}
                			else if(i==73) {B73.setSelected(true);}
                			else if(i==74) {B74.setSelected(true);}
                			else if(i==75) {B75.setSelected(true);}
                			else if(i==76) {B76.setSelected(true);}
                			else if(i==77) {B77.setSelected(true);}
                			else if(i==78) {B78.setSelected(true);}
                			else if(i==79) {B79.setSelected(true);}
                			else if(i==80) {B80.setSelected(true);}
                			else if(i==81) {B81.setSelected(true);}
                			else if(i==82) {B82.setSelected(true);}
                			else if(i==83) {B83.setSelected(true);}
                			else if(i==84) {B84.setSelected(true);}
                			else if(i==85) {B85.setSelected(true);}
                			else if(i==86) {B86.setSelected(true);}
                			else if(i==87) {B87.setSelected(true);}
                			else if(i==88) {B88.setSelected(true);}
                			else if(i==89) {B89.setSelected(true);}
                			else if(i==90) {B90.setSelected(true);}
                			else if(i==91) {B91.setSelected(true);}
                			else if(i==92) {B92.setSelected(true);}
                			else if(i==93) {B93.setSelected(true);}
                			else if(i==94) {B94.setSelected(true);}
                			else if(i==95) {B95.setSelected(true);}
                			else if(i==96) {B96.setSelected(true);}
                			else if(i==97) {B97.setSelected(true);}
                			else if(i==98) {B98.setSelected(true);}
                			else if(i==99) {B99.setSelected(true);}
                			else if(i==100) {B100.setSelected(true);}
                			
                		}
                		else if(resultSet2.getString(4).equals("C")) {
                			if(i==71) {C71.setSelected(true);}
                			else if(i==72) {C72.setSelected(true);}
                			else if(i==73) {C73.setSelected(true);}
                			else if(i==74) {C74.setSelected(true);}
                			else if(i==75) {C75.setSelected(true);}
                			else if(i==76) {C76.setSelected(true);}
                			else if(i==77) {C77.setSelected(true);}
                			else if(i==78) {C78.setSelected(true);}
                			else if(i==79) {C79.setSelected(true);}
                			else if(i==80) {C80.setSelected(true);}
                			else if(i==81) {C81.setSelected(true);}
                			else if(i==82) {C82.setSelected(true);}
                			else if(i==83) {C83.setSelected(true);}
                			else if(i==84) {C84.setSelected(true);}
                			else if(i==85) {C85.setSelected(true);}
                			else if(i==86) {C86.setSelected(true);}
                			else if(i==87) {C87.setSelected(true);}
                			else if(i==88) {C88.setSelected(true);}
                			else if(i==89) {C89.setSelected(true);}
                			else if(i==90) {C90.setSelected(true);}
                			else if(i==91) {C91.setSelected(true);}
                			else if(i==92) {C92.setSelected(true);}
                			else if(i==93) {C93.setSelected(true);}
                			else if(i==94) {C94.setSelected(true);}
                			else if(i==95) {C95.setSelected(true);}
                			else if(i==96) {C96.setSelected(true);}
                			else if(i==97) {C97.setSelected(true);}
                			else if(i==98) {C98.setSelected(true);}
                			else if(i==99) {C99.setSelected(true);}
                			else if(i==100) {C100.setSelected(true);}
                			
                		}
                			
                		else if(resultSet2.getString(4).equals("D")) {
                			if(i==71) {D71.setSelected(true);}
                			else if(i==72) {D72.setSelected(true);}
                			else if(i==73) {D73.setSelected(true);}
                			else if(i==74) {D74.setSelected(true);}
                			else if(i==75) {D75.setSelected(true);}
                			else if(i==76) {D76.setSelected(true);}
                			else if(i==77) {D77.setSelected(true);}
                			else if(i==78) {D78.setSelected(true);}
                			else if(i==79) {D79.setSelected(true);}
                			else if(i==80) {D80.setSelected(true);}
                			else if(i==81) {D81.setSelected(true);}
                			else if(i==82) {D82.setSelected(true);}
                			else if(i==83) {D83.setSelected(true);}
                			else if(i==84) {D84.setSelected(true);}
                			else if(i==85) {D85.setSelected(true);}
                			else if(i==86) {D86.setSelected(true);}
                			else if(i==87) {D87.setSelected(true);}
                			else if(i==88) {D88.setSelected(true);}
                			else if(i==89) {D89.setSelected(true);}
                			else if(i==90) {D90.setSelected(true);}
                			else if(i==91) {D91.setSelected(true);}
                			else if(i==92) {D92.setSelected(true);}
                			else if(i==93) {D93.setSelected(true);}
                			else if(i==94) {D94.setSelected(true);}
                			else if(i==95) {D95.setSelected(true);}
                			else if(i==96) {D96.setSelected(true);}
                			else if(i==97) {D97.setSelected(true);}
                			else if(i==98) {D98.setSelected(true);}
                			else if(i==99) {D99.setSelected(true);}
                			else if(i==100) {D100.setSelected(true);}
                			
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
