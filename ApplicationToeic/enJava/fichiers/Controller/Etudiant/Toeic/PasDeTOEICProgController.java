package enJava.fichiers.Controller.Etudiant.Toeic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

public class PasDeTOEICProgController implements Initializable {
	
	Stage dialogStage = new Stage();

	public void Home(ActionEvent event) {
		try {
			Node node = (Node)event.getSource();
            dialogStage = (Stage) node.getScene().getWindow();
            dialogStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../../../../../src/layout/Etudiant/Toeic/AccueilEtudiantScreen.fxml")));
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
