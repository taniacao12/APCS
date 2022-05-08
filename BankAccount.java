public class BankAccount {
    // instance variables
    public String name;
    private String password;
    private int pin;
    private int acctNum;
    private double balance;

    // default constructor
    public BankAccount() {
	balance = 0;
    }

    // constructor
    public BankAccount(double amt) {
	balance = amt;
    }
    
    // methods
    // sets the account's name
    public void setName (String newName) {
	name = newName;
    }

    // sets the account's password
    public void setPassword (String newPassword) {
	password = newPassword;
    }

    // sets the account's PIN
    public void setPin(int newPin){
	if ((newPin >= 1000) && (newPin <= 9998)) {
	    pin = newPin;
	}
	else {
	    pin = 9999;
	    System.out.println("ERROR: invalid PIN");
	}
    }

    // sets the account's number
    public void setAcctNum(int newAcctNum){
	if ((newAcctNum >= 100000000) && (newAcctNum <= 999999998)) {
	    acctNum = newAcctNum;
	}
	else {
	    acctNum = 999999999;
	    System.out.println("ERROR: invalid account number");
	}
    }

    // checks whether the given account number and password are correct
    public boolean authenticate (int acctnum,String pw) {
	if ((acctNum == acctnum) && (password == pw)) {
	    return true;
	}
	return false;
    }

    // deposits given amount into account
    public boolean deposit (double amt) {
	balance += amt;
	return true;
    }

    // withdraws given amount from account
    public boolean withdraw (double amt) {
	if (balance > amt) {
	    balance -= amt;
	    return true;
	}
	else {
	    System.out.println("ERROR: insufficient money in account");
	    return false;
	}
    }

    // overwrite the default toString()
    public String toString() {
	String s = "==================== \nAccount Info \n==================== \n";
	s += "Name: " + name + "\n";
	s += "Password: " + password + "\n";
	s += "PIN: " + pin + "\n";
	s += "Account Number: " + acctNum + "\n";
	s += "Account Balance: " + balance;
	return s;
    }

    // tests
    public static void main (String args[]) {
	// working bank account
	BankAccount ba = new BankAccount(1000);
	ba.setPassword("hello");
	ba.setAcctNum(123456789);
	ba.setName("Aidan");
	ba.setPin(2304);
	ba.authenticate(123456789,"hello");
	ba.deposit(200);
	ba.withdraw(800);
	System.out.println(ba);
	System.out.println();
	
	// bank account with errors
	BankAccount BA = new BankAccount(1000);
	BA.setPassword("hi");
	BA.setAcctNum(12345678);
	BA.setName("Bob");
	BA.setPin(000);
	BA.authenticate(123456789,"hello");
	BA.deposit(200);
	BA.withdraw(2000);
	System.out.println(BA);
    }
}
