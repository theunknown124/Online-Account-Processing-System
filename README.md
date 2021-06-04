# Online-Account-Processing-System
Here is the description of the project:
Step 1:
Create a class to validate the creation of passwords based on the exercise found here:  Passwords.pdf download
Step 2:
Create a class called OnlineAccount according to the specifications found here:  Password-Project-UML.pdf download
Derive the class OnlineAccount from the Person class: Person.java download
Step 3:
Write a program called (LoginProcessor.java) that make use of the classes created in steps 1 and 2  that simulates a system login process. Prompt the user with a screen similar to following:

--------------------------------

1. Login to the system

2. Create an Account

3. Change Password

-------------------------------

NOTE: You will have to maintain a file that contains login information (name, login name, password, last login). When an account is created append it's information to that file.

If the user the chooses option 1 present them with the following login screen
-------------------LOGIN TO SYSTEM----------------------------

Login name:

...

Password:

-------------------------------------------------------------------

Allow them 3 attempts to enter the proper credentials. If they exceed the 3 attempts issue the message "Your account has been locked!" (Don't really lock them out of the account. Just issue the message).
If the user tries to login with a login name that doesn't exist issue the error message: "Non-existing Account!" and then just return to the login screen.
If the user logs in successfully present them with the message "Welcome back NAME!" Last successful login mm/dd/yy hh:mm:ss
 

If the user the chooses option 2 present them with the following screen
-----------------CREATE ACCOUNT------------------------------

Create Username:

...

Create Password:

---------------------------------------------------------------------

You must make sure the Username doesn't already exist. If it does issue an error message indicating such and just re-display the prompt "Create Username:"
When the user creates a password used tools developed above (described in password.pdf) which will validate password creation.
If the user the chooses option 3 present them with the following login screen
-------------------CHANGE PASSWORD----------------------------

Login name:

...

Password:

---------------------------------------------------------------------

If the user chooses to change their password. First, prompt them to login as usual (allow the typical 3 attempts).
If the user passes the login test then prompt them to change their password using the rules as describe in the file below (password.pdf). However, one additional restriction:

If the user tries to reset their password with a password that they already have used then let issue an error message: "Password cannot be one that was used previously." (NOTE: This only applies to the most recent password. It will be extra credit {2% extra} to check for a history of past passwords). Create a special exception to be thrown for this situation called "PreviousPasswordException." If this exception is thrown just catch it and allow the user another attempt.
Maintain a  file called "accountdata.dat" which will save all login and password information.

 

Be sure to submit ALL the files that pertain to this overall project. Otherwise, if a piece is missing I will not be able to test it. 
