package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;


public class LoginPageController implements Initializable {

	@FXML private Rectangle bckrdBar;
	@FXML private Label Title;
	@FXML private Text accountText;
	@FXML private TextField UsernameIn;
	@FXML private TextField PasswordIn;
	@FXML private Button LoginButton;
	@FXML private Button ForgotPassButton;
	@FXML private Text RegisterText;
	@FXML private TextField FirstNameIn;
	@FXML private TextField AddressIn;
	@FXML private TextField ZipCodeIn;
	@FXML private TextField EmailIn;
	@FXML private TextField UsernameReg;
	@FXML private TextField PasswordReg;
	@FXML private TextField SecurityQuestionIn;
	@FXML private TextField LastNameIn;
	@FXML private TextField StateIn;
	@FXML private TextField SSNIn;
	@FXML private TextField SecurityAnswerIn;
	@FXML private Button RegisterButton;
	@FXML private Rectangle ImageBackground;
	@FXML private ImageView PlaneImage;
	
	
	public void goToForgotPassword(ActionEvent event) throws Exception {
		
		AnchorPane forgotPasswordParent = FXMLLoader.load(getClass().getResource("/GUI/ForgotPassword.fxml"));
		Scene forgotPasswordScene = new Scene(forgotPasswordParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(forgotPasswordScene);
		window.show();
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}


