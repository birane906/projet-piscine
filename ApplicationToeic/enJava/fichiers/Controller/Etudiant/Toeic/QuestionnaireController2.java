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

public class QuestionnaireController2 implements Initializable {

	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    ResultSet resultSet2= null;
    
    @FXML
    private ToggleGroup q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18,q19,q20,q21,q22,q23,q24,q25,q26,q27,q28,q29,q30,q31;
    private ArrayList<ToggleGroup> listeTog1 = new ArrayList<ToggleGroup>();
    
    @FXML
    RadioButton A7,A8,A9,A10,A11,A12,A13,A14,A15,A16,A17,A18,A19,A20,A21,A22,A23,A24,A25,A26,A27,A28,A29,A30,A31;
    @FXML
    RadioButton B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20,B21,B22,B23,B24,B25,B26,B27,B28,B29,B30,B31;
    @FXML
    RadioButton C7,C8,C9,C10,C11,C12,C13,C14,C15,C16,C17,C18,C19,C20,C21,C22,C23,C24,C25,C26,C27,C28,C29,C30,C31;
    @FXML
    RadioButton D7,D8,D9,D10,D11,D12,D13,D14,D15,D16,D17,D18,D19,D20,D21,D22,D23,D24,D25,D26,D27,D28,D29,D30,D31;
    
	
	public QuestionnaireController2() {
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
            	
            	for(int i =7 ; i <= 31; i++) {
            		preparedStatement = connection.prepareStatement(sql4);
                	preparedStatement.setInt(1,resultSet.getInt(1));
                	preparedStatement.setInt(2,2);
                	preparedStatement.setInt(3,i);
                	resultSet2 = preparedStatement.executeQuery();
                	if(!resultSet2.next()) {
                	
                		preparedStatement = connection.prepareStatement(sql2);
                		preparedStatement.setInt(1, 2);
                		preparedStatement.setInt(2, i);
                		preparedStatement.setInt(3,resultSet.getInt(1));
                		RadioButton rb = (RadioButton)listeTog1.get(i-7).getSelectedToggle();
                		if (rb !=null) {
                			preparedStatement.setString(4,rb.getText());
                			preparedStatement.executeUpdate();
                		}
                		sql2 = "INSERT INTO Repondre (NumPart,NumQuestion,idUtilisateur,ReponseE) VALUES (?, ?, ?, ?)";
                	}
                	else {
                		preparedStatement = connection.prepareStatement(sql3);
                		preparedStatement.setInt(2,resultSet.getInt(1));
                		preparedStatement.setInt(3,2);
                		preparedStatement.setInt(4,i);
                		RadioButton rb = (RadioButton)listeTog1.get(i-7).getSelectedToggle();
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
        	dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Etudiant/Toeic/FXMLQuestionnaire.fxml")));
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
            	
            	for(int i =7 ; i <= 31; i++) {
            		preparedStatement = connection.prepareStatement(sql4);
                	preparedStatement.setInt(1,resultSet.getInt(1));
                	preparedStatement.setInt(2,2);
                	preparedStatement.setInt(3,i);
                	resultSet2 = preparedStatement.executeQuery();
                	if(!resultSet2.next()) {
                	
                		preparedStatement = connection.prepareStatement(sql2);
                		preparedStatement.setInt(1, 2);
                		preparedStatement.setInt(2, i);
                		preparedStatement.setInt(3,resultSet.getInt(1));
                		RadioButton rb = (RadioButton)listeTog1.get(i-7).getSelectedToggle();
                		if (rb !=null) {
                			preparedStatement.setString(4,rb.getText());
                			preparedStatement.executeUpdate();
                		}
                		sql2 = "INSERT INTO Repondre (NumPart,NumQuestion,idUtilisateur,ReponseE) VALUES (?, ?, ?, ?)";
                	}
                	else {
                		preparedStatement = connection.prepareStatement(sql3);
                		preparedStatement.setInt(2,resultSet.getInt(1));
                		preparedStatement.setInt(3,2);
                		preparedStatement.setInt(4,i);
                		RadioButton rb = (RadioButton)listeTog1.get(i-7).getSelectedToggle();
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
        	dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Etudiant/Toeic/FXMLQuestionnaire3.fxml")));
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	try {
    		
    		listeTog1.add(q7);
        	listeTog1.add(q8);
        	listeTog1.add(q9);
        	listeTog1.add(q10);
        	listeTog1.add(q11);
        	listeTog1.add(q12);
        	listeTog1.add(q13);
        	listeTog1.add(q14);
        	listeTog1.add(q15);
        	listeTog1.add(q16);
        	listeTog1.add(q17);
        	listeTog1.add(q18);
        	listeTog1.add(q19);
        	listeTog1.add(q20);
        	listeTog1.add(q21);
        	listeTog1.add(q22);
        	listeTog1.add(q23);
        	listeTog1.add(q24);
        	listeTog1.add(q25);
        	listeTog1.add(q26);
        	listeTog1.add(q27);
        	listeTog1.add(q28);
        	listeTog1.add(q29);
        	listeTog1.add(q30);
        	listeTog1.add(q31);
    		String sql = "SELECT idUtilisateur FROM Utilisateur WHERE Utilisateur.MailUtilisateur = ? AND Utilisateur.MdpUtilisateur = ?";
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setString(1, FXMLDocumentController.mail());
    		preparedStatement.setString(2, FXMLDocumentController.mdp());
    		resultSet = preparedStatement.executeQuery();
    		if(resultSet.next()) {
    			String sql4 = "SELECT * FROM Repondre WHERE Repondre.idUtilisateur = ? AND Repondre.NumPart = ? AND Repondre.NumQuestion = ?";
    			for(int i = 7; i <= 31; i++) {
            		preparedStatement = connection.prepareStatement(sql4);
                	preparedStatement.setInt(1,resultSet.getInt(1));
                	preparedStatement.setInt(2,2);
                	preparedStatement.setInt(3,i);
                	resultSet2 = preparedStatement.executeQuery();
                	if(resultSet2.next()) { //problème en dessous, rentre pas dans les if
                		if(resultSet2.getString(4).equals("A")) {
                			if(i==7) {A7.setSelected(true);}
                			else if(i==8) {A8.setSelected(true);}
                			else if(i==9) {A9.setSelected(true);}
                			else if(i==10) {A10.setSelected(true);}
                			else if(i==11) {A11.setSelected(true);}
                			else if(i==12) {A12.setSelected(true);}
                			else if(i==13) {A13.setSelected(true);}
                			else if(i==14) {A14.setSelected(true);}
                			else if(i==15) {A15.setSelected(true);}
                			else if(i==16) {A16.setSelected(true);}
                			else if(i==17) {A17.setSelected(true);}
                			else if(i==18) {A18.setSelected(true);}
                			else if(i==19) {A19.setSelected(true);}
                			else if(i==20) {A20.setSelected(true);}
                			else if(i==21) {A21.setSelected(true);}
                			else if(i==22) {A22.setSelected(true);}
                			else if(i==23) {A23.setSelected(true);}
                			else if(i==24) {A24.setSelected(true);}
                			else if(i==25) {A25.setSelected(true);}
                			else if(i==26) {A26.setSelected(true);}
                			else if(i==27) {A27.setSelected(true);}
                			else if(i==28) {A28.setSelected(true);}
                			else if(i==29) {A29.setSelected(true);}
                			else if(i==30) {A30.setSelected(true);}
                			else if(i==31) {A31.setSelected(true);}
                			
                		}
                		else if(resultSet2.getString(4).equals("B")) {
                			if(i==7) {B7.setSelected(true);}
                			else if(i==8) {B8.setSelected(true);}
                			else if(i==9) {B9.setSelected(true);}
                			else if(i==10) {B10.setSelected(true);}
                			else if(i==11) {B11.setSelected(true);}
                			else if(i==12) {B12.setSelected(true);}
                			else if(i==13) {B13.setSelected(true);}
                			else if(i==14) {B14.setSelected(true);}
                			else if(i==15) {B15.setSelected(true);}
                			else if(i==16) {B16.setSelected(true);}
                			else if(i==17) {B17.setSelected(true);}
                			else if(i==18) {B18.setSelected(true);}
                			else if(i==19) {B19.setSelected(true);}
                			else if(i==20) {B20.setSelected(true);}
                			else if(i==21) {B21.setSelected(true);}
                			else if(i==22) {B22.setSelected(true);}
                			else if(i==23) {B23.setSelected(true);}
                			else if(i==24) {B24.setSelected(true);}
                			else if(i==25) {B25.setSelected(true);}
                			else if(i==26) {B26.setSelected(true);}
                			else if(i==27) {B27.setSelected(true);}
                			else if(i==28) {B28.setSelected(true);}
                			else if(i==29) {B29.setSelected(true);}
                			else if(i==30) {B30.setSelected(true);}
                			else if(i==31) {B31.setSelected(true);}
                			
                		}
                		else if(resultSet2.getString(4).equals("C")) {
                			if(i==7) {C7.setSelected(true);}
                			else if(i==8) {C8.setSelected(true);}
                			else if(i==9) {C9.setSelected(true);}
                			else if(i==10) {C10.setSelected(true);}
                			else if(i==11) {C11.setSelected(true);}
                			else if(i==12) {C12.setSelected(true);}
                			else if(i==13) {C13.setSelected(true);}
                			else if(i==14) {C14.setSelected(true);}
                			else if(i==15) {C15.setSelected(true);}
                			else if(i==16) {C16.setSelected(true);}
                			else if(i==17) {C17.setSelected(true);}
                			else if(i==18) {C18.setSelected(true);}
                			else if(i==19) {C19.setSelected(true);}
                			else if(i==20) {C20.setSelected(true);}
                			else if(i==21) {C21.setSelected(true);}
                			else if(i==22) {C22.setSelected(true);}
                			else if(i==23) {C23.setSelected(true);}
                			else if(i==24) {C24.setSelected(true);}
                			else if(i==25) {C25.setSelected(true);}
                			else if(i==26) {C26.setSelected(true);}
                			else if(i==27) {C27.setSelected(true);}
                			else if(i==28) {C28.setSelected(true);}
                			else if(i==29) {C29.setSelected(true);}
                			else if(i==30) {C30.setSelected(true);}
                			else if(i==31) {C31.setSelected(true);}
                			
                		}
                		else if(resultSet2.getString(4).equals("D")) {
                			if(i==7) {D7.setSelected(true);}
                			else if(i==8) {D8.setSelected(true);}
                			else if(i==9) {D9.setSelected(true);}
                			else if(i==10) {D10.setSelected(true);}
                			else if(i==11) {D11.setSelected(true);}
                			else if(i==12) {D12.setSelected(true);}
                			else if(i==13) {D13.setSelected(true);}
                			else if(i==14) {D14.setSelected(true);}
                			else if(i==15) {D15.setSelected(true);}
                			else if(i==16) {D16.setSelected(true);}
                			else if(i==17) {D17.setSelected(true);}
                			else if(i==18) {D18.setSelected(true);}
                			else if(i==19) {D19.setSelected(true);}
                			else if(i==20) {D20.setSelected(true);}
                			else if(i==21) {D21.setSelected(true);}
                			else if(i==22) {D22.setSelected(true);}
                			else if(i==23) {D23.setSelected(true);}
                			else if(i==24) {D24.setSelected(true);}
                			else if(i==25) {D25.setSelected(true);}
                			else if(i==26) {D26.setSelected(true);}
                			else if(i==27) {D27.setSelected(true);}
                			else if(i==28) {D28.setSelected(true);}
                			else if(i==29) {D29.setSelected(true);}
                			else if(i==30) {D30.setSelected(true);}
                			else if(i==31) {D31.setSelected(true);}
                			
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
