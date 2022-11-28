package FlightCode;

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
	private String securityAnswer;
	private int userID;
	private String address;
	private int zipCode;
	private String state;
	private int ssn;
	
	public User() {
	}
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public User(String userName, String password, String firstName, String lastName,
	            String email, String securityQuestion, String securityAnswer) {
		this.userName = userName; 
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		
	}
	
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
		 Scanner input = new Scanner(System.in);
         
	        System.out.println("Enter User Name: ");
	        this.userName = input.nextLine();
			System.out.println("Enter password: ");
			this.password = input.nextLine();
			
			userName = userName.trim();
			password = password.trim();
			
	        String str = userName +" "+ password;
	         
	        try {
	             
	              File f = new File("User.txt");
	              Scanner scan = new Scanner(f);
	              int flag=0;
	              while (scan.hasNextLine()) {
	                String data = scan.nextLine();
	                if(data.equals(str)) {
	                    System.out.println("Login Successful");
	                  
	                    flag=1;
	                    break;
	                }
	              }
	                if(flag==0)
	                {
	                    System.out.println("Login Failed");
	                    System.out.println("1. Registration. ");
	                    System.out.println("2. Login. ");
	                     
	                    System.out.println("Enter your Choice");
	                    int choice=input.nextInt();
	                    if(choice==1)
	                    {
	                        this.register();
	                    }
	                    else if(choice==2)
	                    {
	                        this.logIn();
	                    }
	                    else
	                    {
	                        System.out.println("Enter proper choice.");
	                    }
	                }
	               
	              scan.close();
	            }  catch (FileNotFoundException ex) {
	              
	              System.out.println("Error.");
	              ex.printStackTrace();
	            }
	         
	        input.close();
	}
	public void logOut(){
		
	}

	public void goMainMenu() {
		/**needs to be created in the GUI*/
	}
	public void bookFlight() {
		/** this is similar to flightOrder class*/
	}
	public void deleteFlight() {
	}
	public void retrievePassword() {
		System.out.println(securityQuestion);
		Scanner input = new Scanner(System.in);
		String sa = input.nextLine();
		if (sa.equals(securityAnswer)) {
			System.out.println("Your password is "+ getPassword());
		}
		else {
			System.out.println("The answer to the security question is incorrect.");
		}
		/**
		 * should this be in customer and admin so that we call call their specific accounts to retrive. 
		 * Or does this make sense?
		 */
	}
	public void searchFlight() {
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
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
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
}