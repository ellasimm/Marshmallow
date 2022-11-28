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
	public void register() {
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