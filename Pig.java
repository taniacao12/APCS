// Team Awesome (Tania Cao, James Huang, Ahnaf Hasan)
// APCS1 pd01
// HW24 --  Imetay Otay Ineshay
// 2017-10-29

import java.util.scanner;

public class Pig {
    /*=====================================
      SUMMARY: Translate from English to Pig Latin
      PLAN:
      -> If the String start with a vowel, engToPig() uses beginsWithVowel() to return the String with "way" appended to the end
      -> If the String doesn't start with a vowel, engToPig() uses firstVowel() to move all consonants before the first vowel to the end of the String and then appends "ay" to the end.
      =====================================*/

    // instance variables
    public static String store = "";
    public static String punc = "";
    private static final String VOWELS = "aeiou";
    private static final string PUNCT = "!,.?@()/&$;:'=-_+$%^";
    
    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
            hasA("cat", "p") -> false
      =====================================*/
    public static boolean hasA (String w,String letter) {
	if ((w != null) && (letter.length() == 1)) {
	    int index = 0;
	    while (index < w.length()) {
		if (w.substring(index,index + 1).equals(letter)) {
		    return true;
		}
		else {
		    index += 1;
		}
	    }
	    return false;
	}
	else {
	    return false;
	}
    } // end hasA
    
    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel (String letter) {
	for (int index = 0; index < VOWELS.length(); index += 1) { // iterates through the array of vowels
	    if (hasA(letter,VOWELS.substring(index,index + 1))) { // if the letter is equal to one of the vowels
		return true; // then return true
	    }
	}
	return false; // if not, return false
    } // end isAVowel()
    
    
    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels (String w) {
	if (w == "") { // if w is a null string
	    return -1; // then return -1
	}
	else {
	    int count = 0;
	    for (int index = 0; index < w.length(); index += 1) { // iterate through w
		if (isAVowel(w.substring(index,index + 1))) { // call the isAVowell method to save time. If the letter being in question is a vowel
		    count += 1; // then add one to the vowel counter
		}
	    }
	    return count;
	}
    } // end countVowels()
    
    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
            hasAVowel("zzz") -> false
      =====================================*/
    public static boolean hasAVowel (String w) {
	return countVowels(w) > 0;
    } // end hasAVowel()
   
    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
    =====================================*/
    public static String allVowels (String w) {
	if (countVowels(w) == -1) { // if w is a null string
	    return "ERROR"; // then return "ERROR"
	}
	else if (countVowels(w) == 0) { // if w has no vowels
	    return "none"; // then return "none"
	}
	else {
	    String vowels = "";
	    for (int index = 0; index < w.length(); index += 1) { // iterate through w
		if (isAVowel(w.substring(index,index + 1))) { // if the letter in question is a vowel 
		    vowels += w.substring(index,index + 1); // then append concatinate it to vowels (string to be returned at the end of iteration)
		}
	    }
	    return vowels;
	}
    } // end allVowels()

    /*=====================================
      String firstVowel(String) -- returns a string with the first vowel
      pre:  w != null
      post: firstVowel("")         -> "none"
            firstVowel("zzz")      -> "none"
            firstVowel("meatball") -> "e"
    =====================================*/
    public static String firstVowel (String w) {
	for (int index = 0; index < w.length(); index += 1) { // iterates through w
	    if (isAVowel(w.substring(index,index + 1))) { // if a letter in question is identified as a vowel
		return w.substring(index,index + 1); // return the letter
	    }
	}
	return "none"; // if w has no vowels, return "none"
    } // end firstVowel()

    /*=====================================
      boolean beginsWithVowel(String) -- tells whether String begins with a vowel
      pre:  w != null, w.length() > 0
      post: beginsWithVowel("apple")  -> true
            beginsWithVowel("strong") -> false
    =====================================*/
    public static boolean beginsWithVowel (String w) {
	return isAVowel(w.substring(0,1));
    } // end beginsWithVowel()

    /*=====================================
      String storeCapital(String) -- stores the position of capital letters in the word
      pre: w.length() >0
      post: storeCapital("May") -> 0
      storeCapital("jUNE")-> 123
      =====================================*/
    public static String storeCapital(String w) {
	store = ""; // setting the instance var to empty string just in case
	for (int x = 0; x < w.length(); x++) {
	    if (w.substring(x,x + 1).equals(w.substring(x,x + 1).toUpperCase())) { // if the specific character is equal to its uppercase variant, then its uppercase!!!
		store += "" + x;
	    }
	}
	return store;//return the return value
    }
    
    /*=====================================
      String Lowercase(String) -- makes words lowercase for the pigLatin translator
       =====================================*/
    public static String Lowercase(String w) {
	return w.toLowerCase(); //returns lowercase version of string
    }
    
    /*=====================================
      String engToPig(String) -- returns a translation of String from English to Pig Latin
      pre:  w.length() > 0
      post: engToPig("apple")  -> "appleway"
            engToPig("strong") -> "ongstray"
            engToPig("java")   -> "avajay"
    =====================================*/
    public static String engToPig (String w) {
	//special cases:',-,y
	if (hasA(w,"'")) {
	    return engToPig(w.substring(0,w.indexOf("'"))) + "'" + engToPig(w.substring(w.indexOf("'") + 1));
	}//piglatinfy the area before the apostrophe and after
	else if (hasA(w,"-")) {
	    return engToPig(w.substring(0,w.indexOf("-")))+ "-" +engToPig(w.substring(w.indexOf("-") + 1));
	} //piglatinify both the antecedent and the precedent of the hyphenated word
	else if (hasA(w,"y") && hasAVowel(w)==false) {
	    return w.substring(w.indexOf("y")) + w.substring(0,w.indexOf("y")) + "ay";
	}//return the stuff after the y(basically treat it like a vowel)
	//all other cases
	else {
	    if (beginsWithVowel(w)) {
		return w + "way";
	    }
	    else {
		if (w.indexOf(firstVowel(w)) == -1) {
		    return w + "ay";
		}
		else {
		    return w.substring(w.indexOf(firstVowel(w))) + w.substring(0,w.indexOf(firstVowel(w))) + "ay";
		}
	    }
	}
    } // end engToPig()

    /*=====================================
      String haveCap(String) -- returns a boolean telling wether there is a capital letter in the String or not
      pre:  w.length() > 0
      post: haveCap("Apple")  -> "true"
            haveCap("STRONG") -> "true"
            haveCap("javac")   -> "false"
    =====================================*/
    public static boolean haveCap (String W) {
	for (int x = W.length(); x > 0; x--) {
	    if (W.substring(0,1).equals(W.substring(0,1).toUpperCase())) { // if W has a capital letter
	        return true; // then return true
	    }
	    else {
		return false; // if not, then return false
	    }
	}
	return false;
    } // end haveCap()
    
    /*=====================================
      String Punct(String) -- returns a boolean telling wether there is a punctuataion in String depending on the final String PUNCT
      pre:  w.length() > 0
      post: Punct("apple")  -> "appleway"
            Punct("strong") -> "ongstray"
            Punct("java")   -> "avajay"
    =====================================*/
    public static String Punct(String str) {
	String punct = PUNCT; // store PUNCT for manipulation
	for (int x = punct.length(); x > 0; x--) { // for loop
	    if (hasA(str,punct.substring(0,1))) { // checks if str has the first punctuation
		punct = punct.substring(0,1);// sets instance var punc to the specific punctuation 
		return punct; // EDIT: returns a string containing the specific punctuation
	    }
	    else{
		str = str.substring(1,str.length()); // else, cut down str by 1 on the front...
		punct = punct.substring(1,punct.length()); // and cut down punt by the one punctuation that isn't there
	    }
	}
	return ""; //EDIT: returns a null string in order to compare it better
    } // end Punct()
    
    /*=====================================
      String translate(String) -- culmination of everything (glitchy); preserves capital letters in their original positions
      pre:  w.length() > 0
      post: translate("Apple")  -> "Appleway"
            translate("strOng") -> "Ongstray"
            trantlete("javA")   -> "avAjay"
    =====================================*/
    public static String translate (String w) {
	boolean cap = haveCap(w); // is there a capital letter?
	String fin = ""; // return string
	String ret = engToPig(w.toLowerCase()); // invokes translate function
	if (cap) { // if there is capital letter in our string???
	    String hold = storeCapital(w); // store locations of capital letters
	    for (int x = 0; x < ret.length(); x++) { // iterate through revised string
		for (int y = 0; y < hold.length(); y++) {//iterate through positions of capital letters
		    if (hold.substring(y,y +1).equals(x + "")) { // if the integer in the "hold" variable equals x, then uppercasify it
			fin += ret.substring(x,x + 1).toUpperCase(); // uppercasifies it
		        x += 1; // goes on to next character cause otherwise we will duplicate this character
		    }	
		}
		fin += ret.substring(x,x + 1); // if that letter isn't capital then just add the letter.
	    }
	    return fin + punc; // return the modified string
	}
	else {
	    return ret+punc;
	}
    } // end translate()
    
    public static void main (String[] args) {
	System.out.println("-----hasA Tests-----");
	System.out.println(hasA("a","a")); // return true
	System.out.println(hasA("cat","a")); // return true
	System.out.println(hasA("cat","p")); // return false
	System.out.println(hasA("","a")); // return false
	System.out.println(hasA("more","or")); // return false
	System.out.println("-----isAVowel Tests-----");
	System.out.println(isAVowel("a")); // return true
	System.out.println(isAVowel("u")); // return true
	System.out.println(isAVowel("b")); // return false
	System.out.println(isAVowel("z")); // return false
	System.out.println("-----countVowels Tests-----");
	System.out.println(countVowels("zz"));  // return 0
	System.out.println(countVowels("cat")); // return 1
	System.out.println(countVowels("meatball")); // return 3
	System.out.println(countVowels("")); // return -1
	System.out.println("-----hasAVowel Tests-----");
	System.out.println(hasAVowel("cat"));  // return true
	System.out.println(hasAVowel("meatball")); // return true
	System.out.println(hasAVowel("zzzzz")); // return false
	System.out.println(hasAVowel("")); // return false
	System.out.println("-----allVowels Tests-----");
	System.out.println(allVowels("meatball"));  // return eaa
	System.out.println(allVowels("samsung")); // return au
	System.out.println(allVowels("zzzzzzzz"));  // return none
	System.out.println(allVowels("")); // return ERROR
	System.out.println("-----firstVowel Tests-----");
	System.out.println(firstVowel("")); // return an empty string
        System.out.println(firstVowel("zzz")); // return an empty string
	System.out.println(firstVowel("meatball")); // return e	
	System.out.println("-----beginsWithVowel Tests-----");
	System.out.println(beginsWithVowel("apple")); // return true	
	System.out.println(beginsWithVowel("strong")); // return false	
	System.out.println("-----engToPig Tests-----");
	System.out.println(engToPig("apple")); // return appleway
	System.out.println(engToPig("strong")); // return ongstray
	System.out.println(engToPig("java")); // return avajay
	System.out.println(engToPig("Hello")); // return elloHay
	System.out.println(engToPig("every-one")); // return every-oneway
	System.out.println(engToPig("of")); // return ofway
	System.out.println(engToPig("you")); // return ouyay
	System.out.println(engToPig("wasn't")); // return asn'twaypublic static void main (String[] args) {
	Scanner sc = new Scanner (System.in);
	while (sc.hasNext()) {
	    System.out.println(engToPig(sc.next()));
	}
	System.out.println("-----hasA Tests-----");
	System.out.println(hasA("a","a")); // return true
	System.out.println(hasA("cat","a")); // return true
	System.out.println(hasA("cat","p")); // return false
	System.out.println(hasA("","a")); // return false
	System.out.println(hasA("more","or")); // return false
	System.out.println("-----isAVowel Tests-----");
	System.out.println(isAVowel("a")); // return true
	System.out.println(isAVowel("u")); // return true
        System.out.println(isAVowel("b")); // return false
	System.out.println(isAVowel("z")); // return false
	System.out.println("-----countVowels Tests-----");
	System.out.println(countVowels("zz"));  // return 0
	System.out.println(countVowels("cat")); // return 1
	System.out.println(countVowels("meatball")); // return 3
	System.out.println(countVowels("")); // return -1
	System.out.println("-----hasAVowel Tests-----");
	System.out.println(hasAVowel("cat"));  // return true
	System.out.println(hasAVowel("meatball")); // return true
	System.out.println(hasAVowel("zzzzz")); // return false
	System.out.println(hasAVowel("")); // return false
	System.out.println("-----allVowels Tests-----");
	System.out.println(allVowels("meatball"));  // return eaa
	System.out.println(allVowels("samsung")); // return au
	System.out.println(allVowels("zzzzzzzz"));  // return none
	System.out.println(allVowels("")); // return ERROR
	System.out.println("-----firstVowel Tests-----");
	System.out.println(firstVowel("")); // return an empty string
	System.out.println(firstVowel("zzz")); // return an empty string
	System.out.println(firstVowel("meatball")); // return e	
	System.out.println("-----beginsWithVowel Tests-----");
	System.out.println(beginsWithVowel("apple")); // return true	
	System.out.println(beginsWithVowel("strong")); // return false	
	System.out.println("-----engToPig Tests-----");
	System.out.println(engToPig("apple")); // return appleway
	System.out.println(engToPig("strong")); // return ongstray
	System.out.println(engToPig("java")); // return avajay
	System.out.println(engToPig("Hello")); // return elloHay
	System.out.println(engToPig("every-one")); // return every-oneway
	System.out.println(engToPig("of")); // return ofway
	System.out.println(engToPig("you")); // return ouyay
	System.out.println(engToPig("wasn't")); // return asn'tway
	System.out.println(engToPig("gym"));//return mgyay
	System.out.println("-----storeCapital tests-----");
	System.out.println(storeCapital("waSn't"));// return 2
	System.out.println(storeCapital("June"));//return 0
	System.out.println("-----Capitalize tests-----");
	System.out.println(translate("Hello"));
	System.out.println(translate("YeLLow"));
	System.out.println(translate("gym"));
    } // end main()
} // end class Pig
