package GUI;

import java.net.URL;
import java.util.ResourceBundle;

import Database.InsertDB;
import Database.UpdateDB;
import FlightCode.Flights;
import FlightCode.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminPageController implements Initializable{

	@FXML Button deleteButton;
	@FXML Button backButton;
	@FXML TextField flightDateIn;
	@FXML TextField numSeatIn;
	@FXML TextField takeOffTimeIn;
	@FXML TextField landingTimeIn;
	@FXML TextField fromCityIn;
	@FXML TextField toCityIn;
	@FXML TextField flightNumIn;
	
	
	public void addFlight(ActionEvent event) throws Exception {  
		String fromCity = fromCityIn.getText();
		String toCity = toCityIn.getText();
		Integer numSeat = Integer.parseInt(numSeatIn.getText());
		String flightDate = flightDateIn.getText();
		String landingTime = landingTimeIn.getText();
		String takeOffTime = takeOffTimeIn.getText();
		
		if (fromCityIn.getText().isEmpty() || toCityIn.getText().isEmpty() || numSeatIn.getText().isEmpty()
				|| flightDateIn.getText().isEmpty() || landingTimeIn.getText().isEmpty() || takeOffTimeIn.getText().isEmpty()) {
			
			ErrorMessage.showErrorMessage("Make sure all fields are filled");
		}
		
		Flights.createFlight(fromCity, toCity, numSeat, flightDate, landingTime, takeOffTime);
		
	}
	
	public void deleteFlight(ActionEvent event) throws Exception { 
		
		if (flightNumIn.getText().isBlank()) {
			ErrorMessage.showErrorMessage("Please enter a number");
		}
		
		int flightId = Integer.parseInt(flightNumIn.getText());
		UpdateDB.deleteFlight(flightId);
		if (UpdateDB.success) {
			ErrorMessage.showErrorMessage("Flight deleted");
		}	
	}
	
	public void goBack(ActionEvent event) throws Exception {  
		AnchorPane backParent = FXMLLoader.load(getClass().getResource("/GUI/findFlightAdmin.fxml"));
		Scene backScene = new Scene(backParent);
	
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
		window.setScene(backScene);
		window.show();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	
	
}
