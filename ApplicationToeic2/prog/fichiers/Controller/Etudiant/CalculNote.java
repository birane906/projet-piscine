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
    static ResultSet resultSet5 = null;
    static int scoreE;
    static int scoreO;
	
	public CalculNote() {
		setScoreE(1);
		setScoreO(0);
        connection = ConnectionUtil.connectdb();
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
                				if(resultSet5.next()) {
                					if(resultSet5.getString(1).equals(resultSet4.getString(1)))	{
                						if(resultSet4.getInt(2)<101) {
                							setScoreO(getScoreO() + 1);
                						}
                						else {
                							setScoreE(getScoreE() + 1);
                    				}
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
	
	public static int getScoreE() {
		return scoreE;
	}

	public static void setScoreE(int scoreE) {
		CalculNote.scoreE = scoreE;
	}

	public static int getScoreO() {
		return scoreO;
	}

	public static void setScoreO(int scoreO) {
		CalculNote.scoreO = scoreO;
	}
	
	public static int noteE() {
		
		int result = 5;
		if (getScoreE() > 15 && getScoreE() < 25) {
			result = 5*(getScoreE()-14);
		}
		if(getScoreE() > 24 && getScoreE() < 28) {
			result = 5*(getScoreE()-13);
		}
		if(getScoreE() > 27 && getScoreE() < 33) {
			result = 5*(getScoreE()-12);
		}
		if(getScoreE() > 32 && getScoreE() < 38 ){
			result = 5*(getScoreE()-11);
		}
		if(getScoreE() > 37 && getScoreE()<41) {
			result = 5*(getScoreE()-10);
		}
		if(getScoreE() > 40 && getScoreE()<46) {
			result = 5*(getScoreE()-9);
		}
		if(getScoreE() > 45 && getScoreE()<49) {
			result = 5*(getScoreE()-8);
		}
		if(getScoreE() > 48 && getScoreE()<56) {
			result = 5*(getScoreE()-7);
		}
		if(getScoreE() > 55 && getScoreE()<61) {
			result = 5*(getScoreE()-6);
		}
		if(getScoreE() > 60 && getScoreE()<64) {
			result = 5*(getScoreE()-5);
		}
		if(getScoreE() > 63 && getScoreE()<67) {
			result = 5*(getScoreE()-4);
		}
		if(getScoreE() > 66 && getScoreE()<72) {
			result = 5*(getScoreE()-3);
		}
		if(getScoreE() > 71 && getScoreE()<77) {
			result = 5*(getScoreE()-2);
		}
		if(getScoreE() > 76 && getScoreE()<89) {
			result = 5*(getScoreE()-1);
		}
		if(getScoreE() > 88 && getScoreE()<92) {
			result = 5*(getScoreE());
		}
		if(getScoreE() > 91 && getScoreE()<97) {
			result = 5*(getScoreE()+1);
		}
		if(getScoreE() > 96) {
			result = 495;
		}
		return result;
	}

	public static int noteO() {
		
		int result = 5;
		if (getScoreO() > 6 && getScoreO() < 26) {
			result = 5*(getScoreO()-5);
		}
		if(getScoreO() > 25 && getScoreO() < 35) {
			result = 5*(getScoreO()-4);
		}
		if(getScoreO() > 34 && getScoreO() < 44) {
			result = 5*(getScoreO()-3);
		}
		if(getScoreO() > 43 && getScoreO() < 47 ){
			result = 5*(getScoreO()-2);
		}
		if(getScoreO() > 46 && getScoreO()<48) {
			result = 5*(getScoreO()-1);
		}
		if(getScoreO() > 47 && getScoreO()<53) {
			result = 5*(getScoreO());
		}
		if(getScoreO() > 52 && getScoreO()<56) {
			result = 5*(getScoreO()+1);
		}
		if(getScoreO() > 55 && getScoreO()<59) {
			result = 5*(getScoreO()+2);
		}
		if(getScoreO() > 58 && getScoreO()<64) {
			result = 5*(getScoreO()+3);
		}
		if(getScoreO() > 63 && getScoreO()<67) {
			result = 5*(getScoreO()+4);
		}
		if(getScoreO() > 66 && getScoreO()<70) {
			result = 5*(getScoreO()+5);
		}
		if(getScoreO() > 69 && getScoreO()<77) {
			result = 5*(getScoreO()+6);
		}
		if(getScoreO() > 76 && getScoreO()<80) {
			result = 5*(getScoreO()+7);
		}
		if(getScoreO() > 79 && getScoreO()<83) {
			result = 5*(getScoreO()+8);
		}
		if(getScoreO() > 82 && getScoreO()<89) {
			result = 5*(getScoreO()+9);
		}
		if(getScoreO() > 89) {
			result = 495;
		}
		return result;
	}

}
