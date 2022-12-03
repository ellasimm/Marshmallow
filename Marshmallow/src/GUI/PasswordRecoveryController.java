package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PasswordRecoveryController implements Initializable {

	@FXML Button BackButton;
	@FXML TextField answerIn;
	@FXML Text secutriyQuestion;
	@FXML Button getPassButton;
	@FXML Text password;
	
	
public void goBack(ActionEvent event) throws Exception {
		
		AnchorPane backParent = FXMLLoader.load(getClass().getResource("/GUI/ForgotPassword.fxml"));
		Scene backScene = new Scene(backParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(backScene);
		window.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
