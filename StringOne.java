public class StringOne {
    public static String helloName (String name) {
    	return "Hello " + name + "!";
    }

    public static String makeAbba (String a,String b) {
	return a + b + b + a;
    }

    public static void main (String[] args) {
	System.out.println("-----helloName Tests-----");
	System.out.println(helloName("Bob"));
	System.out.println(helloName("Alice"));
	System.out.println(helloName("X"));
	System.out.println("-----makeAbba Tests-----");
	System.out.println(makeAbba("Hi","Bye"));
	System.out.println(makeAbba("Yo","Alice"));
	System.out.println(makeAbba("What","Up"));
    }
}
