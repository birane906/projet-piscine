package enJava.fichiers.Controller.Etudiant.Statistiques;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import enJava.fichiers.Config.ConnectionUtil;
import enJava.fichiers.Controller.Login.FXMLDocumentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BulletinEtudiantScreenController implements Initializable {

	@FXML
	Text nom1;
	@FXML
	Text nom2;
	@FXML
	Text nom3;
	@FXML
	Text nom4;
	@FXML
	Text nom5;
	@FXML
	Text nom6;
	@FXML
	Text nom7;
	@FXML
	Text nom8;
	
	@FXML
	Text Partie11;
	@FXML
	Text Partie12;
	@FXML
	Text Partie13;
	@FXML
	Text Partie14;
	@FXML
	Text Partie15;
	@FXML
	Text Partie16;
	@FXML
	Text Partie17;
	@FXML
	Text Partie18;
	
	@FXML
	Text Partie21;
	@FXML
	Text Partie22;
	@FXML
	Text Partie23;
	@FXML
	Text Partie24;
	@FXML
	Text Partie25;
	@FXML
	Text Partie26;
	@FXML
	Text Partie27;
	@FXML
	Text Partie28;
	
	@FXML
	Text Partie31;
	@FXML
	Text Partie32;
	@FXML
	Text Partie33;
	@FXML
	Text Partie34;
	@FXML
	Text Partie35;
	@FXML
	Text Partie36;
	@FXML
	Text Partie37;
	@FXML
	Text Partie38;
	
	@FXML
	Text Partie41;
	@FXML
	Text Partie42;
	@FXML
	Text Partie43;
	@FXML
	Text Partie44;
	@FXML
	Text Partie45;
	@FXML
	Text Partie46;
	@FXML
	Text Partie47;
	@FXML
	Text Partie48;
	
	@FXML
	Text Partie51;
	@FXML
	Text Partie52;
	@FXML
	Text Partie53;
	@FXML
	Text Partie54;
	@FXML
	Text Partie55;
	@FXML
	Text Partie56;
	@FXML
	Text Partie57;
	@FXML
	Text Partie58;
	
	@FXML
	Text Partie61;
	@FXML
	Text Partie62;
	@FXML
	Text Partie63;
	@FXML
	Text Partie64;
	@FXML
	Text Partie65;
	@FXML
	Text Partie66;
	@FXML
	Text Partie67;
	@FXML
	Text Partie68;
	
	@FXML
	Text Partie71;
	@FXML
	Text Partie72;
	@FXML
	Text Partie73;
	@FXML
	Text Partie74;
	@FXML
	Text Partie75;
	@FXML
	Text Partie76;
	@FXML
	Text Partie77;
	@FXML
	Text Partie78;
	
	@FXML
	Text Score1;
	@FXML
	Text Score2;
	@FXML
	Text Score3;
	@FXML
	Text Score4;
	@FXML
	Text Score5;
	@FXML
	Text Score6;
	@FXML
	Text Score7;
	@FXML
	Text Score8;
	
	Stage dialogStage = new Stage();

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public BulletinEtudiantScreenController() {
		connection = ConnectionUtil.connectdb();
	}

	// Bouton Home
	public void Home(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
			dialogStage = (Stage) node.getScene().getWindow();
			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Etudiant/AccueilEtudiantScreen.fxml")));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	// Bouton retour
	public void RetourRés(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
			dialogStage = (Stage) node.getScene().getWindow();
			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Etudiant/Statistiques/MesRésultatsEtudiantScreen.fxml")));
		}
		catch(Exception e){
			e.printStackTrace();
		}
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
	
	public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String id = "SELECT idUtilisateur FROM Utilisateur WHERE MailUtilisateur = ? AND MdpUtilisateur = ?";

		try {
			preparedStatement = connection.prepareStatement(id);
			preparedStatement.setString(1, FXMLDocumentController.mail());
			preparedStatement.setString(2, FXMLDocumentController.mdp());
			ResultSet resultSetID = preparedStatement.executeQuery();
			resultSetID.next();
			int idU = resultSetID.getInt(1);

			String exist = "SELECT COUNT(*) FROM Notes WHERE idUtilisateur = ?";

			preparedStatement = connection.prepareStatement(exist);
			preparedStatement.setInt(1, idU);
			ResultSet resultSet1 = preparedStatement.executeQuery();
			resultSet1.next();

			if(resultSet1.getInt(1) == 0) {
				infoBox("Vous n'avez pas encore passé de TOEIC, il n'y aura donc pas de résultats.", null, "Erreur");
			}
			else {
				for (int j = 1 ; j<=8; j++) {
					String notes = "SELECT DISTINCT NumTOEIC FROM Notes WHERE idUtilisateur = ? ORDER BY Date";	
					preparedStatement = connection.prepareStatement(notes);
					preparedStatement.setInt(1, idU);
					resultSet = preparedStatement.executeQuery();			
					if(resultSet.next()) {
						if(j == 1) {
							String nom = "SELECT LibelleTOEIC FROM Toeic WHERE NumTOEIC = ?";
							int numTOEIC = resultSet.getInt(1);
							preparedStatement = connection.prepareStatement(nom);
							preparedStatement.setInt(1, numTOEIC);
							ResultSet resultSet2 = preparedStatement.executeQuery();
							resultSet2.next();
							nom1.setText(resultSet2.getString(1));
							int noteO = 0;
							int noteE = 0;
							String not = "SELECT NumPart,Notes FROM Notes WHERE NumTOEIC = ? AND idUtilisateur = ?";
							preparedStatement = connection.prepareStatement(not);
							preparedStatement.setInt(1, numTOEIC);
							preparedStatement.setInt(2, idU);
							ResultSet resultSetN = preparedStatement.executeQuery();
							for (int i = 1; i<=7 ; i++) {
								resultSetN.next();
								if(resultSetN.getInt(1) == 1) {
									Partie11.setText(Integer.toString(resultSetN.getInt(2))+" / 6");
									noteO = noteO + resultSetN.getInt(2);
								}
								if(resultSetN.getInt(1) == 2) {
									Partie21.setText(Integer.toString(resultSetN.getInt(2))+" / 25");
									noteO = noteO + resultSetN.getInt(2);
								}
								if(resultSetN.getInt(1) == 3) {
									Partie31.setText(Integer.toString(resultSetN.getInt(2))+" / 39");
									noteO = noteO + resultSetN.getInt(2);
								}
								if(resultSetN.getInt(1) == 4) {
									Partie41.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
									noteO = noteO + resultSetN.getInt(2);
								}
								if(resultSetN.getInt(1) == 5) {
									Partie51.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
									noteE = noteE + resultSetN.getInt(2);
								}
								if(resultSetN.getInt(1) == 6) {
									Partie61.setText(Integer.toString(resultSetN.getInt(2))+" / 16");
									noteE = noteE + resultSetN.getInt(2);
								}
								if(resultSetN.getInt(1) == 7) {
									Partie71.setText(Integer.toString(resultSetN.getInt(2))+" / 54");
									noteE = noteE + resultSetN.getInt(2);
								}
							}						
							Score1.setText(Integer.toString(noteE(noteE) + noteO(noteO)) + " / 990");
						}
						if(j == 2) {
							if(resultSet.next()) {
								String nom = "SELECT LibelleTOEIC FROM Toeic WHERE NumTOEIC = ?";
								int numTOEIC = resultSet.getInt(1);
								preparedStatement = connection.prepareStatement(nom);
								preparedStatement.setInt(1, numTOEIC);
								ResultSet resultSet2 = preparedStatement.executeQuery();
								resultSet2.next();
								nom2.setText(resultSet2.getString(1));
								int noteO = 0;
								int noteE = 0;
								String not = "SELECT NumPart,Notes FROM Notes WHERE NumTOEIC = ? AND idUtilisateur = ?";
								preparedStatement = connection.prepareStatement(not);
								preparedStatement.setInt(1, numTOEIC);
								preparedStatement.setInt(2, idU);
								ResultSet resultSetN = preparedStatement.executeQuery();							
								for (int i = 1; i<=7 ; i++) {
									resultSetN.next();
									if(resultSetN.getInt(1) == 1) {
										Partie12.setText(Integer.toString(resultSetN.getInt(2))+" / 6");
										noteO = noteO + resultSetN.getInt(2);
									}
									if(resultSetN.getInt(1) == 2) {
										Partie22.setText(Integer.toString(resultSetN.getInt(2))+" / 25");
										noteO = noteO + resultSetN.getInt(2);
									}
									if(resultSetN.getInt(1) == 3) {
										Partie32.setText(Integer.toString(resultSetN.getInt(2))+" / 39");
										noteO = noteO + resultSetN.getInt(2);
									}
									if(resultSetN.getInt(1) == 4) {
										Partie42.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
										noteO = noteO + resultSetN.getInt(2);
									}
									if(resultSetN.getInt(1) == 5) {
										Partie52.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
										noteE = noteE + resultSetN.getInt(2);
									}
									if(resultSetN.getInt(1) == 6) {
										Partie62.setText(Integer.toString(resultSetN.getInt(2))+" / 16");
										noteE = noteE + resultSetN.getInt(2);
									}
									if(resultSetN.getInt(1) == 7) {
										Partie72.setText(Integer.toString(resultSetN.getInt(2))+" / 54");
										noteE = noteE + resultSetN.getInt(2);
									}
								}
								Score2.setText(Integer.toString(noteE(noteE) + noteO(noteO)) + " / 990");
							}
						}
						if(j == 3) {
							if(resultSet.next()) {
								if(resultSet.next()) {
									String nom = "SELECT LibelleTOEIC FROM Toeic WHERE NumTOEIC = ?";
									int numTOEIC = resultSet.getInt(1);
									preparedStatement = connection.prepareStatement(nom);
									preparedStatement.setInt(1, numTOEIC);
									ResultSet resultSet2 = preparedStatement.executeQuery();
									resultSet2.next();
									nom3.setText(resultSet2.getString(1));
									int noteO = 0;
									int noteE = 0;
									String not = "SELECT NumPart,Notes FROM Notes WHERE NumTOEIC = ? AND idUtilisateur = ?";
									preparedStatement = connection.prepareStatement(not);
									preparedStatement.setInt(1, numTOEIC);
									preparedStatement.setInt(2, idU);
									ResultSet resultSetN = preparedStatement.executeQuery();
									for (int i = 1; i<=7 ; i++) {
										resultSetN.next();
										if(resultSetN.getInt(1) == 1) {
											Partie13.setText(Integer.toString(resultSetN.getInt(2))+" / 6");
											noteO = noteO + resultSetN.getInt(2);	
										}
										if(resultSetN.getInt(1) == 2) {
											Partie23.setText(Integer.toString(resultSetN.getInt(2))+" / 25");
											noteO = noteO + resultSetN.getInt(2);
										}
										if(resultSetN.getInt(1) == 3) {
											Partie33.setText(Integer.toString(resultSetN.getInt(2))+" / 39");
											noteO = noteO + resultSetN.getInt(2);
										}
										if(resultSetN.getInt(1) == 4) {
											Partie43.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
											noteO = noteO + resultSetN.getInt(2);
										}
										if(resultSetN.getInt(1) == 5) {
											Partie53.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
											noteE = noteE + resultSet.getInt(2);
										}
										if(resultSetN.getInt(1) == 6) {
											Partie63.setText(Integer.toString(resultSetN.getInt(2))+" / 16");
											noteE = noteE + resultSetN.getInt(2);
										}
										if(resultSetN.getInt(1) == 7) {
											Partie73.setText(Integer.toString(resultSetN.getInt(2))+" / 54");
											noteE = noteE + resultSetN.getInt(2);
										}	
									}
									Score3.setText(Integer.toString(noteE(noteE) + noteO(noteO)) + " / 990");
								}
							}
						}

						if(j == 4) {
							if(resultSet.next()){
								if(resultSet.next()){
									if(resultSet.next()){
										String nom = "SELECT LibelleTOEIC FROM Toeic WHERE NumTOEIC = ?";
										int numTOEIC = resultSet.getInt(1);
										preparedStatement = connection.prepareStatement(nom);
										preparedStatement.setInt(1, numTOEIC);
										ResultSet resultSet2 = preparedStatement.executeQuery();
										resultSet2.next();
										nom4.setText(resultSet2.getString(1));
										int noteO = 0;
										int noteE = 0;
										String not = "SELECT NumPart,Notes FROM Notes WHERE NumTOEIC = ? AND idUtilisateur = ?";
										preparedStatement = connection.prepareStatement(not);
										preparedStatement.setInt(1, numTOEIC);
										preparedStatement.setInt(2, idU);
										ResultSet resultSetN = preparedStatement.executeQuery();
										for (int i = 1; i<=7 ; i++) {
											resultSetN.next();
											if(resultSetN.getInt(1) == 1) {
												Partie14.setText(Integer.toString(resultSetN.getInt(2))+" / 6");
												noteO = noteO + resultSetN.getInt(2);
											}
											if(resultSetN.getInt(1) == 2) {
												Partie24.setText(Integer.toString(resultSetN.getInt(2))+" / 25");
												noteO = noteO + resultSetN.getInt(2);
											}
											if(resultSetN.getInt(1) == 3) {
												Partie34.setText(Integer.toString(resultSetN.getInt(2))+" / 39");
												noteO = noteO + resultSetN.getInt(2);
											}
											if(resultSetN.getInt(1) == 4) {
												Partie44.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
												noteO = noteO + resultSetN.getInt(2);
											}
											if(resultSetN.getInt(1) == 5) {
												Partie54.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
												noteE = noteE + resultSetN.getInt(2);
											}
											if(resultSetN.getInt(1) == 6) {
												Partie64.setText(Integer.toString(resultSetN.getInt(2))+" / 16");
												noteE = noteE + resultSetN.getInt(2);
											}
											if(resultSetN.getInt(1) == 7) {
												Partie74.setText(Integer.toString(resultSetN.getInt(2))+" / 54");
												noteE = noteE + resultSetN.getInt(2);
											}	
										}
										Score4.setText(Integer.toString(noteE(noteE) + noteO(noteO)) + " / 990");
									}
								}
							}
						}

						if(j == 5) {
							if(resultSet.next()) {
								if(resultSet.next()) {
									if(resultSet.next()) {
										if(resultSet.next()) {
											String nom = "SELECT LibelleTOEIC FROM Toeic WHERE NumTOEIC = ?";
											int numTOEIC = resultSet.getInt(1);
											preparedStatement = connection.prepareStatement(nom);
											preparedStatement.setInt(1, numTOEIC);
											ResultSet resultSet2 = preparedStatement.executeQuery();
											resultSet2.next();
											nom5.setText(resultSet2.getString(1));
											int noteO = 0;
											int noteE = 0;
											String not = "SELECT NumPart,Notes FROM Notes WHERE NumTOEIC = ? AND idUtilisateur = ?";
											preparedStatement = connection.prepareStatement(not);
											preparedStatement.setInt(1, numTOEIC);
											preparedStatement.setInt(2, idU);
											ResultSet resultSetN = preparedStatement.executeQuery();
											for (int i = 1; i<=7 ; i++) {
												resultSetN.next();
												if(resultSetN.getInt(1) == 1) {
													Partie15.setText(Integer.toString(resultSetN.getInt(2))+" / 6");
													noteO = noteO + resultSetN.getInt(2);
												}
												if(resultSetN.getInt(1) == 2) {
													Partie25.setText(Integer.toString(resultSetN.getInt(2))+" / 25");
													noteO = noteO + resultSetN.getInt(2);
												}
												if(resultSetN.getInt(1) == 3) {
													Partie35.setText(Integer.toString(resultSetN.getInt(2))+" / 39");
													noteO = noteO + resultSetN.getInt(2);
												}
												if(resultSetN.getInt(1) == 4) {
													Partie45.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
													noteO = noteO + resultSetN.getInt(2);
												}
												if(resultSetN.getInt(1) == 5) {
													Partie55.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
													noteE = noteE + resultSetN.getInt(2);
												}
												if(resultSetN.getInt(1) == 6) {
													Partie65.setText(Integer.toString(resultSetN.getInt(2))+" / 16");
													noteE = noteE + resultSetN.getInt(2);
												}
												if(resultSetN.getInt(1) == 7) {
													Partie75.setText(Integer.toString(resultSetN.getInt(2))+" / 54");
													noteE = noteE + resultSetN.getInt(2);
												}	
											}
											Score5.setText(Integer.toString(noteE(noteE) + noteO(noteO)) + " / 990");
										}
									}
								}
							}
						}
						if(j == 6) {
							if(resultSet.next()) {
								if(resultSet.next()) {
									if(resultSet.next()) {
										if(resultSet.next()) {
											if(resultSet.next()) {
												String nom = "SELECT LibelleTOEIC FROM Toeic WHERE NumTOEIC = ?";
												int numTOEIC = resultSet.getInt(1);
												preparedStatement = connection.prepareStatement(nom);
												preparedStatement.setInt(1, numTOEIC);
												ResultSet resultSet2 = preparedStatement.executeQuery();
												resultSet2.next();
												nom6.setText(resultSet2.getString(1));
												int noteO = 0;
												int noteE = 0;
												String not = "SELECT NumPart,Notes FROM Notes WHERE NumTOEIC = ? AND idUtilisateur = ?";
												preparedStatement = connection.prepareStatement(not);
												preparedStatement.setInt(1, numTOEIC);
												preparedStatement.setInt(2, idU);
												ResultSet resultSetN = preparedStatement.executeQuery();
												for (int i = 1; i<=7 ; i++) {
													resultSetN.next();
													if(resultSetN.getInt(1) == 1) {
														Partie16.setText(Integer.toString(resultSetN.getInt(2))+" / 6");
														noteO = noteO + resultSetN.getInt(2);
													}
													if(resultSetN.getInt(1) == 2) {
														Partie26.setText(Integer.toString(resultSetN.getInt(2))+" / 25");
														noteO = noteO + resultSetN.getInt(2);
													}
													if(resultSetN.getInt(1) == 3) {
														Partie36.setText(Integer.toString(resultSetN.getInt(2))+" / 39");
														noteO = noteO + resultSetN.getInt(2);
													}
													if(resultSetN.getInt(1) == 4) {
														Partie46.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
														noteO = noteO + resultSetN.getInt(2);
													}
													if(resultSetN.getInt(1) == 5) {
														Partie56.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
														noteE = noteE + resultSetN.getInt(2);
													}
													if(resultSetN.getInt(1) == 6) {
														Partie66.setText(Integer.toString(resultSetN.getInt(2))+" / 16");
														noteE = noteE + resultSetN.getInt(2);
													}
													if(resultSetN.getInt(1) == 7) {
														Partie76.setText(Integer.toString(resultSetN.getInt(2))+" / 54");
														noteE = noteE + resultSetN.getInt(2);
													}	
												}
												Score6.setText(Integer.toString(noteE(noteE) + noteO(noteO)) + " / 990");
											}
										}
									}
								}
							}
						}
						if(j == 7) {
							if(resultSet.next()) {
								if(resultSet.next()) {
									if(resultSet.next()) {
										if(resultSet.next()) {
											if(resultSet.next()) {
												if(resultSet.next()) {
													String nom = "SELECT LibelleTOEIC FROM Toeic WHERE NumTOEIC = ?";
													int numTOEIC = resultSet.getInt(1);
													preparedStatement = connection.prepareStatement(nom);
													preparedStatement.setInt(1, numTOEIC);
													ResultSet resultSet2 = preparedStatement.executeQuery();
													resultSet2.next();
													nom7.setText(resultSet2.getString(1));
													int noteO = 0;
													int noteE = 0;
													String not = "SELECT NumPart,Notes FROM Notes WHERE NumTOEIC = ? AND idUtilisateur = ?";
													preparedStatement = connection.prepareStatement(not);
													preparedStatement.setInt(1, numTOEIC);
													preparedStatement.setInt(2, idU);
													ResultSet resultSetN = preparedStatement.executeQuery();
													for (int i = 1; i<=7 ; i++) {
														resultSetN.next();
														if(resultSetN.getInt(1) == 1) {
															Partie17.setText(Integer.toString(resultSetN.getInt(2))+" / 6");
															noteO = noteO + resultSetN.getInt(2);
														}
														if(resultSetN.getInt(1) == 2) {
															Partie27.setText(Integer.toString(resultSetN.getInt(2))+" / 25");
															noteO = noteO + resultSetN.getInt(2);
														}
														if(resultSetN.getInt(1) == 3) {
															Partie37.setText(Integer.toString(resultSetN.getInt(2))+" / 39");
															noteO = noteO + resultSetN.getInt(2);
														}
														if(resultSetN.getInt(1) == 4) {
															Partie47.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
															noteO = noteO + resultSetN.getInt(2);
														}
														if(resultSetN.getInt(1) == 5) {
															Partie57.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
															noteE = noteE + resultSetN.getInt(2);
														}
														if(resultSetN.getInt(1) == 6) {
															Partie67.setText(Integer.toString(resultSetN.getInt(2))+" / 16");
															noteE = noteE + resultSetN.getInt(2);
														}
														if(resultSetN.getInt(1) == 7) {
															Partie77.setText(Integer.toString(resultSetN.getInt(2))+" / 54");
															noteE = noteE + resultSetN.getInt(2);
														}	
													}
													Score7.setText(Integer.toString(noteE(noteE) + noteO(noteO)) + " / 990");
												}
											}
										}
									}
								}
							}

						}
						if(j == 8) {
							if(resultSet.next()) {
								if(resultSet.next()) {
									if(resultSet.next()) {
										if(resultSet.next()) {
											if(resultSet.next()) {
												if(resultSet.next()) {
													if(resultSet.next()) {
														String nom = "SELECT LibelleTOEIC FROM Toeic WHERE NumTOEIC = ?";
														int numTOEIC = resultSet.getInt(1);
														preparedStatement = connection.prepareStatement(nom);
														preparedStatement.setInt(1, numTOEIC);
														ResultSet resultSet2 = preparedStatement.executeQuery();
														resultSet2.next();
														nom8.setText(resultSet2.getString(1));
														int noteO = 0;
														int noteE = 0;
														String not = "SELECT NumPart,Notes FROM Notes WHERE NumTOEIC = ? AND idUtilisateur = ?";
														preparedStatement = connection.prepareStatement(not);
														preparedStatement.setInt(1, numTOEIC);
														preparedStatement.setInt(2, idU);
														ResultSet resultSetN = preparedStatement.executeQuery();
														for (int i = 1; i<=7 ; i++) {
															resultSetN.next();
															if(resultSetN.getInt(1) == 1) {
																Partie18.setText(Integer.toString(resultSetN.getInt(2))+" / 6");
																noteO = noteO + resultSetN.getInt(2);
															}
															if(resultSetN.getInt(1) == 2) {
																Partie28.setText(Integer.toString(resultSetN.getInt(2))+" / 25");
																noteO = noteO + resultSetN.getInt(2);
															}
															if(resultSetN.getInt(1) == 3) {
																Partie38.setText(Integer.toString(resultSetN.getInt(2))+" / 39");
																noteO = noteO + resultSetN.getInt(2);
															}
															if(resultSetN.getInt(1) == 4) {
																Partie48.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
																noteO = noteO + resultSetN.getInt(2);
															}
															if(resultSetN.getInt(1) == 5) {
																Partie58.setText(Integer.toString(resultSetN.getInt(2))+" / 30");
																noteE = noteE + resultSetN.getInt(2);
															}
															if(resultSetN.getInt(1) == 6) {
																Partie68.setText(Integer.toString(resultSetN.getInt(2))+" / 16");
																noteE = noteE + resultSetN.getInt(2);
															}
															if(resultSetN.getInt(1) == 7) {
																Partie78.setText(Integer.toString(resultSetN.getInt(2))+" / 54");
																noteE = noteE + resultSetN.getInt(2);
															}	
														}
														Score8.setText(Integer.toString(noteE(noteE) + noteO(noteO)) + " / 990");
													}
												}
											}
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
}
