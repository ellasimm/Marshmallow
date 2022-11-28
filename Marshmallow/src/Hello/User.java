package Hello;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {
	
	private String userName; 
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String securityQuestion;
	
	public void register() throws FileNotFoundException{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter username: ");
		this.userName = input.nextLine();
		System.out.println("Enter password: ");
		this.password = input.nextLine();
		System.out.println("Confirm Password: ");
		String confirmPassword = input.nextLine();
		
		userName = userName.trim();
		password = password.trim();
		confirmPassword = confirmPassword.trim();
		
		String str = userName + " " + confirmPassword;
		if (password.equals(confirmPassword)) {
			File f = new File("User.txt");
			Scanner scan = new Scanner(f);
			int flag = 0;
			while(scan.hasNextLine()) {
				String data = scan.nextLine();
				if(data.equals(str)) {
					System.out.println("Already Registered.");
					flag = 1;
					System.out.println("1. Registeration");
					System.out.println("2. LogIn");
					
					System.out.println("Enter your choice: ");
					int choice = input.nextInt();
					if(choice == 1) {
						this.register();
					}
					else if (choice == 2){
						this.logIn();
					}
					else {
						System.out.println("Enter proper choice.");
					}
					break;
				}
				scan.close();
				
				if (flag == 0) {
					try {
						BufferedWriter out = new BufferedWriter(new FileWriter("User.txt", true));
						out.write(userName +" "+ password+ "\n");
						out.close();
					}catch(IOException ex) {
						System.out.println("Exception happened" + ex);
					}
					System.out.println("Successfully Registered.");
					System.out.println("Please Login");
					this.logIn();
				}
				
			}
		}
		input.close();
		
	}
	public void logIn() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter username: ");
		this.userName = in.nextLine();
		System.out.println(userName);
		System.out.println("Enter password: ");
		this.password = in.nextLine();
		System.out.println(password);
		
		userName = userName.trim();
		password = password.trim();
		String str = userName + " "+ password;
		
		try {
			File f = new File("User.txt");
			Scanner scan = new Scanner (f);
			int flag  = 0;
			while(scan.hasNextLine()) {
				String data = scan.nextLine();
				if(data.equals(str)) {
					System.out.println("Login Successful");
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println("Login failed");
				System.out.println("1. Registeration");
				System.out.println("2. LogIn");
				
				System.out.println("Enter your choice: ");
				int choice = in.nextInt();
				
				if(choice == 1)
					this.register();
				else if(choice == 2)
					this.logIn();
				else
					System.out.println("Enter proper choice.");
			}
			scan.close();
		}catch(FileNotFoundException ex) {
			System.out.println("Error occured.");
			ex.printStackTrace();
		}
		in.close();
	}
	public void logOut(){
	}
	public void setAddress() {
	}
	public void setZip() {
	}
	public void setState() {
	}
	public void goMainMenu() {
	}
	public void bookFlight() {
	}
	public void deleteFlight() {
	}
	public void retrievePassword() {
	}
	public void searchFlight() {
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
     
}
