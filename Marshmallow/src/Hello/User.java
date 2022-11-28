package Hello;
public class User {
	
	private String userName; 
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String securityQuestion;
	
	public User() {
	}
	public User(String userName, String password, String firstName, String lastName,
	            String email, String securityQuestion) {
		this.userName = userName; 
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.securityQuestion = securityQuestion;
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
	}
	public void logOut(){
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
	public void setUserName(String userName){
		userName = userName;
	}
	public void setPassword(String password) {
		password = password;
	}
	public void setFirstName(String firstName) {
		firstName = firstName;
	}
	public void setLastName(String lastName) {
		lastName = lastName;
	}
	public void setEmail(String email) {
		email = email;
	}
	public void setSecurityQuestion(String securityQuestion) {
		securityQuestion = securityQuestion;
	}
}