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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class findFlightController implements Initializable{

	@FXML Button accountButton;
	@FXML Button LogOutButton;
	@FXML TableColumn cityToTable;
	@FXML TableColumn cityFromTable;
	@FXML TableColumn flightDateTable;
	@FXML TableColumn timeTable;
	@FXML TextField searchDeparture;
	@FXML TextField searchArrival;
	@FXML TextField searchDate;
	@FXML TextField searchTime;
	@FXML TableView flightTable;
	@FXML Button searchButton;
	@FXML Button addButton;
	
public void logOut(ActionEvent event) throws Exception {
		
		AnchorPane logOutParent = FXMLLoader.load(getClass().getResource("/GUI/OpeningPage.fxml"));
		Scene logOutScene = new Scene(logOutParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(logOutScene);
		window.show();
	}

public void toAccount(ActionEvent event) throws Exception {
	
	AnchorPane toAccountParent = FXMLLoader.load(getClass().getResource("/GUI/Account.fxml"));
	Scene toAccountScene = new Scene(toAccountParent);
	
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(toAccountScene);
	window.show();
}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
