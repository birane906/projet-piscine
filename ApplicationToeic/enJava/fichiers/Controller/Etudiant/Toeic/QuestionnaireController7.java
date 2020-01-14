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

public class QuestionnaireController7 implements Initializable{
	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    ResultSet resultSet2= null;
    
    @FXML
    private ToggleGroup q32,q33,q34,q35,q36,q37,q38,q39,q40,q41,q42,q43,q44,q45,q46,q47,q48,q49,q50,q51;
    @FXML
    private ToggleGroup q52,q53,q54,q55,q56,q57,q58,q59,q60,q61,q62,q63,q64,q65,q66,q67,q68,q69,q70,q71,q72,q73,q74,q75,q76,q77,q78,q79,q80,q81,q82,q83,q84,q85;
    
    private ArrayList<ToggleGroup> listeTog1 = new ArrayList<ToggleGroup>();
    
    @FXML
    RadioButton A32,A33,A34,A35,A36,A37,A38,A39,A40,A41,A42,A43,A44,A45,A46,A47,A48,A49,A50,A51,A52,A53,A54,A55,A56,A57,A58,A59,A60,A61,A62,A63,A64,A65,A66,A67,A68,A69,A70,A71,A72,A73,A74,A75,A76,A77,A78,A79,A80,A81,A82,A83,A84,A85;
    @FXML
    RadioButton B32,B33,B34,B35,B36,B37,B38,B39,B40,B41,B42,B43,B44,B45,B46,B47,B48,B49,B50,B51,B52,B53,B54,B55,B56,B57,B58,B59,B60,B61,B62,B63,B64,B65,B66,B67,B68,B69,B70,B71,B72,B73,B74,B75,B76,B77,B78,B79,B80,B81,B82,B83,B84,B85;
    @FXML
    RadioButton C32,C33,C34,C35,C36,C37,C38,C39,C40,C41,C42,C43,C44,C45,C46,C47,C48,C49,C50,C51,C52,C53,C54,C55,C56,C57,C58,C59,C60,C61,C62,C63,C64,C65,C66,C67,C68,C69,C70,C71,C72,C73,C74,C75,C76,C77,C78,C79,C80,C81,C82,C83,C84,C85;
    @FXML
    RadioButton D32,D33,D34,D35,D36,D37,D38,D39,D40,D41,D42,D43,D44,D45,D46,D47,D48,D49,D50,D51,D52,D53,D54,D55,D56,D57,D58,D59,D60,D61,D62,D63,D64,D65,D66,D67,D68,D69,D70,D71,D72,D73,D74,D75,D76,D77,D78,D79,D80,D81,D82,D83,D84,D85;

    
    public QuestionnaireController7() {
        connection = ConnectionUtil.connectdb();
    }
    
    
    public void back(ActionEvent event) {
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
            	
            	for(int i = 32 ; i <= 85; i++) {
            		preparedStatement = connection.prepareStatement(sql4);
                	preparedStatement.setInt(1,resultSet.getInt(1));
                	preparedStatement.setInt(2,7);
                	preparedStatement.setInt(3,i+115); //147-32
                	resultSet2 = preparedStatement.executeQuery();
                	if(!resultSet2.next()) {
                	
                		preparedStatement = connection.prepareStatement(sql2);
                		preparedStatement.setInt(1, 7);
                		preparedStatement.setInt(2, i+115);
                		preparedStatement.setInt(3,resultSet.getInt(1));
                		RadioButton rb = (RadioButton)listeTog1.get(i-32).getSelectedToggle();
                		if (rb !=null) {
                			preparedStatement.setString(4,rb.getText());
                			preparedStatement.executeUpdate();
                		}
                		sql2 = "INSERT INTO Repondre (NumPart,NumQuestion,idUtilisateur,ReponseE) VALUES (?, ?, ?, ?)";
                	}
                	else {
                		preparedStatement = connection.prepareStatement(sql3);
                		preparedStatement.setInt(2,resultSet.getInt(1));
                		preparedStatement.setInt(3,7);
                		preparedStatement.setInt(4,i+115);
                		RadioButton rb = (RadioButton)listeTog1.get(i-32).getSelectedToggle();
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
            	
            	for(int i =32 ; i <= 85; i++) {
            		preparedStatement = connection.prepareStatement(sql4);
                	preparedStatement.setInt(1,resultSet.getInt(1));
                	preparedStatement.setInt(2,7);
                	preparedStatement.setInt(3,i+115);
                	resultSet2 = preparedStatement.executeQuery();
                	if(!resultSet2.next()) {
                	
                		preparedStatement = connection.prepareStatement(sql2);
                		preparedStatement.setInt(1, 7);
                		preparedStatement.setInt(2, i+115);
                		preparedStatement.setInt(3,resultSet.getInt(1));
                		RadioButton rb = (RadioButton)listeTog1.get(i-32).getSelectedToggle();
                		if (rb !=null) {
                			preparedStatement.setString(4,rb.getText());
                			preparedStatement.executeUpdate();
                		}
                		sql2 = "INSERT INTO Repondre (NumPart,NumQuestion,idUtilisateur,ReponseE) VALUES (?, ?, ?, ?)";
                	}
                	else {
                		preparedStatement = connection.prepareStatement(sql3);
                		preparedStatement.setInt(2,resultSet.getInt(1));
                		preparedStatement.setInt(3,7);
                		preparedStatement.setInt(4,i+115);
                		RadioButton rb = (RadioButton)listeTog1.get(i-32).getSelectedToggle();
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
        	dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Etudiant/Toeic/FinTOEICScreen.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
    
    
    
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	try {
    		
    		listeTog1.add(q32);
        	listeTog1.add(q33);
        	listeTog1.add(q34);
        	listeTog1.add(q35);
        	listeTog1.add(q36);
        	listeTog1.add(q37);
        	listeTog1.add(q38);
        	listeTog1.add(q39);
        	listeTog1.add(q40);
        	listeTog1.add(q41);
        	listeTog1.add(q42);
        	listeTog1.add(q43);
        	listeTog1.add(q44);
        	listeTog1.add(q45);
        	listeTog1.add(q46);
        	listeTog1.add(q47);
        	listeTog1.add(q48);
        	listeTog1.add(q49);
        	listeTog1.add(q50);
        	listeTog1.add(q51);
        	listeTog1.add(q52);
        	listeTog1.add(q53);
        	listeTog1.add(q54);
        	listeTog1.add(q55);
        	listeTog1.add(q56);
        	listeTog1.add(q57);
        	listeTog1.add(q58);
        	listeTog1.add(q59);
        	listeTog1.add(q60);
        	listeTog1.add(q61);
        	listeTog1.add(q62);
        	listeTog1.add(q63);
        	listeTog1.add(q64);
        	listeTog1.add(q65);
        	listeTog1.add(q66);
        	listeTog1.add(q67);
        	listeTog1.add(q68);
        	listeTog1.add(q69);
        	listeTog1.add(q70);
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
    		String sql = "SELECT idUtilisateur FROM Utilisateur WHERE Utilisateur.MailUtilisateur = ? AND Utilisateur.MdpUtilisateur = ?";
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setString(1, FXMLDocumentController.mail());
    		preparedStatement.setString(2, FXMLDocumentController.mdp());
    		resultSet = preparedStatement.executeQuery();
    		if(resultSet.next()) {
    			String sql4 = "SELECT * FROM Repondre WHERE Repondre.idUtilisateur = ? AND Repondre.NumPart = ? AND Repondre.NumQuestion = ?";
    			for(int i = 32; i <= 85; i++) {
            		preparedStatement = connection.prepareStatement(sql4);
                	preparedStatement.setInt(1,resultSet.getInt(1));
                	preparedStatement.setInt(2,7);
                	preparedStatement.setInt(3,i+115);
                	resultSet2 = preparedStatement.executeQuery();
                	if(resultSet2.next()) { //problème en dessous, rentre pas dans les if
                		if(resultSet2.getString(4).equals("A")) {
                			if(i==32) {A32.setSelected(true);}
                			else if(i==33) {A33.setSelected(true);}
                			else if(i==34) {A34.setSelected(true);}
                			else if(i==35) {A35.setSelected(true);}
                			else if(i==36) {A36.setSelected(true);}
                			else if(i==37) {A37.setSelected(true);}
                			else if(i==38) {A38.setSelected(true);}
                			else if(i==39) {A39.setSelected(true);}
                			else if(i==40) {A40.setSelected(true);}
                			else if(i==41) {A41.setSelected(true);}
                			else if(i==42) {A42.setSelected(true);}
                			else if(i==43) {A43.setSelected(true);}
                			else if(i==44) {A44.setSelected(true);}
                			else if(i==45) {A45.setSelected(true);}
                			else if(i==46) {A46.setSelected(true);}
                			else if(i==47) {A47.setSelected(true);}
                			else if(i==48) {A48.setSelected(true);}
                			else if(i==49) {A49.setSelected(true);}
                			else if(i==50) {A50.setSelected(true);}
                			else if(i==51) {A51.setSelected(true);}
                			else if(i==52) {A52.setSelected(true);}
                			else if(i==53) {A53.setSelected(true);}
                			else if(i==54) {A54.setSelected(true);}
                			else if(i==55) {A55.setSelected(true);}
                			else if(i==56) {A56.setSelected(true);}
                			else if(i==57) {A57.setSelected(true);}
                			else if(i==58) {A58.setSelected(true);}
                			else if(i==59) {A59.setSelected(true);}
                			else if(i==60) {A60.setSelected(true);}
                			else if(i==61) {A61.setSelected(true);}
                			else if(i==62) {A62.setSelected(true);}
                			else if(i==63) {A63.setSelected(true);}
                			else if(i==64) {A64.setSelected(true);}
                			else if(i==65) {A65.setSelected(true);}
                			else if(i==66) {A66.setSelected(true);}
                			else if(i==67) {A67.setSelected(true);}
                			else if(i==68) {A68.setSelected(true);}
                			else if(i==69) {A69.setSelected(true);}
                			else if(i==70) {A70.setSelected(true);}
                			else if(i==71) {A71.setSelected(true);}
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
                			
                		}
                		else if(resultSet2.getString(4).equals("B")) {
                			if(i==32) {B32.setSelected(true);}
                			else if(i==33) {B33.setSelected(true);}
                			else if(i==34) {B34.setSelected(true);}
                			else if(i==35) {B35.setSelected(true);}
                			else if(i==36) {B36.setSelected(true);}
                			else if(i==37) {B37.setSelected(true);}
                			else if(i==38) {B38.setSelected(true);}
                			else if(i==39) {B39.setSelected(true);}
                			else if(i==40) {B40.setSelected(true);}
                			else if(i==41) {B41.setSelected(true);}
                			else if(i==42) {B42.setSelected(true);}
                			else if(i==43) {B43.setSelected(true);}
                			else if(i==44) {B44.setSelected(true);}
                			else if(i==45) {B45.setSelected(true);}
                			else if(i==46) {B46.setSelected(true);}
                			else if(i==47) {B47.setSelected(true);}
                			else if(i==48) {B48.setSelected(true);}
                			else if(i==49) {B49.setSelected(true);}
                			else if(i==50) {B50.setSelected(true);}
                			else if(i==51) {B51.setSelected(true);}
                			else if(i==52) {B52.setSelected(true);}
                			else if(i==53) {B53.setSelected(true);}
                			else if(i==54) {B54.setSelected(true);}
                			else if(i==55) {B55.setSelected(true);}
                			else if(i==56) {B56.setSelected(true);}
                			else if(i==57) {B57.setSelected(true);}
                			else if(i==58) {B58.setSelected(true);}
                			else if(i==59) {B59.setSelected(true);}
                			else if(i==60) {B60.setSelected(true);}
                			else if(i==61) {B61.setSelected(true);}
                			else if(i==62) {B62.setSelected(true);}
                			else if(i==63) {B63.setSelected(true);}
                			else if(i==64) {B64.setSelected(true);}
                			else if(i==65) {B65.setSelected(true);}
                			else if(i==66) {B66.setSelected(true);}
                			else if(i==67) {B67.setSelected(true);}
                			else if(i==68) {B68.setSelected(true);}
                			else if(i==69) {B69.setSelected(true);}
                			else if(i==70) {B70.setSelected(true);}
                			else if(i==71) {B71.setSelected(true);}
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
                			
                		}
                		else if(resultSet2.getString(4).equals("C")) {
                			if(i==32) {C32.setSelected(true);}
                			else if(i==33) {C33.setSelected(true);}
                			else if(i==34) {C34.setSelected(true);}
                			else if(i==35) {C35.setSelected(true);}
                			else if(i==36) {C36.setSelected(true);}
                			else if(i==37) {C37.setSelected(true);}
                			else if(i==38) {C38.setSelected(true);}
                			else if(i==39) {C39.setSelected(true);}
                			else if(i==40) {C40.setSelected(true);}
                			else if(i==41) {C41.setSelected(true);}
                			else if(i==42) {C42.setSelected(true);}
                			else if(i==43) {C43.setSelected(true);}
                			else if(i==44) {C44.setSelected(true);}
                			else if(i==45) {C45.setSelected(true);}
                			else if(i==46) {C46.setSelected(true);}
                			else if(i==47) {C47.setSelected(true);}
                			else if(i==48) {C48.setSelected(true);}
                			else if(i==49) {C49.setSelected(true);}
                			else if(i==50) {C50.setSelected(true);}
                			else if(i==51) {C51.setSelected(true);}
                			else if(i==52) {C52.setSelected(true);}
                			else if(i==53) {C53.setSelected(true);}
                			else if(i==54) {C54.setSelected(true);}
                			else if(i==55) {C55.setSelected(true);}
                			else if(i==56) {C56.setSelected(true);}
                			else if(i==57) {C57.setSelected(true);}
                			else if(i==58) {C58.setSelected(true);}
                			else if(i==59) {C59.setSelected(true);}
                			else if(i==60) {C60.setSelected(true);}
                			else if(i==61) {C61.setSelected(true);}
                			else if(i==62) {C62.setSelected(true);}
                			else if(i==63) {C63.setSelected(true);}
                			else if(i==64) {C64.setSelected(true);}
                			else if(i==65) {C65.setSelected(true);}
                			else if(i==66) {C66.setSelected(true);}
                			else if(i==67) {C67.setSelected(true);}
                			else if(i==68) {C68.setSelected(true);}
                			else if(i==69) {C69.setSelected(true);}
                			else if(i==70) {C70.setSelected(true);}
                			else if(i==71) {C71.setSelected(true);}
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
                			
                		}
                			
                		else if(resultSet2.getString(4).equals("D")) {
                			if(i==32) {D32.setSelected(true);}
                			else if(i==33) {D33.setSelected(true);}
                			else if(i==34) {D34.setSelected(true);}
                			else if(i==35) {D35.setSelected(true);}
                			else if(i==36) {D36.setSelected(true);}
                			else if(i==37) {D37.setSelected(true);}
                			else if(i==38) {D38.setSelected(true);}
                			else if(i==39) {D39.setSelected(true);}
                			else if(i==40) {D40.setSelected(true);}
                			else if(i==41) {D41.setSelected(true);}
                			else if(i==42) {D42.setSelected(true);}
                			else if(i==43) {D43.setSelected(true);}
                			else if(i==44) {D44.setSelected(true);}
                			else if(i==45) {D45.setSelected(true);}
                			else if(i==46) {D46.setSelected(true);}
                			else if(i==47) {D47.setSelected(true);}
                			else if(i==48) {D48.setSelected(true);}
                			else if(i==49) {D49.setSelected(true);}
                			else if(i==50) {D50.setSelected(true);}
                			else if(i==51) {D51.setSelected(true);}
                			else if(i==52) {D52.setSelected(true);}
                			else if(i==53) {D53.setSelected(true);}
                			else if(i==54) {D54.setSelected(true);}
                			else if(i==55) {D55.setSelected(true);}
                			else if(i==56) {D56.setSelected(true);}
                			else if(i==57) {D57.setSelected(true);}
                			else if(i==58) {D58.setSelected(true);}
                			else if(i==59) {D59.setSelected(true);}
                			else if(i==60) {D60.setSelected(true);}
                			else if(i==61) {D61.setSelected(true);}
                			else if(i==62) {D62.setSelected(true);}
                			else if(i==63) {D63.setSelected(true);}
                			else if(i==64) {D64.setSelected(true);}
                			else if(i==65) {D65.setSelected(true);}
                			else if(i==66) {D66.setSelected(true);}
                			else if(i==67) {D67.setSelected(true);}
                			else if(i==68) {D68.setSelected(true);}
                			else if(i==69) {D69.setSelected(true);}
                			else if(i==70) {D70.setSelected(true);}
                			else if(i==71) {D71.setSelected(true);}
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
