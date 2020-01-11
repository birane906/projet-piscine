package prog.fichiers.Controller.Etudiant;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import prog.fichiers.Config.ConnectionUtil;

public class QuestionnaireController implements Initializable{

	
	Connection connection = null;
	
	public QuestionnaireController() {
        connection = ConnectionUtil.connectdb();
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
