package enJava.fichiers.Controller.Enseignant.Statistiques;

import javafx.scene.control.TextField;
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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RésultatsEtudiantVueProfScreenController implements Initializable {

	@FXML
	ChoiceBox<String> choixParticipants;
	@FXML
	ChoiceBox<String> choixPromo;
	@FXML
	private TextField nomEtu;
	@FXML
	private TextField prenomEtu;
	
	@FXML
	LineChart<CategoryAxis,NumberAxis> ToeicScoreEvolution;
	
	@FXML
	CategoryAxis xToeicScoreEv;
	
	@FXML
	NumberAxis yToeicScoreEv;
	
	static int idU;
	
	public static int idU() {
		return idU;
	}
	
	
	Stage dialogStage = new Stage();
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
	
	public RésultatsEtudiantVueProfScreenController() {
        connection = ConnectionUtil.connectdb();
    }
	
	// Fonction permettant de récupérer le bon étudiant à partir des données entrées par l'utilisateur (par la suite, elle permettra aussi de voir ses stats)
	public void AfficherStats(ActionEvent event){
		
		String nomE = nomEtu.getText().toString();
		String prenomE = prenomEtu.getText().toString();
		String promoE = (String) choixPromo.getValue();
		if(nomE != null) {
			if(prenomE != null) {
				if(promoE != null){
					String etu = "SELECT COUNT(*),idUtilisateur FROM Utilisateur WHERE NomUtilisateur = ? AND PrenomUtilisateur = ? AND FiliereEtAnnee = ?";
				
					try {
						preparedStatement = connection.prepareStatement(etu);
			            preparedStatement.setString(1, nomE);
			            preparedStatement.setString(2, prenomE);
			            preparedStatement.setString(3, promoE);
			            resultSet = preparedStatement.executeQuery();
			            if (resultSet.next()) {
			            	if(resultSet.getInt(1) == 0) {
			            		infoBox("Il n'existe pas d'étudiant ayant ces informations, veuillez réessayer.", null,"Erreur");
			            	}
			            	else {
				            	infoBox("On a bien récolté le bon étudiant "+ Integer.toString(idU), null,"Bravo");
			            	}
			            }
					}
			        catch(Exception e){
			        	e.printStackTrace();
			    	}
				}
				else {
					infoBox("Vous devez rentrer la filière de l'étudiant.", null,"Erreur");
				}
			}
			else {
				infoBox("Vous devez rentrer le prénom de l'étudiant.", null,"Erreur");
			}	
		}
		else {
			infoBox("Vous devez rentrer le nom de l'étudiant.", null,"Erreur");
		}
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
	
	// Bouton pour voir le bulletin de l'élève
	public void Bulletin(ActionEvent event) {
		try {
			String NomE = nomEtu.getText().toString();
			String PrenomE = prenomEtu.getText().toString();
			String PromoE = (String) choixPromo.getValue();
			if(NomE != null) {
				if(PrenomE != null) {
					if(PromoE != null){
						String etu = "SELECT COUNT(*),idUtilisateur FROM Utilisateur WHERE NomUtilisateur = ? AND PrenomUtilisateur = ? AND FiliereEtAnnee = ?";
					
						try {
							preparedStatement = connection.prepareStatement(etu);
				            preparedStatement.setString(1, NomE);
				            preparedStatement.setString(2, PrenomE);
				            preparedStatement.setString(3, PromoE);
				            resultSet = preparedStatement.executeQuery();
				            if (resultSet.next()) {
				            	if(resultSet.getInt(1) == 0) {
				            		infoBox("Il n'existe pas d'étudiant ayant ces informations, veuillez réessayer.", null,"Erreur");
				            	}
				            	else {     
				            		Node node = (Node)event.getSource();
				        			dialogStage = (Stage) node.getScene().getWindow();
				        			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Statistiques/BulletinEtudiantProfScreen.fxml")));
				            	}
				            }
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
					else {
						infoBox("Vous devez rentrer la filière de l'étudiant.", null,"Erreur");
					}
				}
				else {
					infoBox("Vous devez rentrer le prénom de l'étudiant.", null,"Erreur");
				}	
			}
			else {
				infoBox("Vous devez rentrer le nom de l'étudiant.", null,"Erreur");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	// Bouton pour voir la progression par partie de l'élève
	public void PPP(ActionEvent event) {
		try {
			String NomE = nomEtu.getText().toString();
			String PrenomE = prenomEtu.getText().toString();
			String PromoE = (String) choixPromo.getValue();
			if(NomE != null) {
				if(PrenomE != null) {
					if(PromoE != null){
						String etu = "SELECT COUNT(*),idUtilisateur FROM Utilisateur WHERE NomUtilisateur = ? AND PrenomUtilisateur = ? AND FiliereEtAnnee = ?";
					
						try {
							preparedStatement = connection.prepareStatement(etu);
				            preparedStatement.setString(1, NomE);
				            preparedStatement.setString(2, PrenomE);
				            preparedStatement.setString(3, PromoE);
				            resultSet = preparedStatement.executeQuery();
				            if (resultSet.next()) {
				            	if(resultSet.getInt(1) == 0) {
				            		infoBox("Il n'existe pas d'étudiant ayant ces informations, veuillez réessayer.", null,"Erreur");
				            	}
				            	else {
				            		Node node = (Node)event.getSource();
				        			dialogStage = (Stage) node.getScene().getWindow();
				        			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Statistiques/ProgressionParPartieEtudiantProfScreen.fxml")));
				            	}
				            }
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
					else {
						infoBox("Vous devez rentrer la filière de l'étudiant.", null,"Erreur");
					}
				}
				else {
					infoBox("Vous devez rentrer le prénom de l'étudiant.", null,"Erreur");
				}	
			}
			else {
				infoBox("Vous devez rentrer le nom de l'étudiant.", null,"Erreur");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

		// Bouton pour voir la progression par sous partie
	public void PPSP(ActionEvent event) {
		try {
			String NomE = nomEtu.getText().toString();
			String PrenomE = prenomEtu.getText().toString();
			String PromoE = (String) choixPromo.getValue();
			if(NomE != null) {
				if(PrenomE != null) {
					if(PromoE != null){
						String etu = "SELECT COUNT(*),idUtilisateur FROM Utilisateur WHERE NomUtilisateur = ? AND PrenomUtilisateur = ? AND FiliereEtAnnee = ?";
					
						try {
							preparedStatement = connection.prepareStatement(etu);
				            preparedStatement.setString(1, NomE);
				            preparedStatement.setString(2, PrenomE);
				            preparedStatement.setString(3, PromoE);
				            resultSet = preparedStatement.executeQuery();
				            if (resultSet.next()) {
				            	if(resultSet.getInt(1) == 0) {
				            		infoBox("Il n'existe pas d'étudiant ayant ces informations, veuillez réessayer.", null,"Erreur");
				            	}
				            	else {
				            		Node node = (Node)event.getSource();
				        			dialogStage = (Stage) node.getScene().getWindow();
				        			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Statistiques/ProgressionSousPartieEtudiantProfScreen.fxml")));
				            	}
				            }
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
					else {
						infoBox("Vous devez rentrer la filière de l'étudiant.", null,"Erreur");
					}
				}
				else {
					infoBox("Vous devez rentrer le prénom de l'étudiant.", null,"Erreur");
				}	
			}
			else {
				infoBox("Vous devez rentrer le nom de l'étudiant.", null,"Erreur");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

		
		// Bouton pour voir le recap du dernier TOEIC passé
	public void Recap(ActionEvent event) {
		try {
			String NomE = nomEtu.getText().toString();
			String PrenomE = prenomEtu.getText().toString();
			String PromoE = (String) choixPromo.getValue();
			if(NomE != null) {
				if(PrenomE != null) {
					if(PromoE != null){
						String etu = "SELECT COUNT(*),idUtilisateur FROM Utilisateur WHERE NomUtilisateur = ? AND PrenomUtilisateur = ? AND FiliereEtAnnee = ?";
					
						try {
							preparedStatement = connection.prepareStatement(etu);
				            preparedStatement.setString(1, NomE);
				            preparedStatement.setString(2, PrenomE);
				            preparedStatement.setString(3, PromoE);
				            resultSet = preparedStatement.executeQuery();
				            if (resultSet.next()) {
				            	if(resultSet.getInt(1) == 0) {
				            		infoBox("Il n'existe pas d'étudiant ayant ces informations, veuillez réessayer.", null,"Erreur");
				            	}
				            	else {
				            		idU = resultSet.getInt(2);
				            		
				            		String passer = "SELECT COUNT(*) FROM Passer WHERE idUtilisateur = ?";
				            		
				            		preparedStatement = connection.prepareStatement(passer);
						            preparedStatement.setInt(1, idU);
						            resultSet = preparedStatement.executeQuery();
						            if (resultSet.next()) {
						            	if(resultSet.getInt(1) == 0) {
						            		Node node = (Node)event.getSource();
						        			dialogStage = (Stage) node.getScene().getWindow();
						        			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Statistiques/RécapPasDeDernierTOEICEtudiantProfScreen.fxml")));
						            	}
						            	else {
						            		Node node = (Node)event.getSource();
						        			dialogStage = (Stage) node.getScene().getWindow();
						        			dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Statistiques/RécapDernierTOEICEtudiantProfScreen.fxml")));
						            	}
						            }
				            	}
				            }
						}
				        catch(Exception e){
				        	e.printStackTrace();
				    	}
					}
					else {
						infoBox("Vous devez rentrer la filière de l'étudiant.", null,"Erreur");
					}
				}
				else {
					infoBox("Vous devez rentrer le prénom de l'étudiant.", null,"Erreur");
				}	
			}
			else {
				infoBox("Vous devez rentrer le nom de l'étudiant.", null,"Erreur");
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}

		
		// Fonction pour le bouton valider, nous change d'écran selon si on veut par promo ou par étudiant
	public void Valider(ActionEvent event) {
		try {
			String participants = (String) choixParticipants.getValue();
			if(participants != null) {
				RésultatsProfScreenController.setParti(participants);
				if(participants == "Etudiant") {
					Node node = (Node)event.getSource();
		            dialogStage = (Stage) node.getScene().getWindow();
		            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Statistiques/RésultatsEtudiantVueProfScreen.fxml")));
				}
				else {
					Node node = (Node)event.getSource();
		            dialogStage = (Stage) node.getScene().getWindow();
		            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Enseignant/Statistiques/RésultatsProfPromoScreen.fxml")));
				}
			}
			else {
				infoBox("Vous devez d'abord sélectionner une filière.", null, "Erreur");
			}
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// On initialise la choice box des participants et des promos
		String participant = "SELECT FiliereEtAnnee FROM Filiere WHERE FiliereEtAnnee <> 'Enseignant'";
		try {
			choixParticipants.getItems().add("Etudiant");
			preparedStatement = connection.prepareStatement(participant);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			    choixParticipants.getItems().add(resultSet.getString(1));
			    choixPromo.getItems().add(resultSet.getString(1));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
