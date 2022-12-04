package FlightCode;
import java.util.Date;
import java.util.Random;

import Database.InsertDB;
import GUI.LoginPageController;
public class FlightOrder {
	
	private int orderNumber;
	private Flights flightId;
	private Date bookingDate;
	private Aircraft[] seatNumbers;
	private int[] passengersSeatNumbers;
	private String[] passengersFullNames;  //is this necessary? 
	private int[] passengersSsn;
	private Date[] passengersDateOfBirth;
	private Flights fromCity;
	private Flights toCity;
	private Flights flightDate;
	private Flights flightTime;
	private Flights unitCost;
	private float subtotal;
	private boolean bookingStatus;
	private User userID;
	
	public FlightOrder(){
	}
	public FlightOrder(int orderNumber, Flights flightId, Date bookingDate, int[] passengersSeatNumbers, String[] passengersFullNames, 
			int[] passengersSsn, Date[] passengersDateOfBirth, Flights fromCity, Flights toCity, Flights flightDate,
			Flights flightTime, Flights unitCost, float subtotal, boolean bookingStatus, User userID){
		this.orderNumber = orderNumber;
		this.flightId = flightId;
		this.bookingDate = bookingDate;
		this.passengersSeatNumbers = passengersSeatNumbers;
		this.passengersFullNames = passengersFullNames;
		this.passengersSsn = passengersSsn;
		this.passengersDateOfBirth = passengersDateOfBirth;
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.unitCost = unitCost;
		this.subtotal = subtotal;
		this.bookingStatus = bookingStatus;
		this.userID = userID;
	}
	
	public FlightOrder(Flights flightId, Flights flightDate, Flights flightTime, Flights fromCity, Flights toCity) {
		this.flightId = flightId;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.fromCity = fromCity;
		this.toCity = toCity;
	}
	public void displayAvailableSeats() {
	}
	public void displayCheckout() {
	}
	public void placeOrder(int flightId) {
		int ticketNum = generateTicket();
		//FlightOrder toBook = ;//retrieve flightID from the DB
		FlightOrder booking = new FlightOrder(orderNumber, LoginPageController.currentUser.getUserID(),flightId, /** toBook.toCity(),*/
				LoginPageController.currentUser.getUserName()); //has error becuz toBook needs to connect to DB
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