package Hello;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.TableHeaderRow;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ReservationDemo extends Application implements EventHandler<ActionEvent>{

public static void main(String[] args) {
		
		launch(args);
	
	}

	@Override
	public void start(Stage firstStage) throws Exception {
		
		firstStage.setTitle("Main");
		
		Button login = new Button("Login");
		login.setTranslateY(-270);
		login.setTranslateX(195);
		login.setOnAction(this);
		
		Button register = new Button("Register");
		register.setTranslateY(-270);
		register.setTranslateX(250);
		register.setOnAction(this);
		
		StackPane layout = new StackPane();
		layout.getChildren().add(login);
		layout.getChildren().add(register);
		
		Scene scene = new Scene(layout, 600, 600);
		
		
		firstStage.setScene(scene);
		firstStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		
	}
	
	
}
