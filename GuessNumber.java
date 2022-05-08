// Tania Cao
// APCS1 pd1
// HW#48 -- Keep Guessing
// 2017-12-06

import cs1.Keyboard;

public class GuessNumber {
    // instance variables
    public int num;
    public int guess;
    public int lower;
    public int upper;

    // default constructor
    public GuessNumber() {
	num = (int) (Math.random() * 101);
	guess = 101;
	lower = 0;
	upper = 100;
    }
    
    public String toString() {
	String s = "Guess a number from " + lower + "-" + upper + ": ";
	return s;
    }

    // updates the values of lower and upper and tells the user wheter their guess was too high or too low
    public void updateBounds (int input) {
	if (input > num) {
	    System.out.println("Too high, try again...");
	    upper = input - 1;
	}
	else if (input < num) {
	    System.out.println("Too low, try again...");
	    lower = input + 1;
	}
    }

    // simulates a guessing round
    // returns true if guess is correct and false if not
    public boolean play() {
	System.out.println(toString());

	try {
	    guess = Keyboard.readInt();
	}
	catch (Exception e) {}
	
	if (guess != num) {
	    updateBounds(guess);
	    return false;
	}
	return true;
    }

    // test
    public static void main (String[] args) {
	GuessNumber game = new GuessNumber();
	
	int guesses = 3; 

	while (!game.play()) {
	    guesses ++;
	    game.play();
	}
	
	System.out.println("Correct! It took " + guesses + " guesses.");
    }
}
