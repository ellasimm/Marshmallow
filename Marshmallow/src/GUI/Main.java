package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application{

	public static void main(String[] args) {
		
		launch(args);
	
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
	
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/GUI/LoginPage.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("Login");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		

	}
}
