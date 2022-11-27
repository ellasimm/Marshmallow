package Hello;
import java.util.Date;
public class FlightOrder {
	
	private int orderNumber;
	private Flights flightId;
	private Date bookingDate;
	private int[] seatNumbers;
	private String[] passengersFullNames;
	private int[] passengersSsn;
	private Date[] passengersDateOfBirth;
	private Flights fromCity;
	private Flights toCity;
	private Flights flightDate;
	private Flights flightTime;
	private Flights unitCost;
	private float subtotal;
	private boolean bookingStatus;
	private Customer firstName;
	private Customer lastName;
	private Customer email;
	private Customer ssn;
	
	public FlightOrder(){
	}
	public FlightOrder(int orderNumber, Flights flightId, Date bookingDate, int[] seatNumbers, String[] passengersFullNames, 
			int[] passengersSsn, Date[] passengersDateOfBirth, Flights fromCity, Flights toCity, Flights flightDate,
			Flights flightTime, Flights unitCost, float subtotal, boolean bookingStatus){
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
	public Customer getFirstName() {
		return firstName;
	}
	public Customer getLastName() {
		return lastName;
	}
	public Customer getEmail() {
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
	public Customer setFirstName(Customer firstName) {
		return firstName;
	}
	public Customer setLastName(Customer lastName) {
		return lastName;
	}
	public Customer setEmail(Customer email) {
		return email;
	}
	public int[] setSeatNumbers(int[] seatNumbers) {
		return seatNumbers;
	}	
	public String[] setPassengersFullNames(String[] passengersFullNames) {
		return passengersFullNames;
	}	
	public int[] setPassengersSsn(int[] passengersSsn) {
		return passengersSsn;
	}
	public Date[] setPassengersDateOfBirth(Date[] passengersDateOfBirth) {
		return passengersDateOfBirth;
	}
}