public class StringTwo {
    public static String doubleChar (String str) {
	int index = 0;
	String retStr = "";
	while (index < str.length()) {
	    retStr += str.charAt(index) + str.charAt(index);
	}
	return retStr;
    }

    public static void main (String[] args) {
	System.out.println(doubleChar("The"));
	System.out.println(doubleChar("AAbb"));
	System.out.println(doubleChar("Hi-There"));
    }
}
