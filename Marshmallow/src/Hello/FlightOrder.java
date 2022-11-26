package Hello;
import java.util.Date;
public class FlightOrder {
	
	int orderNumber;
	int flightId;
	Date bookingDate;
	int[] seatNumbers;
	String[] passengersFullNames;
	int[] passengersSsn;
	Date[] passengersDateOfBirth;
	String fromCity;
	String toCity;
	Date flightDate;
	int flightTime;
	float unitCost;
	float subtotal;
	boolean bookingStatus;
	String firstName = Customer.firstName;
	String lastName = Customer.lastName;
	String email = Customer.email;
	int ssn = Customer.ssn;
	
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
}