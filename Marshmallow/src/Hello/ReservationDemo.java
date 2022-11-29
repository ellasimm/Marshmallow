package Hello;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.TableHeaderRow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ReservationDemo extends Application implements EventHandler<ActionEvent>{

	Button login;
	Button register;
	Label header;
	Image pic;
	
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
		
		header = new Label("hello");
		header.setTranslateY(-270);
		header.setFont(Font.font("Arial", 100));
		
		ImageView piccy = new ImageView();
		Image pic = new Image(new FileInputStream("/Users/ellasimm/Desktop"));
		piccy.setImage(pic);
		
		
		StackPane layout = new StackPane();
		layout.getChildren().add(login);
		layout.getChildren().add(register);
		layout.getChildren().add(header);
		layout.getChildren().add(piccy);
		
		Scene scene = new Scene(layout, 600, 600);
//		Stop[] stops = new Stop[] { new Stop(0, Color.YELLOW), new Stop(1, Color.WHITE)};
//        LinearGradient lg1 = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);
		layout.setStyle("-fx-background-color: plum;");
		
        
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
