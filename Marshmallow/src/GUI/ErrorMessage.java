package GUI;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import java.io.PrintWriter;
import java.io.StringWriter;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ErrorMessage {

	
//	 public static void showErrorMessage(String message) {
//	        Alert alert = new Alert(AlertType.ERROR);
//	        alert.setTitle("DevLaunch Dialog");
//	        alert.setHeaderText("An error has been encountered");
//	        alert.setContentText(message);
//
//	        alert.showAndWait();
//	    }
public static void showErrorMessage(String message) {
		
		Stage window = new Stage();
		
		// block events to other window.
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("error");
		window.setMinWidth(250);
		
		
		Label label = new Label();
		label.setText(message);
		Button closeButton = new Button("Close this window");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		//Display window and wait for it to be closed before returning 
		Scene scene = new Scene(layout);
		scene.getStylesheets().add("graphicUserInterface/thing.css");
		window.setScene(scene);
		window.showAndWait();
		
	

	}
	}

