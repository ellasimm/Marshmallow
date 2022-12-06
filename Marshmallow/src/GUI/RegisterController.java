package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import Database.InsertDB;
import FlightCode.User;
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
	@FXML TextField securityAnswerIn;
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
		
	if (firstNameIn.getText().isEmpty() || lastNameIn.getText().isEmpty() || ssnIn.getText().isEmpty() || AddressIn.getText().isEmpty() || StateIn.getText().isEmpty() || 
			zipCodeIn.getText().isEmpty() || eMailIn.getText().isEmpty() || usernameIn.getText().isEmpty() || passwordIn.getText().isEmpty() || securityQuestionIn.getText().isEmpty() || securityAnswerIn.getText().isEmpty()) {
		
		ErrorMessage.showErrorMessage("Make sure all fields are filled");
	}
	else {
		User.generateUser(usernameIn.getText(), passwordIn.getText(), firstNameIn.getText(), 
				lastNameIn.getText(), Integer.parseInt(ssnIn.getText()), eMailIn.getText(), AddressIn.getText(), 
				Integer.parseInt(zipCodeIn.getText()), StateIn.getText(), securityQuestionIn.getText(), securityAnswerIn.getText());
	}
	
	if (InsertDB.success) {
		ErrorMessage.showErrorMessage("You are sucessfully registered. Please hit the back button and log in");
	}
	}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
}
