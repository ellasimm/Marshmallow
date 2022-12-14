package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import GUI.LoginPageController;
import Database.GetDB;
import FlightCode.FlightOrder;
import FlightCode.Flights;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AccountController implements Initializable{

	
	@FXML Button backButton;
	@FXML Button logOutButton;
	@FXML TableView<FlightOrder> userBookedFlight;
	@FXML TableColumn<FlightOrder, Integer> flightIDColumn;
	@FXML TableColumn<FlightOrder, String> fromCityColumn;
	@FXML TableColumn<FlightOrder, String> toCityColumn;
	@FXML TableColumn<FlightOrder, String> depTimeColumn;
	@FXML TableColumn<FlightOrder, String> arriveTimeColumn;
	@FXML TableColumn<FlightOrder, String> dateColumn;
	@FXML Button deleteButton;
	
	ObservableList<FlightOrder> list = FXCollections.observableArrayList(GetDB.flightorders(LoginPageController.currentUser.getUserID()));
	
public void back(ActionEvent event) throws Exception {
		
		AnchorPane backParent = FXMLLoader.load(getClass().getResource("/GUI/findFlight.fxml"));
		Scene backScene = new Scene(backParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(backScene);
		window.show();
	}
	
public void logOut(ActionEvent event) throws Exception {
	
	AnchorPane logOutParent = FXMLLoader.load(getClass().getResource("/GUI/OpeningPage.fxml"));
	Scene logOutScene = new Scene(logOutParent);
	
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(logOutScene);
	window.show();
}

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		flightIDColumn.setCellValueFactory(new PropertyValueFactory<>("flightId"));
		fromCityColumn.setCellValueFactory(new PropertyValueFactory<>("fromCity"));
		toCityColumn.setCellValueFactory(new PropertyValueFactory<>("toCity"));
		depTimeColumn.setCellValueFactory(new PropertyValueFactory<>("takeOffTime"));
		arriveTimeColumn.setCellValueFactory(new PropertyValueFactory<>("landingTime"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("flightDate"));
		userBookedFlight.setItems(list);
		
	}
	
}
