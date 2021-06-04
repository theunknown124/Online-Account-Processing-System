
public class PasswordTester {

	public static void main(String[] args) {
		String[] passwords = {
				"abcd", // Wrong size
				"abcd_defg", // Has a non-recognized special character
				"abcdefgh", // All one case
				"Abcdefgh1", // Needs a second digit"Abcdefgh12", // Missing a special character
				"Abcdefgh%12" // Valid
		};
		for (int i=0; i < passwords.length; i++) {
			int code = CheckPassword.checkPassword(passwords[i]);
			display(code);
		}
	}
	public static void display(int code) {
		System.out.println(code);
	}
}