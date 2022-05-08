public class Teller{
    public static void main (String[] args) {
	BankAccount info = new BankAccount();

	info.setName("Tania Cao");
	info.setPasswd("secret");
	info.setPin(1234);
	info.setAcctNum(234567890);
	info.setBalance(1000);
	System.out.println(info);
	
	info.deposit(750);
	System.out.println(info);

	info.withdraw(2000);
	System.out.println(info);

	info.withdraw(250);
	System.out.println(info);
	
	System.out.println("\nAuthenticatied: ");
	System.out.println(info.authenticate("idk",234567890));
	System.out.println(info.authenticate("secret",234567890));
    }
}
