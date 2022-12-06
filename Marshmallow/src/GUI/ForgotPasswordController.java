package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import Database.LoginDB;
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

	@FXML private TextField UsernameInput;
	@FXML private Button SecurityQuestionButton;
	@FXML private Button HomeButton;
	@FXML private TextField SecurityAnswerIn;


	public void goHome(ActionEvent event) throws Exception {
		
		AnchorPane goHomeParent = FXMLLoader.load(getClass().getResource("/GUI/LoginPage.fxml"));
		Scene homeScene = new Scene(goHomeParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(homeScene);
		window.show();
		
	}
	
	public void passRecovery(ActionEvent event) throws Exception {
		
		String username = UsernameInput.getText();
		String answer = SecurityAnswerIn.getText();
		
		try {
			LoginDB check = new LoginDB();
			String password = check.forgotPassword(username, answer);
			ErrorMessage.showErrorMessage("Your password is: " + password);
		}catch (Exception ex) {
			ErrorMessage.showErrorMessage("Incorrect information");
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
