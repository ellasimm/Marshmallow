package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import Database.GetDB;
import FlightCode.Admin;
import FlightCode.Login;
import FlightCode.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;


public class LoginPageController implements Initializable {
	
	
	@FXML private TextField UsernameIn;
	@FXML private PasswordField PasswordIn;
	@FXML private Button LoginButton;
	@FXML private Button ForgotPassButton;

	public static Admin currentAdmin;
	public static User currentUser;
	public static String user;
	
	public void goToForgotPassword(ActionEvent event) throws Exception {
		
		AnchorPane forgotPasswordParent = FXMLLoader.load(getClass().getResource("/GUI/ForgotPassword.fxml"));
		Scene forgotPasswordScene = new Scene(forgotPasswordParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(forgotPasswordScene);
		window.show();
	}

	
	public void goBack(ActionEvent event) throws Exception {
		
		AnchorPane backParent = FXMLLoader.load(getClass().getResource("/GUI/OpeningPage.fxml"));
		Scene backScene = new Scene(backParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(backScene);
		window.show();
	}
	
	
	public void logIn(ActionEvent event) throws Exception {
		
		user = UsernameIn.getText();
		String password = PasswordIn.getText();
		
		Login login = new Login(user, password);
		
		if (password.isEmpty() || user.isEmpty()) {
			ErrorMessage.showErrorMessage("Please enter a username AND password");
		}
		else if (login.performLogin() == true) {
			
			if(GetDB.getAdmin(user) == 1) {
				currentUser = GetDB.getUser(user);
				AnchorPane logInAdminParent = FXMLLoader.load(getClass().getResource("/GUI/findFlightAdmin.fxml"));
				Scene logInAdminScene = new Scene(logInAdminParent);
				
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				
				window.setScene(logInAdminScene);
				window.show();	
			}
			
			else {
				currentUser = GetDB.getUser(user);
				AnchorPane logInParent = FXMLLoader.load(getClass().getResource("/GUI/findFlight.fxml"));
				Scene logInScene = new Scene(logInParent);
				
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				
				window.setScene(logInScene);
				window.show();
			}		
		}
		else {
			ErrorMessage.showErrorMessage("Incorrect username or Password");
		}
	}
	
	public void checkLogin(ActionEvent event) {

		User currentUser = new User();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}


