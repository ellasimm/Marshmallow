package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import Database.GetDB;
import Database.SearchDB;
import FlightCode.FlightOrder;
import FlightCode.Flights;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class findFlightAdminController implements Initializable{

	@FXML Button accountButton;
	@FXML Button LogOutButton;
	@FXML TableColumn<Flights, String> cityToTable;
	@FXML TableColumn<Flights, String> cityFromTable;
	@FXML TableColumn<Flights, String> flightDateTable;
	@FXML TableColumn<Flights, String> depTimeTable;
	@FXML TableColumn<Flights, String> arrivalTimeTable;
	@FXML TableColumn<Flights, Integer> numSeatsTable;
	@FXML TableColumn<Flights, Integer> flightIDTable;
	@FXML TextField searchDeparture;
	@FXML TextField searchArrival;
	@FXML TextField searchDate;
	@FXML TextField searchTime;
	@FXML TableView<Flights> flightTable;
	@FXML Button searchButton;
	@FXML Button addButton;
	@FXML TextField flightNum;
	@FXML Button adminButton;
	
	ObservableList<Flights> list = FXCollections.observableArrayList(GetDB.allFlights());
	
	public void addFlight(ActionEvent event) throws Exception {
		int flightId = Integer.parseInt(flightNum.getText());
		FlightOrder.orderFlight(flightId);
	}
	
	
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
	public void initialize(URL url, ResourceBundle resource) {
		cityToTable.setCellValueFactory(new PropertyValueFactory<>("toCity"));
		cityFromTable.setCellValueFactory(new PropertyValueFactory<>("fromCity"));
		flightDateTable.setCellValueFactory(new PropertyValueFactory<>("flightDate"));
		depTimeTable.setCellValueFactory(new PropertyValueFactory<>("takeOffTime"));
		arrivalTimeTable.setCellValueFactory(new PropertyValueFactory<>("landingTime"));
		numSeatsTable.setCellValueFactory(new PropertyValueFactory<>("numSeat"));
		flightIDTable.setCellValueFactory(new PropertyValueFactory<>("flightId"));
		flightTable.setItems(list);
		
		FilteredList<Flights> filteredData = new FilteredList<>(list, b -> true);
		searchDeparture.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Flights -> {
				if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
					return true;
				}
				String searchKeyword = newValue.toLowerCase();
				
				if (Flights.getToCity().toLowerCase().indexOf(searchKeyword) > -1) {
					return true;
				}
				else if (Flights.getFromCity().toLowerCase().indexOf(searchKeyword) > -1) {
					return true;
				}
				else if (Flights.getFlightDate().toLowerCase().indexOf(searchKeyword) > -1) {
					return true;
				}
				else if (Flights.getTakeOffTime().toLowerCase().indexOf(searchKeyword) > -1) {
					return true;
				}
				else if (Flights.getLandingTime().toLowerCase().indexOf(searchKeyword) > -1) {
					return true;
				}
				else if (Flights.getNumSeats().toString().toLowerCase().indexOf(searchKeyword) > -1) {
					return true;
				}
				else if (Flights.getFlightId().toString().toLowerCase().indexOf(searchKeyword) > -1) {
					return true;
				}
				else {
					return false;
				}
			});
		});
		
		SortedList<Flights> sortedList = new SortedList<>(filteredData);
		
		sortedList.comparatorProperty().bind(flightTable.comparatorProperty());
		
		flightTable.setItems(sortedList);
	}	
	
}