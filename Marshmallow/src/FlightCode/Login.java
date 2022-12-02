package FlightCode;

import Database.LoginDB;

public class Login {
	private boolean checkLoginInfo;
	private String userName;
	private String password;
	
	public Login() {
		
	}
	public Login(String userName, String password) {
		this.userName = userName;
		this.password = password;
		this.checkLoginInfo = false ;
	}
	public void checkPassword(String pass) {
		if (this.getPassword().equals(pass)) {
			setCheckLoginInfo(true);
		}
		else {
			setCheckLoginInfo(false);
		}
	}
	public boolean performLogin() {
		LoginDB login = new LoginDB();
		String checkLogin = login.confirmLogin(getUserName());
		checkPassword(checkLogin);
		return checkLoginInfo;
	}
	public boolean isCheckLoginInfo() {
		return checkLoginInfo;
	}
	public void setCheckLoginInfo(boolean checkLoginInfo) {
		this.checkLoginInfo = checkLoginInfo;
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
	

}
