package prog.fichiers.Controller.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import prog.fichiers.Config.ConnectionUtil;
import prog.fichiers.Controller.Login.FXMLDocumentController;

public class CalculNote {
	
	static Connection connection = null;
	static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;
    static ResultSet resultSet1 = null;
    static ResultSet resultSet2 = null; 
    static ResultSet resultSet3 = null; 
    static ResultSet resultSet4 = null; 
    static int scoreE = 0;
    static int scoreO = 0;
	
	public CalculNote() {
        connection = ConnectionUtil.connectdb();
    }
	
	public static void note() {
		
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
         
                		String sql2 = "SELECT ReponseE,NumQuestion FROM Repondre WHERE Repondre.idUtilisateur = ? ";
                		preparedStatement = connection.prepareStatement(sql2);
                		preparedStatement.setInt(1, resultSet.getInt(1));
                		resultSet3 = preparedStatement.executeQuery();
                		while(resultSet3.next()) {
                			String sql4 = "SELECT CorrectionQuestion FROM Question WHERE Question.NumTOEIC = ? AND Question.NumQuestion = ?";
                			preparedStatement = connection.prepareStatement(sql4);
                    		preparedStatement.setInt(1, resultSet.getInt(1));
                    		preparedStatement.setInt(2, resultSet3.getInt(2));
                    		resultSet4 = preparedStatement.executeQuery();
                    		if(resultSet4.next()) {
                    			if(resultSet4.getString(1).equals(resultSet3.getString(1)))	{
                    				if(resultSet3.getInt(2)<101) {
                    					scoreO= scoreO+1;
                    				}
                    				else {
                    					scoreE = scoreE+1;
                    				}
                    			}
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
	
	public static int noteE() {
		
		int result = 5;
		if (scoreE > 15 && scoreE < 25) {
			result = 5*(scoreE-14);
		}
		if(scoreE > 24 && scoreE < 28) {
			result = 5*(scoreE-13);
		}
		if(scoreE > 27 && scoreE < 33) {
			result = 5*(scoreE-12);
		}
		if(scoreE > 32 && scoreE < 38 ){
			result = 5*(scoreE-11);
		}
		if(scoreE > 37 && scoreE<41) {
			result = 5*(scoreE-10);
		}
		if(scoreE > 40 && scoreE<46) {
			result = 5*(scoreE-9);
		}
		if(scoreE > 45 && scoreE<49) {
			result = 5*(scoreE-8);
		}
		if(scoreE > 48 && scoreE<56) {
			result = 5*(scoreE-7);
		}
		if(scoreE > 55 && scoreE<61) {
			result = 5*(scoreE-6);
		}
		if(scoreE > 60 && scoreE<64) {
			result = 5*(scoreE-5);
		}
		if(scoreE > 63 && scoreE<67) {
			result = 5*(scoreE-4);
		}
		if(scoreE > 66 && scoreE<72) {
			result = 5*(scoreE-3);
		}
		if(scoreE > 71 && scoreE<77) {
			result = 5*(scoreE-2);
		}
		if(scoreE > 76 && scoreE<89) {
			result = 5*(scoreE-1);
		}
		if(scoreE > 88 && scoreE<92) {
			result = 5*(scoreE);
		}
		if(scoreE > 91 && scoreE<97) {
			result = 5*(scoreE+1);
		}
		if(scoreE > 96) {
			result = 495;
		}
		return result;
	}

	public static int noteO() {
		
		int result = 5;
		if (scoreE > 6 && scoreE < 26) {
			result = 5*(scoreE-5);
		}
		if(scoreE > 25 && scoreE < 35) {
			result = 5*(scoreE-4);
		}
		if(scoreE > 34 && scoreE < 44) {
			result = 5*(scoreE-3);
		}
		if(scoreE > 43 && scoreE < 47 ){
			result = 5*(scoreE-2);
		}
		if(scoreE > 46 && scoreE<48) {
			result = 5*(scoreE-1);
		}
		if(scoreE > 47 && scoreE<53) {
			result = 5*(scoreE);
		}
		if(scoreE > 52 && scoreE<56) {
			result = 5*(scoreE+1);
		}
		if(scoreE > 55 && scoreE<59) {
			result = 5*(scoreE+2);
		}
		if(scoreE > 58 && scoreE<64) {
			result = 5*(scoreE+3);
		}
		if(scoreE > 63 && scoreE<67) {
			result = 5*(scoreE+4);
		}
		if(scoreE > 66 && scoreE<70) {
			result = 5*(scoreE+5);
		}
		if(scoreE > 69 && scoreE<77) {
			result = 5*(scoreE+6);
		}
		if(scoreE > 76 && scoreE<80) {
			result = 5*(scoreE+7);
		}
		if(scoreE > 79 && scoreE<83) {
			result = 5*(scoreE+8);
		}
		if(scoreE > 82 && scoreE<89) {
			result = 5*(scoreE+9);
		}
		if(scoreE > 89) {
			result = 495;
		}
		return result;
	}
}
