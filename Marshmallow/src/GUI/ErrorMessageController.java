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
	
public void openError(String message) throws Exception {
		
		AnchorPane openErrorParent = FXMLLoader.load(getClass().getResource("/GUI/ErrorMessage.fxml"));
		Scene openErrorScene = new Scene(openErrorParent);
		Stage window = FXMLLoader.load(getClass().getResource("/GUI/ErrorMessage.fxml"));
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setScene(openErrorScene);
		
		window.show();
	}

	public void handleCloseButtonAction(ActionEvent event) throws IOException {
	    Stage stage = (Stage) errorButton.getScene().getWindow();
	    stage.close();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
