package Hello;
import java.util.Scanner;

public class ReservationDemo {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Register or Login ? ");
		String registerOrLogin = input.nextLine();

		if (registerOrLogin != "Register" || registerOrLogin != "Login") {
			System.out.println("Invalid input!");
		}	
		if (registerOrLogin == "Register") {
		}
		if (registerOrLogin == "Login"){
		}
			
	} 
}
