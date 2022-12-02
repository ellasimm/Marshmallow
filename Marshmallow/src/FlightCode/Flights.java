package FlightCode;    //FINISHED ALL THE CODE IS WRITTEN

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Date;
=======
import java.time.LocalDate;
import java.util.ArrayList;
>>>>>>> branch 'master' of https://github.com/ellasimm/Marshmallow.git

public class Flights implements Comparable<Flights>{
	
	private int flightId;
<<<<<<< HEAD
	private String[] cities ;
=======
>>>>>>> branch 'master' of https://github.com/ellasimm/Marshmallow.git
	private String fromCity;
	private String toCity;
<<<<<<< HEAD
	private Date[] flightDate;
	private int flightTime;
	private float unitCost;
=======
	private int numSeats;
	private String flightDate;
	private String landingTime;
	private String takeOffTime;
	private ArrayList<User> passengers = new ArrayList<>();
	private String returnFlight;
>>>>>>> branch 'master' of https://github.com/ellasimm/Marshmallow.git
	
		
	public Flights() {
	}
<<<<<<< HEAD
	public Flights(int flightId, String fromCity, String toCity,
			Date flightDate, int flightTime, float unitCost) {
=======
	
	public Flights(int flightId, String fromCity, String toCity, int numSeats,
			String flightDate, String landingTime, String takeOffTime, String returnFlight) {
		
>>>>>>> branch 'master' of https://github.com/ellasimm/Marshmallow.git
		this.flightId = flightId;
		this.fromCity = fromCity;
		this.toCity = toCity;
<<<<<<< HEAD
=======
		this.numSeats = numSeats;
>>>>>>> branch 'master' of https://github.com/ellasimm/Marshmallow.git
		this.flightDate = flightDate;
		this.landingTime = landingTime;
		this.takeOffTime = takeOffTime;
		this.returnFlight = returnFlight;	
	}
	

	public static void createFlight(String fromCity, String toCity, int numSeats, String flightDate, 
										String landingTime,  String takeOffTime,  String  returnFlight) {
		
		int num = createFlightNum();
		
		Flights flight = new Flights(num, fromCity, toCity, numSeats, flightDate, landingTime,  takeOffTime, returnFlight);
		
		//InsertDBO.insertFlight(flight);
		//if(InsertDB.success)  {
		//		AlertBox.Display("Flight Created. The Flight ID is: " + num);
		//}else {
		//		AlertBox.Display("Try Again, Make Sure All Fields Are Filled");
		//}
	}
	
	
	public  String getPass(ArrayList<User> passengers) {
		
		String pass = "";
		
		for (int i = 0; i < passengers.size(); i++) {
			
			User user = passengers.get(i);
			pass  += user;
			
		}		
		
		return pass;	
	}
	
	
	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}
<<<<<<< HEAD
	public Date getFlightDate() {
=======

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public String getFlightDate() {
>>>>>>> branch 'master' of https://github.com/ellasimm/Marshmallow.git
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(String landingTime) {
		this.landingTime = landingTime;
	}

	public String getTakeOffTime() {
		return takeOffTime;
	}

	public void setTakeOffTime(String takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

	public String getReturnFlight() {
		return returnFlight;
	}

	public void setReturnFlight(String returnFlight) {
		this.returnFlight = returnFlight;
	}

	public static int createFlightNum() {
		
		int num = (int)(Math.random() * 99999);
		return num;
	}
	
	
	@Override
	public String toString() {
		return "Flight ID: " + this.getFlightId() + "/nDeparture Time: " + this.getTakeOffTime() 
					+ "/nDeparture City: " + this.getFromCity() + "/nArrival Time: " + this.getLandingTime()
					+ "/nArrival City: " + this.getToCity();
	}
<<<<<<< HEAD
	public String[] setCities() {
		return cities;
	}
	public String setFromCity() {
		return fromCity;
	}
	public String setToCity() {
		return toCity;
	}
	public Date setFlightDate() {
		return flightDate;
	}
	public int setFlightTime() {
		return flightTime;
	}
	public float setUnitCost() {
		return unitCost;
=======
	
	
	@Override
	public int compareTo(Flights o) {
		if (flightId == o.flightId) {
			return 0;
		}
		else {
			return -1;
		}
>>>>>>> branch 'master' of https://github.com/ellasimm/Marshmallow.git
	}
	
}
