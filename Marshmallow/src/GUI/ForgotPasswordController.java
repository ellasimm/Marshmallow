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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ForgotPasswordController implements Initializable{

	@FXML private Text PassRecoveryInputUsername;
	@FXML private TextField UsernameInput;
	@FXML private Button SecurityQuestionButton;
	@FXML private Text SecurityQuestion;
	@FXML private TextField SecurityAnswerIn;
	@FXML private Button GetPassword;
	@FXML private Rectangle BacgroundRectangle;
	@FXML private Text PasswordText;
	@FXML private Text RememberPassword;
	@FXML private Button HomeButton;


	public void goHome(ActionEvent event) throws Exception {
		
		AnchorPane goHomeParent = FXMLLoader.load(getClass().getResource("/GUI/LoginPage.fxml"));
		Scene homeScene = new Scene(goHomeParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(homeScene);
		window.show();
	}
	
	public void passRecovery(ActionEvent event) throws Exception {
		
		AnchorPane passRecoveryParent = FXMLLoader.load(getClass().getResource("/GUI/PasswordRecovery.fxml"));
		Scene passRecoveryScene = new Scene(passRecoveryParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(passRecoveryScene);
		window.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
