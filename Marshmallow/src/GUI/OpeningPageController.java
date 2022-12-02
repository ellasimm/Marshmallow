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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OpeningPageController implements Initializable{

	@FXML Button loginButton;
	@FXML Button registerButton;
	
public void goToLogin(ActionEvent event) throws Exception {
		
		AnchorPane loginParent = FXMLLoader.load(getClass().getResource("/GUI/LoginPage.fxml"));
		Scene loginScene = new Scene(loginParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(loginScene);
		window.show();
	}

public void goToRegister(ActionEvent event) throws Exception {
	
	AnchorPane registerParent = FXMLLoader.load(getClass().getResource("/GUI/Register.fxml"));
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
