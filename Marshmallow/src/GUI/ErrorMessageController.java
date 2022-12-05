package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Modality;


public class ErrorMessageController implements Initializable{

	
	@FXML Label errorMessage;
	@FXML Button errorButton;
	
	public void display(String message) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		errorMessage.setText(message);
		
	}

	public void handleCloseButtonAction(ActionEvent event) throws IOException {
	    Stage stage = (Stage) errorButton.getScene().getWindow();
	    stage.close();
	    AnchorPane openErrorParent = FXMLLoader.load(getClass().getResource("/GUI/ErrorMessage.fxml"));
	    Scene scene = new Scene(openErrorParent);
	    stage.showAndWait();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
