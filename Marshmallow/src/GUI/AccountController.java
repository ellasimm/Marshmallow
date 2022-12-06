package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import Database.GetDB;
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
	@FXML TableView userBookedFlight;
	@FXML TableColumn flightIDColumn;
	@FXML TableColumn fromCityColumn;
	@FXML TableColumn toCityColumn;
	@FXML TableColumn depTimeColumn;
	@FXML TableColumn arriveTimeColumn;
	@FXML TableColumn dateColumn;
	@FXML Button deleteButton;
	
	ObservableList<Flights> list = FXCollections.observableArrayList(GetDB.flightorders());
	
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
		cityToTable.setCellValueFactory(new PropertyValueFactory<>("toCity"));
		cityFromTable.setCellValueFactory(new PropertyValueFactory<>("fromCity"));
		flightDateTable.setCellValueFactory(new PropertyValueFactory<>("flightDate"));
		depTimeTable.setCellValueFactory(new PropertyValueFactory<>("takeOffTime"));
		arrivalTimeTable.setCellValueFactory(new PropertyValueFactory<>("landingTime"));
		numSeatsTable.setCellValueFactory(new PropertyValueFactory<>("numSeat"));
		flightIDTable.setCellValueFactory(new PropertyValueFactory<>("flightId"));
		flightTable.setItems(list);
		
	}
	
}
