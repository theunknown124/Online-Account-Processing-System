tiimport java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LoginProcessor {
	
	static void PrintArrayList(ArrayList<OnlineAccount> onlineAcctList) {
		int i;
		
		for (i =0; i < onlineAcctList.size(); ++i) {
			onlineAcctList.get(i).printInfo(); System.out.println();
		}
	}

	
	
	public static void main(String[] args) {
		
		String fileName = "accountdata.dat";
		Scanner inputStream = null;
		Scanner keyboard = new Scanner(System.in);
		int choice; // number of choices
		ArrayList <OnlineAccount> onlineAcctList = new ArrayList <OnlineAccount>();
		//GregorianCalendar lastLogin = logi ;
		
		int attempt = 0; //keeps track of attempts that the user used during login option
		
		
		GregorianCalendar calendar = new GregorianCalendar();
		String lastLogin = calendar.get(Calendar.MONTH) + "/"
				+ calendar.get(Calendar.DAY_OF_MONTH) + "/" 
				+ calendar.get(Calendar.YEAR) + " " 
				+ calendar.get(Calendar.HOUR) + ":" 
				+ calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
		
		try {
			File file = new File (fileName);
			Scanner filereader = new Scanner(file);
			int count = 0;
			while(filereader.hasNextLine()){
				String name = filereader.nextLine();
				String login = filereader.nextLine();
				String password = filereader.nextLine();
				String lastlogin = filereader.nextLine();
				//String[] split = line.split(" ");
				//onlineAcctList.add(new OnlineAccount(split[0],split[1], split[2]));
				OnlineAccount temp = new OnlineAccount(name,login,password);
				//System.out.print("Temp Info=");
				//System.out.println(temp);
				onlineAcctList.add(temp);
				count++;
			}
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		
		
		
		/////////////////////////////////
		
		///////////////////////////////////////////
	
	
	do {
		choice = SystemLoginProcess();
		switch (choice) {
		
		case 1: 	System.out.println("-------------------LOGIN TO SYSTEM----------------------------");
					boolean loginState = false;
					
					
			//boolean loginState = true;
			do {
						System.out.println("Login name: ");
						//loginState = false;
					
					String login = keyboard.next(); // user puts in username
					
					
					System.out.println("Password:");
					String passwordFind = keyboard.next();
					boolean  goodLogin =false;
					int j;
					int indexfound =0;
					for (j = 0; j < onlineAcctList.size(); j++) {
						if ( onlineAcctList.get(indexfound).getUsername().equals(login) && 
								onlineAcctList.get(indexfound).getPassword().equals(passwordFind)) 
							goodLogin = true;
						indexfound = j;
						
							
					}
						
						if(goodLogin)
						{
							
							//for (int j = 0; j < onlineAcctList.size(); j++) {
							System.out.println("Welcome back " + onlineAcctList.get(indexfound).getName() +  "!");
							
							//loginState = true;
							//System.out.println("\nLast login: " + calendar.get(Calendar.MONTH) + "/"
												//+ calendar.get(Calendar.DAY_OF_MONTH) + "/" 
												//+ calendar.get(Calendar.YEAR) + "/" + " " 
												//+ calendar.get(Calendar.HOUR) + ":" 
												//+ calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
							
							onlineAcctList.get(indexfound).setLoggedIn(true);
							onlineAcctList.get(indexfound).setLastLogin(lastLogin);
							System.out.println("Last successful login " + onlineAcctList.get(indexfound).getLastLogin());
							//loginState = true;
							
							//}
							break;
							
						}	
						
						else if (!goodLogin)
							{
							
							System.out.println("\nNon-existing Account!");
							attempt++;
							//System.out.println("\nAttempt counter:" + attempt);
							if(attempt == 3) {
								System.out.println("Your account has been locked!");
								break;
							}
							continue;
							
							
							}
					/*	
						else if (!(OnlineAccount.getUsername().equals(login))){
							System.out.println("\nNon-existing Account!");
							attempt++;
							System.out.println("\nAttempt counter:" + attempt);
							if(attempt == 3) {
								break;
							}
							continue;
							
							
						}
						else if (!(OnlineAccount.getPassword().equals(passwordFind))){
							System.out.println("\nNon-existing Account!");
							attempt++;
							System.out.println("\nAttempt counter:" + attempt);
							if(attempt == 3) {
								break;
							}
							continue;
							
						}
						*/
						//System.out.println("Attempt counter:" + attempt);
						
						
					
						
						
					}while(attempt < 4 || loginState != true);	
					
				
					
					
					attempt = 0; //setting attempt back to zero
					//System.out.println("Attempt counter:" + attempt); //just see if attempt breaks the while loop

					//System.out.println(loginState);
					break;
				
					
				
			////////////////////////////////////////////////////////////////
	
		
		case 2: System.out.println("-----------------CREATE ACCOUNT------------------------------");
				String newUserName = "";
				String newPassWord = "";
				String newName = "";
				boolean loginExist = false;
				
;
				
				do {

					System.out.println("Create Username:");

					//
					//OnlineAccount i = onlineAcctList.get(j);
					newUserName = keyboard.next();

					int indexfound2 = 0;

					for (int j = 0; j < onlineAcctList.size(); j++) {
					
						if(newUserName.equals(onlineAcctList.get(indexfound2).getUsername()))
						{
							System.out.println("Username already exists!");
							loginExist = true;
							indexfound2 = j;
							//continue;
						}
					}
						
						if(!loginExist) 
						{
						System.out.println("Create Password:");

						newPassWord = keyboard.next();

						int code1 = CheckPassword.checkPassword(newPassWord);
						//System.out.println(code1);
						if (code1 != 0) {
					 		System.out.println("Password is invalid to use, Try a different new password");
					 		//break;
					 	}
						else {

						System.out.println("Enter your name: ");
						newName = keyboard.next();
						break;
						}
						
						}
					
					
				}while(loginExist != true);

				//temp.setName(newName2);
				
				
                OnlineAccount temp = new OnlineAccount(newName,newUserName,newPassWord);
                
                //OnlineAccount temp = new OnlineAccount();
                //temp.setName(newName2);
                //temp.setUsername(newUserName);
                //temp.setPassword(newPassWord);
                //temp.setName(newName2);
				onlineAcctList.add(temp);
				

				//writes new account to file
				

				
					
					
				break;    
		
				
			
				//////////////////////////////////////////////////////////////////
				
			
				
		
		case 3:  	System.out.println("-------------------CHANGE PASSWORD----------------------------");
					String login = "";
					String passwordFind = "";
					boolean loginState2 = false;
					
					
					do {
						System.out.println("Login name: ");
						//loginState = false;
					
					login = keyboard.next(); // user puts in username
					
					
					System.out.println("Password:");
					
					passwordFind = keyboard.next();
					
					boolean goodLogin = false;
					int indexfound3 = 0;
				
					for (int j = 0; j < onlineAcctList.size(); j++) {
						if ( onlineAcctList.get(j).getUsername().equals(login) && 
								onlineAcctList.get(j).getPassword().equals(passwordFind)) 
							goodLogin = true;
						indexfound3= j;
							
					}
						
						if(goodLogin)
						{
							
							//for (int j = 0; j < onlineAcctList.size(); j++) {
							System.out.println("Welcome back " + onlineAcctList.get(indexfound3).getName() +  "!");
							
							//loginState = true;
							onlineAcctList.get(indexfound3).setLoggedIn(true);
							//attempt = 3;
							//loginState = true;
	 +						//System.out.println(loginState);
							//}
							break;
							
						}	
						
						else if (!goodLogin)
							{
							
							System.out.println("\nNon-existing Account!");
							attempt++;
							//System.out.println("\nAttempt counter:" + attempt);
							if(attempt == 3) {
								break;
							}
							continue;
							
							
							}
					}while(attempt < 4 || loginState2 != true);
					
				 	
				//begins password change	
				
				 	String passwordChange = "";
				 	boolean passwordNew = false;
				 	int code2;
				 	
				 	do {
				 		
				 		
				 	
				 		System.out.println("Type in the password you would like to change it to:");
						 
					 	passwordChange = keyboard.next();// gets new user password
					 	
					 	
					 	//code2 = CheckPassword.checkPassword(passwordChange);
					 	
						
					 	
				 	
					 	for (int j = 0; j < onlineAcctList.size(); j++) {
					 		int indexfound4;
							indexfound4 = j;
					 		if(!(passwordChange.equals(onlineAcctList.get(indexfound4).getPassword()))) 
					 		{
					 			//if the password is different break loop
					 			passwordNew = true;
					 			break;
					 		}
	
				 		
					 		
					 		else {
					 		System.out.println("Password cannot be the one that was used previously.");
					 		//break;
					 		}
		
				 	
					 	}
				 	
				 		
				 	}while(passwordNew != true);
				 	//do while for Password validity
				 	boolean passwordHasChanged = false;
				 	
				 	do {
				 		
				 	code2 = CheckPassword.checkPassword(passwordChange);
				 	
					System.out.println(code2);
					if (code2 != 0) {
				 		System.out.println("Password is invalid to use, Try a different new password");
				 		//continue;
				 		//break;
				 	}
				 	
					else {

						System.out.println("Saving new password");
						passwordHasChanged = true;
						break;
						}
					System.out.println("Type in the password you would like to change it to:");
					 
				 	passwordChange = keyboard.next();// gets new user password
					
				 	}while(passwordHasChanged != true);
				 	//saving new password
				 	
				 	int indexfound3 =0;
				 	for (int j =0; j < onlineAcctList.size(); j++ ) {
				 		
						indexfound3 =j;
				 		
				 	}
				 	onlineAcctList.get(indexfound3).setPassword(passwordChange);
				 	
					
				 	
				 	
				 	
				 	break;
				 
				 	
					
					
					
				
			
			
		case 4:		System.out.println("Online Account System exiting");
	
		
		try
		{
			PrintWriter writer = new PrintWriter("accountdata.dat");
			int indexfound5 = 0;
			for (int j = 0; j < onlineAcctList.size(); j++) {
				//indexfound5 = j;
			//PrintWriter writer = new PrintWriter(fileName);
			//PrintWriter writer = new PrintWriter("accountdata.dat");
			writer.println(onlineAcctList.get(j).getName());
			writer.println(onlineAcctList.get(j).getUsername());
			writer.println(onlineAcctList.get(j).getPassword());
			writer.println(onlineAcctList.get(j).getLastLogin());
			
			
			
			}
			writer.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error opening the file " + fileName);
			
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
					System.exit(0);
					
					
					break;
					
		case 5: 	System.out.println("Testing File content output");
				
				
				
		 	
		 	
				PrintArrayList(onlineAcctList);
				break;
			
	
		
	}
		
	}while (choice != 4);
	
	
	
	

	

	}
////////////////////////////////////////////////////////////////////////
  static int SystemLoginProcess() {
	
	int ch = 0;
	boolean invalidChoice;
	Scanner keyboard = new Scanner(System.in);
	
	do {
		System.out.println("\n--------------------------------\n");
		System.out.println("1. Login to the system");
		System.out.println("2. Create An Account");
		System.out.println("3. Change Password");
		System.out.println("4. Save and exit");
		System.out.println("\n-------------------------------\n");
		
		System.out.println("Choice (1-4):");
		ch = keyboard.nextInt();
		
		invalidChoice = (ch < 1 || ch > 4);
		
		if (invalidChoice) {
			System.out.println("INVALID CHOICE! Please try again! (1-4)");
		}
		
	}while (invalidChoice);

	return ch;
}

}
