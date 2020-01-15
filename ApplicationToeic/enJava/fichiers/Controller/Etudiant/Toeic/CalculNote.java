package enJava.fichiers.Controller.Etudiant.Toeic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import enJava.fichiers.Config.ConnectionUtil;
import enJava.fichiers.Controller.Login.FXMLDocumentController;

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
    static int scoreP1;
    static int scoreP2;
    static int scoreP3;
    static int scoreP4;
    static int scoreP5;
    static int scoreP6;
    static int scoreP7;
    
	
	public CalculNote() {
		setScoreE(0);
		setScoreO(0);
		setScoreP1(0);
		setScoreP2(0);
		setScoreP3(0);
		setScoreP4(0);
		setScoreP5(0);
		setScoreP6(0);
		setScoreP7(0);
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
                						if(resultSet4.getInt(2)<7) {
                							setScoreO(getScoreO() + 1);
                							setScoreP1(getScoreP1()+1);
                						}
                						else if(resultSet4.getInt(2)<32) {
                							setScoreO(getScoreO() + 1);
                							setScoreP2(getScoreP2()+1);
                						}
                						else if(resultSet4.getInt(2)<71) {
                							setScoreO(getScoreO() + 1);
                							setScoreP3(getScoreP3()+1);
                						}
                						else if(resultSet4.getInt(2)<101) {
                							setScoreO(getScoreO() + 1);
                							setScoreP4(getScoreP4()+1);
                						}
                						else if(resultSet4.getInt(2)<131) {
                							setScoreE(getScoreE() + 1);
                							setScoreP5(getScoreP5()+1);
                						}
                						else if(resultSet4.getInt(2)<147) {
                							setScoreE(getScoreE() + 1);
                							setScoreP6(getScoreP6()+1);
                						}
                						else {
                							setScoreE(getScoreE() + 1);
                							setScoreP7(getScoreP7()+1);
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
			result = 5*getScoreE()-70;
		}
		if(getScoreE() > 24 && getScoreE() < 28) {
			result = 5*getScoreE()-65;
		}
		if(getScoreE() > 27 && getScoreE() < 33) {
			result = 5*getScoreE()-60;
		}
		if(getScoreE() > 32 && getScoreE() < 38 ){
			result = 5*getScoreE()-55;
		}
		if(getScoreE() > 37 && getScoreE()<41) {
			result = 5*getScoreE()-50;
		}
		if(getScoreE() > 40 && getScoreE()<46) {
			result = 5*getScoreE()-45;
		}
		if(getScoreE() > 45 && getScoreE()<49) {
			result = 5*getScoreE()-40;
		}
		if(getScoreE() > 48 && getScoreE()<56) {
			result = 5*getScoreE()-35;
		}
		if(getScoreE() > 55 && getScoreE()<61) {
			result = 5*getScoreE()-30;
		}
		if(getScoreE() > 60 && getScoreE()<64) {
			result = 5*getScoreE()-25;
		}
		if(getScoreE() > 63 && getScoreE()<67) {
			result = 5*getScoreE()-20;
		}
		if(getScoreE() > 66 && getScoreE()<72) {
			result = 5*getScoreE()-15;
		}
		if(getScoreE() > 71 && getScoreE()<77) {
			result = 5*getScoreE()-10;
		}
		if(getScoreE() > 76 && getScoreE()<89) {
			result = 5*getScoreE()-5;
		}
		if(getScoreE() > 88 && getScoreE()<92) {
			result = 5*(getScoreE());
		}
		if(getScoreE() > 91 && getScoreE()<97) {
			result = 5*getScoreE()+5;
		}
		if(getScoreE() > 96) {
			result = 495;
		}
		return result;
	}

	public static int noteO() {
		
		int result = 5;
		if (getScoreO() > 6 && getScoreO() < 26) {
			result = 5*getScoreO()-25;
		}
		if(getScoreO() > 25 && getScoreO() < 35) {
			result = 5*getScoreO()-20;
		}
		if(getScoreO() > 34 && getScoreO() < 44) {
			result = 5*getScoreO()-15;
		}
		if(getScoreO() > 43 && getScoreO() < 47 ){
			result = 5*getScoreO()-10;
		}
		if(getScoreO() > 46 && getScoreO()<48) {
			result = 5*getScoreO()-5;
		}
		if(getScoreO() > 47 && getScoreO()<53) {
			result = 5*(getScoreO());
		}
		if(getScoreO() > 52 && getScoreO()<56) {
			result = 5*getScoreO()+5;
		}
		if(getScoreO() > 55 && getScoreO()<59) {
			result = 5*getScoreO()+10;
		}
		if(getScoreO() > 58 && getScoreO()<64) {
			result = 5*getScoreO()+15;
		}
		if(getScoreO() > 63 && getScoreO()<67) {
			result = 5*getScoreO()+20;
		}
		if(getScoreO() > 66 && getScoreO()<70) {
			result = 5*getScoreO()+25;
		}
		if(getScoreO() > 69 && getScoreO()<77) {
			result = 5*getScoreO()+30;
		}
		if(getScoreO() > 76 && getScoreO()<80) {
			result = 5*getScoreO()+35;
		}
		if(getScoreO() > 79 && getScoreO()<83) {
			result = 5*getScoreO()+40;
		}
		if(getScoreO() > 82 && getScoreO()<89) {
			result = 5*getScoreO()+45;
		}
		if(getScoreO() > 89) {
			result = 495;
		}
		return result;
	}

	public static int getScoreP1() {
		return scoreP1;
	}

	public static void setScoreP1(int scoreP1) {
		CalculNote.scoreP1 = scoreP1;
	}

	public static int getScoreP2() {
		return scoreP2;
	}

	public static void setScoreP2(int scoreP2) {
		CalculNote.scoreP2 = scoreP2;
	}

	public static int getScoreP3() {
		return scoreP3;
	}

	public static void setScoreP3(int scoreP3) {
		CalculNote.scoreP3 = scoreP3;
	}

	public static int getScoreP4() {
		return scoreP4;
	}

	public static void setScoreP4(int scoreP4) {
		CalculNote.scoreP4 = scoreP4;
	}

	public static int getScoreP5() {
		return scoreP5;
	}

	public static void setScoreP5(int scoreP5) {
		CalculNote.scoreP5 = scoreP5;
	}

	public static int getScoreP6() {
		return scoreP6;
	}

	public static void setScoreP6(int scoreP6) {
		CalculNote.scoreP6 = scoreP6;
	}

	public static int getScoreP7() {
		return scoreP7;
	}

	public static void setScoreP7(int scoreP7) {
		CalculNote.scoreP7 = scoreP7;
	}

}
