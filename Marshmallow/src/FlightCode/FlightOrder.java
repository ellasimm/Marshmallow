package FlightCode;
import java.util.Date;
import java.util.Random;

import Database.GetDB;
import Database.InsertDB;
import GUI.LoginPageController;
public class FlightOrder {
	
	private int orderNumber;
	private Flights flightId;
	private Date bookingDate;
	private Aircraft[] seatNumbers;
	private int[] passengersSeatNumbers;
	//private int[] passengersSsn;
	private Date[] passengersDateOfBirth;
	private Flights fromCity;
	private Flights toCity;
	private Flights flightDate;
	private Flights takeOffTime;
	private Flights landingTime;
	private Flights unitCost;
	private float subtotal;
	private boolean bookingStatus;
	private User userID;
	private String passenger_userName;
	
	public FlightOrder(){
	}
	public FlightOrder(int orderNumber, Flights flightId, Date bookingDate, int[] passengersSeatNumbers, 
			int[] passengersSsn, Date[] passengersDateOfBirth, Flights fromCity, Flights toCity, Flights flightDate,
			Flights takeOffTime, Flights landingTime, Flights unitCost, float subtotal, boolean bookingStatus, User userID, String passenger_userName){
		this.orderNumber = orderNumber;
		this.flightId = flightId;
		this.bookingDate = bookingDate;
		this.passengersSeatNumbers = passengersSeatNumbers;
		//this.passengersSsn = passengersSsn;
		this.passengersDateOfBirth = passengersDateOfBirth;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.flightDate = flightDate;
		this.takeOffTime = takeOffTime;
		this.landingTime = landingTime;
		this.unitCost = unitCost;
		this.subtotal = subtotal;
		this.bookingStatus = bookingStatus;
		this.userID = userID;
		this.passenger_userName = passenger_userName;
	}
	
	public FlightOrder(Flights flightId, Flights flightDate, Flights takeOffTime, Flights landingTime, Flights fromCity, Flights toCity) {
		this.flightId = flightId;
		this.flightDate = flightDate;
		this.takeOffTime = takeOffTime;
		this.landingTime = landingTime;
		this.fromCity = fromCity;
		this.toCity = toCity;
	}
	
	//just created this constructor for booking
	public FlightOrder(int orderNumber, User userID, Flights flightId,  Flights flightDate,Flights takeOffTime, Flights landingTime, Flights fromCity, Flights toCity, String userName) {
		this.orderNumber = orderNumber;
		this.userID = userID;
		this.flightId = flightId;
		this.flightDate = flightDate;
		this.takeOffTime = takeOffTime;
		this.landingTime = landingTime;
		this.fromCity = fromCity;
		this.toCity = toCity;
		passenger_userName = userName;
		
	}
	public void displayAvailableSeats() {
	}
	public void displayCheckout() {
	}
	public void placeOrder(int flightId) {
		int ticketNum = generateTicket();
		Flights toBook = GetDB.getFlight(flightId);//retrieve flightID from the DB
		
		FlightOrder booking = new FlightOrder(orderNumber, LoginPageController.currentUser.getUserID(), flightId, toBook.getFlightDate(),
				toBook.getTakeOffTime(), toBook.getLandingTime(), toBook.getFromCity(), toBook.getToCity(),
				LoginPageController.currentUser.getUserName()); //why does it have errors
		
		InsertDB.insertFightOrder(booking); //need to create this method in InsertDB
	}
	public void saveCustomerActivity() {
	}
	public void goMainMenu() {
	}
	
	public static int generateTicket() {
		Random rand  = new Random();
		int ticketNum = rand.nextInt(999);
		return ticketNum;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int[] getPassengersSeatNumbers() {
		return passengersSeatNumbers;
	}
	public void setPassengersSeatNumbers(int[] passengersSeatNumbers) {
		this.passengersSeatNumbers = passengersSeatNumbers;
	}
	public String[] getPassengersFullNames() {
		return passengersFullNames;
	}
	public void setPassengersFullNames(String[] passengersFullNames) {
		this.passengersFullNames = passengersFullNames;
	}
	public int[] getPassengersSsn() {
		return passengersSsn;
	}
	public void setPassengersSsn(int[] passengersSsn) {
		this.passengersSsn = passengersSsn;
	}
	public Date[] getPassengersDateOfBirth() {
		return passengersDateOfBirth;
	}
	public void setPassengersDateOfBirth(Date[] passengersDateOfBirth) {
		this.passengersDateOfBirth = passengersDateOfBirth;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public boolean isBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
}