import java.util.Date;
import java.util.GregorianCalendar;
import java.io.*;

public class OnlineAccount extends Person{

	GregorianCalendar cal = new GregorianCalendar();
	
	private  String username;
	private  String password;
	private  String lastLogin;
	boolean loggedIn;
	
	
	public OnlineAccount() {
		super("");
		username = "";
		password = "";
		
	}
	
	OnlineAccount(String name, String login, String password) {
		super(name);
		username = login;
		this.password = password;
	}

	public  String getUsername() {
		return username;
	}

	public  String getPassword() {
		return password;
	}

	public  String getLastLogin() {
		return lastLogin;
	}

	public boolean getLoggedIn() {
		return loggedIn;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
	//do this in the main check for password validy	//if (CheckPassword.checkPassword(password);
			//then it's ok to the password
		//CheckPassword.checkPassword(password);
		
		this.password = password;
		
	}

	//public void setLoggedIn(boolean loginState) {
		//loggedIn = loginState;
		
		//set this in method for loginstate
	//}
	
	public void setLoggedIn(boolean trueOrFalse) {

        Date dateAndTime; //Declare a "Date" object

 if (trueOrFalse == true) {
       dateAndTime = new Date(); //Will create a Date object with the current date and time.

      lastLogin = dateAndTime.toString(); //Will store the Date and time as a string
 }

       loggedIn = trueOrFalse; //Set loggedIn to either true or false (whatever was sent in via the parameter)
}

	public void setLastLogin(String lastLogin) {
		GregorianCalendar cal = new GregorianCalendar();
		//lastLogin.
		this.lastLogin = lastLogin;
		
	}
	
	public boolean equals(OnlineAccount account2) {
		return this.hasSameName(account2) &&
			   this.username.equals(account2.username) &&
			   this.password.equals(account2.password);
	}
	
	public void printInfo() {
		System.out.println("name: " + getName());
		System.out.println("username: " + getUsername());
		System.out.println("password: " + getPassword());
	}
	
}
