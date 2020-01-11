package enJava.fichiers.Controller.Login;

import enJava.fichiers.Config.ConnectionUtil;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField textEmail;
    
    @FXML
    private PasswordField textPassword;
    
    static String email;
    static String password;
    
    Stage dialogStage = new Stage();
    //Scene scene;
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public FXMLDocumentController() {
        connection = ConnectionUtil.connectdb();
    }
    
    
    
    public void loginAction(ActionEvent event){
        email = textEmail.getText().toString();
        password = textPassword.getText().toString();
    
        String sql = "SELECT * FROM Utilisateur WHERE MailUtilisateur = ? and MdpUtilisateur = ?";
        
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                infoBox("Veuillez entrer un identifiant et une adresse correcte", null, "Failed");
            }else{
                infoBox("Connexion effectuée !",null,"Success" );
                Node node = (Node)event.getSource();
                dialogStage = (Stage) node.getScene().getWindow();
                //dialogStage.close();
                if (resultSet.getInt(6) == 1) {
                	//scene = new Scene(FXMLLoader.load(getClass().getResource("../Prof/AccueilProfScreen.fxml")));
                    dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Enseignant/AccueilProfScreen.fxml")));
                    //dialogStage.sizeToScene();
                    //dialogStage.setMaximized(false);
                    //dialogStage.setFullScreen(true);
                    dialogStage.show();
                }
                
                else {
                	//scene = new Scene(FXMLLoader.load(getClass().getResource("../Etudiant/AccueilEtudiantScreen.fxml")));
                	dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../src/layout/Etudiant/AccueilEtudiantScreen.fxml")));
                	//dialogStage.sizeToScene();
                    //dialogStage.setMaximized(false);
                    //dialogStage.setFullScreen(true);
                	dialogStage.show();
                }
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
    
    public static String mail() {
    	
    	return email;
    }
    
    public static String mdp() {
    	
    	return password;
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
}