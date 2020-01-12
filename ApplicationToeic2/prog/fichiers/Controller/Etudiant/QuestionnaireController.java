package prog.fichiers.Controller.Etudiant;

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
import prog.fichiers.Config.ConnectionUtil;
import prog.fichiers.Controller.Login.FXMLDocumentController;

public class QuestionnaireController implements Initializable{

	

	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    //ResultSet resultSet2= null;
    
    @FXML
    private ToggleGroup q1,q2,q3,q4,q5,q6;
    private ArrayList<ToggleGroup> listeTog = new ArrayList<ToggleGroup>();
	
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
            	listeTog.add(q1);
            	listeTog.add(q2);
            	listeTog.add(q3);
            	listeTog.add(q4);
            	listeTog.add(q5);
            	listeTog.add(q6);
            	
            	String sql2 = "INSERT INTO Repondre (NumPart,NumQuestion,idUtilisateur,ReponseE) VALUES (?, ?, ?, ?)";
            	for(int i = 1; i <= 6; i++) {
            		preparedStatement = connection.prepareStatement(sql2);
            		preparedStatement.setInt(1, 1);
                    preparedStatement.setInt(2, i);
                    preparedStatement.setInt(3,resultSet.getInt(1));
                    RadioButton rb = (RadioButton)listeTog.get(i-1).getSelectedToggle();
                    preparedStatement.setString(4,rb.getText().toLowerCase());
                    preparedStatement.executeUpdate();
                    sql2 = "INSERT INTO Repondre (NumPart,NumQuestion,idUtilisateur,ReponseE) VALUES (?, ?, ?, ?)";
            		
            	}
            }
            Node node = (Node)event.getSource();
        	dialogStage = (Stage) node.getScene().getWindow();
        	dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Etudiant/Toeic/FXMLQuestionnaire2.fxml")));
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
