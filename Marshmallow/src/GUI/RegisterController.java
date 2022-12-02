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
import javafx.stage.Stage;

public class RegisterController implements Initializable{

	@FXML Button BackButton;
	@FXML TextField firstNameIn;
	@FXML TextField ssnIn;
	@FXML TextField AddressIn;
	@FXML TextField zipCodeIn;
	@FXML TextField lastNameIn;
	@FXML TextField usernameIn;
	@FXML TextField passwordIn;
	@FXML TextField eMailIn;
	@FXML TextField answerIn;
	@FXML TextField securityQuestionIn;
	@FXML TextField StateIn;
	@FXML Button register;
	
	public void goBack(ActionEvent event) throws Exception {
		
		AnchorPane goBackParent = FXMLLoader.load(getClass().getResource("/GUI/OpeningPage.fxml"));
		Scene goBackScene = new Scene(goBackParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(goBackScene);
		window.show();
	}
	
public void register(ActionEvent event) throws Exception {
		
		AnchorPane registerParent = FXMLLoader.load(getClass().getResource("/GUI/findFlight.fxml"));
		Scene registerScene = new Scene(registerParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(registerScene);
		window.show();
	}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
}
