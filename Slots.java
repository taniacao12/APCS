// Tania Cao
// APCS1 pd1
// HW26 -- Shmoney
// 2017-11-07

public class Slots {
    // instance variables
    private static final String[] FRUITS = {
	"lime", "lime", "lime", 
	"lemon", "lemon", "lemon", 
	"cherry", "cherry", "cherry", 
	"orange", "orange", "orange", 
	"grapefruit", "grapefruit", "grapefruit", 
	"tangerine", "tangerine", "tangerine", 
	"ugli", "ugli", "ugli",
	"peach", "peach", "peach"
    };
    
    private String[] _fruits; //to be init'd by each instance
    
    /*=====================================
      Slots() -- default constructor
      pre:  constant array FRUITS exists, has been initialized
      post: mutable array _fruits contains same elements as FRUITS
      =====================================*/
    public Slots() {
        //allocate memory for _fruits based on size of FRUITS:
	_fruits = new String[FRUITS.length];
	//copy elements of FRUITS into _fruits:
        int index = 0;
	while (index < FRUITS.length) {
	    _fruits[index] = FRUITS[index];
	    index += 1;
	}
	String[][] Slot = new String[][] {Slot1, Slot2, Slot3}; // create array of slots
	int s = 0;
	while (s < 3) {
	    Slot[s] = _fruits;
	    s += 1;
	}
    }
    
    /*=====================================
      String toString() -- overrides inherited toString()
      pre:  
      post: returns String of elements in slots 0 thru 2, separated by tabs
      =====================================*/
    public String toString() {
	String s0 = "Slot 0: ";
	String s1 = "Slot 1: ";
	String s2 = "Slot 2: ";
	int index = 0;
	while (index < _fruits.length) {
	    if (index != _fruits.length - 1) {
		s0 += Slot[0][index] + ",";
		s1 += Slot[1][index] + ",";
		s2 += Slot[2][index] + ",";
	    }
	    else {
		s0 += Slot[0][index] + "\n";
		s1 += Slot[1][index] + "\n";
		s2 += Slot[2][index];
	    }
	    index += 1;
	}
	return "\n" + s0 + s1 + s2;
    }


    /*=====================================
      void swap(int,int) -- array swap util fxn
      pre:  _fruits array exists
      post: elements at indices i, j are swapped
      =====================================*/
    private void swap (int i,int j) {
	_fruits[i] = _fruits[j];
	_fruits[j] = _fruits[i];
    }


    /*=====================================
      void spinOnce() -- simulate a pull of the slot machine lever
      pre:  _fruits array exists
      post: randomized order of elements in _fruits array
      =====================================*/
    public void spinOnce() {
	for (int i = 0; i < _fruits.length; i += 1) {
	    int index = (int) (Math.random() * FRUITS.length);
	    Slot[0][i] = _fruits[index];
	    index = (int) (Math.random() * FRUITS.length);
	    Slot[1][i] = _fruits[index];
	    index = (int) (Math.random() * FRUITS.length);
	    Slot[2][i] = _fruits[index];
    	}
    }


    /*=====================================
      boolean jackpot() -- checks for a winning combo
      pre:  _fruits is existing array
      post: returns true if first 3 slots represent winning combo,
      false otherwise
      =====================================*/
    public boolean jackpot() {
	if ((Slot[0] == Slot[1]) && (Slot[0] == Slot[2])) {
	    return true;
	}
	return false;
    }


    /*=====================================
      boolean miniWin() -- checks for a winning combo
      pre:  _fruits is existing array
      post: returns true if first 3 slots represent winning combo,
      or if first 3 slots mutually distinct, 
      false otherwise
      =====================================*/
    public boolean miniWin() {
	if ((Slot[0] != Slot[1]) && (Slot[0] != Slot[2])) {
	    return true;
	}
	return false;
    }

    //main() method for testing
    public static void main (String[] args) {
	//usage: move bar below down 1 line at a time to test functionality...
	Slots machine01 = new Slots();
	Slots machine02 = new Slots();

	//test to verify slot machines function indepently
	System.out.println("Machine01 initial state:\t" + machine01);
	System.out.println("Machine02 initial state:\t" + machine02);
	System.out.println();
	
	System.out.println("\nSpinning machine01...\n");

	machine01.spinOnce();
	
	System.out.println();
	System.out.println("Machine01 state:\t" + machine01.toString());
	System.out.println("Machine02 state:\t" + machine02.toString());
	System.out.println();
	
	//test gamble-until-you-win mechanism

	System.out.println("Preparing to spin until a mini win! . . .");
	System.out.println("------------------------------------");

	//if you haven't won, spin again until you win!
	while( machine01.miniWin() == false ) {
	    System.out.println("Your spin..." + "\t" + machine01);
	    System.out.println("LOSE\n");
	    machine01.spinOnce();
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println( "====================================" );
	System.out.println( "Your spin..." + "\t" + machine01 );
	System.out.println( "WIN\n" );



	System.out.println( "Preparing to spin until...jackpot! . . ." );
	System.out.println( "------------------------------------" );

	//if you haven't won, spin again until you win!
	while( machine01.jackpot() == false ) {
	    System.out.println( "Your spin..." + "\t" + machine01 );
	    System.out.println( "LOSE\n" );
	    machine01.spinOnce();
	}

	System.out.println( "====================================" );
	System.out.println( "Your spin..." + "\t" + machine01 );
	System.out.println( "JACKPOT!\n" );
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	    }//end main

}//end class Slots
