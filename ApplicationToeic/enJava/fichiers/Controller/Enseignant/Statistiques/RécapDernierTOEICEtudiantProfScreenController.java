package enJava.fichiers.Controller.Enseignant.Statistiques;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import enJava.fichiers.Config.ConnectionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RécapDernierTOEICEtudiantProfScreenController implements Initializable {

	// Le score total sur 200
	@FXML
	Text ScoreTotal;
	// Le score sur total 990
	@FXML
	Text Score;	
	
	// Le score sur 100 de l'oral
	@FXML
	Text ScoreOral;
	// Le score sur 495 de l'oral
	@FXML
	Text ScoreOr;
	
	// Le score sur 100 de l'écrit
	@FXML
	Text ScoreEcrit;
	// Le score sur 495 de l'écrit
	@FXML
	Text ScoreEcr;
	
	// Le score de la P1
	@FXML
	Text P1;
	// Le score de la P1
	@FXML
	Text P2;
	// Le score de la P1
	@FXML
	Text P3;
	// Le score de la P1
	@FXML
	Text P4;
	// Le score de la P1
	@FXML
	Text P5;
	// Le score de la P1
	@FXML
	Text P6;
	// Le score de la P1
	@FXML
	Text P7;
	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public RécapDernierTOEICEtudiantProfScreenController() {
        connection = ConnectionUtil.connectdb();
    }
	
	// Bouton Home
		public void Home(ActionEvent event) {
			try {
				Node node = (Node)event.getSource();
	            dialogStage = (Stage) node.getScene().getWindow();
	            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/AccueilProfScreen.fxml")));
			}
			catch(Exception e){
	            e.printStackTrace();
	        }
		}
		
		public static void infoBox(String infoMessage, String headerText, String title){
	        Alert alert = new Alert(AlertType.CONFIRMATION);
	        alert.setContentText(infoMessage);
	        alert.setTitle(title);
	        alert.setHeaderText(headerText);
	        alert.showAndWait();
	    }
	
		public int noteE(int no) {
			
			int result = 5;
			if (no > 15 && no < 25) {
				result = 5*(no-14);
			}
			if(no > 24 && no < 28) {
				result = 5*(no-13);
			}
			if(no > 27 && no < 33) {
				result = 5*(no-12);
			}
			if(no > 32 && no < 38 ){
				result = 5*(no-11);
			}
			if(no > 37 && no<41) {
				result = 5*(no-10);
			}
			if(no > 40 && no<46) {
				result = 5*(no-9);
			}
			if(no > 45 && no<49) {
				result = 5*(no-8);
			}
			if(no > 48 && no<56) {
				result = 5*(no-7);
			}
			if(no > 55 && no<61) {
				result = 5*(no-6);
			}
			if(no > 60 && no<64) {
				result = 5*(no-5);
			}
			if(no > 63 && no<67) {
				result = 5*(no-4);
			}
			if(no > 66 && no<72) {
				result = 5*(no-3);
			}
			if(no > 71 && no<77) {
				result = 5*(no-2);
			}
			if(no > 76 && no<89) {
				result = 5*(no-1);
			}
			if(no > 88 && no<92) {
				result = 5*(no);
			}
			if(no > 91 && no<97) {
				result = 5*(no+1);
			}
			if(no > 96) {
				result = 495;
			}
			return result;
		}

		public static int noteO(int no) {
			
			int result = 5;
			if (no > 6 && no < 26) {
				result = 5*(no-5);
			}
			if(no > 25 && no < 35) {
				result = 5*(no-4);
			}
			if(no > 34 && no < 44) {
				result = 5*(no-3);
			}
			if(no > 43 && no < 47 ){
				result = 5*(no-2);
			}
			if(no > 46 && no<48) {
				result = 5*(no-1);
			}
			if(no > 47 && no<53) {
				result = 5*(no);
			}
			if(no > 52 && no<56) {
				result = 5*(no+1);
			}
			if(no > 55 && no<59) {
				result = 5*(no+2);
			}
			if(no > 58 && no<64) {
				result = 5*(no+3);
			}
			if(no > 63 && no<67) {
				result = 5*(no+4);
			}
			if(no > 66 && no<70) {
				result = 5*(no+5);
			}
			if(no > 69 && no<77) {
				result = 5*(no+6);
			}
			if(no > 76 && no<80) {
				result = 5*(no+7);
			}
			if(no > 79 && no<83) {
				result = 5*(no+8);
			}
			if(no > 82 && no<89) {
				result = 5*(no+9);
			}
			if(no > 89) {
				result = 495;
			}
			return result;
		}
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Il faut récupérer l'étudiant en question 
		// Affiche les résultats où il faut
		int idU = RésultatsEtudiantVueProfScreenController.idU();
		String notes = "SELECT NumPart,Notes FROM Notes WHERE idUtilisateur = ? AND Date = (SELECT MAX(Date) FROM Passer)";
				
		try {
			preparedStatement = connection.prepareStatement(notes);
	        preparedStatement.setInt(1, idU);
	        resultSet = preparedStatement.executeQuery();
	        int noteO = 0;
	        int noteE = 0;
	        // On affiche les notes par sous partie
	        for (int i = 1; i<=7 ; i++) {
	        	resultSet.next();       	
	        	if(resultSet.getInt(1) == 1) {
	        		P1.setText(Integer.toString(resultSet.getInt(2))+" / 6");
	        		noteO = noteO + resultSet.getInt(2);
	        	}
	        	if(resultSet.getInt(1) == 2) {
	        		P2.setText(Integer.toString(resultSet.getInt(2))+" / 25");
	        		noteO = noteO + resultSet.getInt(2);
	        	}
	        	if(resultSet.getInt(1) == 3) {
	        		P3.setText(Integer.toString(resultSet.getInt(2))+" / 39");
	        		noteO = noteO + resultSet.getInt(2);
	        	}
	        	if(resultSet.getInt(1) == 4) {
	        		P4.setText(Integer.toString(resultSet.getInt(2))+" / 30");
	        		noteO = noteO + resultSet.getInt(2);
	        	}
	        	if(resultSet.getInt(1) == 5) {
	        		P5.setText(Integer.toString(resultSet.getInt(2))+" / 30");
	        		noteE = noteO + resultSet.getInt(2);
	        	}
	        	if(resultSet.getInt(1) == 6) {
	        		P6.setText(Integer.toString(resultSet.getInt(2))+" / 16");
	        		noteE = noteO + resultSet.getInt(2);
	        	}
	        	if(resultSet.getInt(1) == 7) {
	        		P7.setText(Integer.toString(resultSet.getInt(2))+" / 54");
	        		noteE = noteO + resultSet.getInt(2);
	        	}
	       }
	        ScoreOral.setText("("+Integer.toString(noteO)+ " / 100)");
        	ScoreEcrit.setText("("+Integer.toString(noteE) + " / 100)");
        	ScoreTotal.setText("("+Integer.toString(noteE + noteO) + " / 200)");
        	Score.setText(Integer.toString(noteE(noteE) + noteO(noteO)) + " / 990");
        	ScoreOr.setText(Integer.toString(noteO(noteO)) + " / 495");
        	ScoreEcr.setText(Integer.toString(noteE(noteE)) + " / 495");
		}
		catch(Exception e){
            e.printStackTrace();
        }
	}
}
