public class KeyboardMain {
    public static void main (String[] args) {
	Keyboard k = new Keyboard();
	System.out.println("Error Count: " + k.getErrorCount());
	System.out.println("Input Errors In Standard Outpot: " + k.getPrintErrors());
    }
}
