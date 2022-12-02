package FlightCode;  //FINISHED ALL THE CODE IS WRITTEN

public class Exceptions extends Exception{

	public Exceptions(String str) {
		super(str);
	}
	
	public static void checkRegestration(User user) {
		
		try {
			
			String ssn = "" + user.getSsn();
			
			if (String.valueOf(ssn).length() != 9) {
				throw new Exception("Invalid Social Security Number");
			}
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	
}
