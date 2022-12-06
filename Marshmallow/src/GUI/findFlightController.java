package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import Database.SearchDB;
import FlightCode.Flights;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class findFlightController implements Initializable{

	@FXML Button accountButton;
	@FXML Button LogOutButton;
	@FXML TableColumn<Flights, String> cityToTable;
	@FXML TableColumn<Flights, String> cityFromTable;
	@FXML TableColumn<Flights, String> flightDateTable;
	@FXML TableColumn<Flights, String> timeTable;
	@FXML TextField searchDeparture;
	@FXML TextField searchArrival;
	@FXML TextField searchDate;
	@FXML TextField searchTime;
	@FXML TableView<Flights> flightTable;
	@FXML Button searchButton;
	@FXML Button addButton;
	
	ObservableList<Flights> list;
	int index = -1;
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	
	
	
	
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
	
		cityToTable.setCellValueFactory(new PropertyValueFactory<Flights, String>("toCity"));
		cityFromTable.setCellValueFactory(new PropertyValueFactory<Flights,  String>("fromCity"));
		flightDateTable.setCellValueFactory(new PropertyValueFactory<Flights, String>("flightDate"));
		timeTable.setCellValueFactory(new PropertyValueFactory<Flights, String>("flightNumber"));
		list = SearchDB.searchFlight();
	}
	
	
}
