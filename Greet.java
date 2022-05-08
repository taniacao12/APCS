public class Greet {
    public static void main( String[] args ){
	String greeting;

	BigSib richard = new BigSib("Word up");
	BigSib grizz = new BigSib("Hey ya");
	BigSib dotCom = new BigSib("Sup");
	BigSib tracy = new BigSib("Salutations");

	greeting = richard.greet("freshman");
	System.out.println(greeting); // prints "Word up freshman"
	
	greeting = tracy.greet("Dr. Spaceman");
	System.out.println(greeting); // prints "Salutations Dr.Spaceman"
	
	greeting = grizz.greet("Kong Fooey");
	System.out.println(greeting); // prints "Hey ya Kong Fooey"
	
	greeting = dotCom.greet("mom");
	System.out.println(greeting); // prints "Sup mom"

	System.out.println(richard.helloMsg); // prints "Word up freshman"
    }
}
