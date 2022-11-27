package Hello;
import java.util.Date;
public class FlightOrder {
	
	private int orderNumber;
	private int flightId;
	private Date bookingDate;
	private int[] seatNumbers;
	private String[] passengersFullNames;
	private int[] passengersSsn;
	private Date[] passengersDateOfBirth;
	private String fromCity;
	private String toCity;
	private Date flightDate;
	private int flightTime;
	private float unitCost;
	private float subtotal;
	private boolean bookingStatus;
	private String firstName = Customer.firstName;
	private String lastName = Customer.lastName;
	private String email = Customer.email;
	private int ssn = Customer.ssn;
	
	public FlightOrder(){
	}
	public FlightOrder(int orderNumber, int flightId, Date bookingDate, int[] seatNumbers, String[] passengersFullNames, 
			int[] passengersSsn, Date[] passengersDateOfBirth, String fromCity, String toCity, Date flightDate,
			int flightTime, float unitCost, float subtotal, boolean bookingStatus){
		this.orderNumber = orderNumber;
		this.flightId = flightId;
		this.bookingDate = bookingDate;
		this.seatNumbers = seatNumbers;
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
	}
	public void displayAvailableSeats() {
	}
	public void displayCheckout() {
	}
	public void placeOrder() {
	}
	public void saveCustomerActivity() {
	}
	public void goMainMenu() {
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public int[] getSeatNumbers() {
		return seatNumbers;
	}	
	public String[] getPassengersFullNames() {
		return passengersFullNames;
	}	
	public int[] getPassengersSsn() {
		return passengersSsn;
	}
	public Date[] getPassengersDateOfBirth() {
		return passengersDateOfBirth;
	}
	public String setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String setEmail(String email) {
		this.email = email;
	}
	public int[] setSeatNumbers(int[] seatNumbers) {
		this.seatNumbers = seatNumbers;
	}	
	public String[] setPassengersFullNames(String[] passengersFullNames) {
		this.passengersFullNames = passengersFullNames;
	}	
	public int[] setPassengersSsn(int[] passengersSsn) {
		this.passengersSsn = passengersSsn;
	}
	public Date[] setPassengersDateOfBirth(Date[] passengersDateOfBirth) {
		this.passengersDateOfBirth = passengersDateOfBirth;
	}
}