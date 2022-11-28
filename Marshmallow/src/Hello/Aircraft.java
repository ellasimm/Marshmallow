package Hello;
public class Aircraft {
	
	private int aircraftId;
	private String aircraftMake;
	private String aircraftModel;
	private String airlineName;
	private int aircraftCapacity;
	
	public Aircraft() {
	}
	public Aircraft(int aircraftId, String aircraftMake, String aircraftModel, String airlineName, int aircraftCapacity) {
		this.aircraftId = aircraftId;
		this.aircraftMake = aircraftMake;
		this.aircraftModel = aircraftModel;
		this.airlineName = airlineName;
		this.aircraftCapacity = aircraftCapacity;
	}
}