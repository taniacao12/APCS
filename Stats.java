// Tania Cao
// APCS1 pd1
// HW#19 -- gcd 3 ways
// 2019-10-18

public class Stats {
    // mean() methods returns the average of a and b
    public static int mean (int a,int b) {
	return ((a + b) / 2);
    }

    public static double mean (double a,double b) {
	return ((a + b) / 2);
    }

    // min() returns the smallest of the given integers
    public static int min (int a,int b) {
	if (a > b) {
	    return b;
	}
	else {
	    return a;
	}
    }

    public static int min (int a,int b,int c) {
	return min(min(a,b),c);
    }
    
    // max() methods returns the largest of the given integers
    public static int max (int a,int b) {
	if (a > b) {
	    return a;
	}
	else {
	    return b;
	}
    }

    public static int max (int a,int b,int c) {
	return max(max(a,b),c);
    }

    public static double max (double a,double b) {
	if (a > b) {
	    return a;
	}
	else {
	    return b;
	}
    }
    
    public static double max (double a,double b,double c) {
        return max(max(a,b),c);
    }

    // geoMean() methods returns the geometric mean of a and b
    public static int geoMean (int a,int b) {
	return (int) Math.sqrt(a * b);
    }

    public static int geoMean (int a,int b,int c) {
	return (int) Math.cbrt(a * b * c);
    }

    public static double geoMean (double a,double b) {
	return Math.sqrt(a * b);
    }

    public static double geoMean (double a,double b,double c) {
    	return Math.cbrt(a * b * c);
    }

    // gcd() methods returns the greatest common denominator of a and b
    public static int gcd (int a,int b) {
	while ((!(min(a,b) == 0)) && (!(a == b))) {
	    a = max(a,b) - min(a,b);
	}
	return a;
    }

    /* gdcER() employs Eclid's algorithm recursively to find the greatest common denominator of a and b.
       If a = 0, the greatest common denominator is b.
       If b = 0, the greatest common denominator is a.
       If a = b * q + r and b != 0, gcd(a,b) = gcd(b,r).
       [note: q = quotient and r = remainder]
    */
    public static int gcdER (int a,int b) {
	if (b == 0) {
	    return a;
	}
	return gcd (b,(a % b));
    }

    /* gdcEW() employs Eclid's algorithm iteratively with a while loop to find the greatest common denominator of a and b.
       If a = 0, the greatest common denominator is b.
       If b = 0, the greatest common denominator is a.
       If a = b * q + r and b != 0, gcd(a,b) = gcd(b,r).
       [note: q = quotient and r = remainder]
    */
    public static int gcdEW (int a,int b) {
	while (!(min(a,b) == 0)) {
	    a = b;
	    b = a % b;
	}
	return a;
    }
	
    // main() to test methods
    public static void main (String[] args) {
	int intA = 8;
	int intB = 2;
	int intC = 8;
	double doubA = 8;
	double doubB = 2;
	double doubC = 8;
	
	System.out.println (mean(intA,intB)); // returns 5
	System.out.println (mean(doubA,doubB)); // returns 5.0
	System.out.println (max(intA,intB,intC)); // returns 8
	System.out.println (max(doubA,doubB,doubC)); // returns 8.0
	System.out.println (geoMean(intA,intB,intC)); // returns 5
	System.out.println (geoMean(doubA,doubB,doubC)); // returns 5.039684199579493
	System.out.println (gcd(intA,intB)); // returns 2
	System.out.println (gcdER(intA,intB)); // returns 2
	System.out.println (gcdEW(intA,intB)); // returns 2
    }
}
