package Hello;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.TableHeaderRow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class ReservationDemo extends Application implements EventHandler<ActionEvent>{

	Button login;
	Button register;
	
public static void main(String[] args) {
		
		launch(args);
	
	}

	@Override
	public void start(Stage firstStage) throws Exception {
		
		firstStage.setTitle("Main");
		
		login = new Button("Login");
		login.setTranslateY(-270);
		login.setTranslateX(195);
		login.setOnAction(this);
		
		register = new Button("Register");
		register.setTranslateY(-270);
		register.setTranslateX(250);
		register.setOnAction(this);
		
		StackPane layout = new StackPane();
		layout.getChildren().add(login);
		layout.getChildren().add(register);
		
		Scene scene = new Scene(layout, 600, 600);
		Stop[] stops = new Stop[] { new Stop(0, Color.YELLOW), new Stop(1, Color.WHITE)};
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        scene.setFill(lg1);
		
		firstStage.setScene(scene);
		firstStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		
		if (event.getSource() == login) {
			System.out.println("you're logged in");
		}
		
		if (event.getSource() == register) {
			System.out.println("youre registered");
		}
		
	}
	
	
}
