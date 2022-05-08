// Tania Cao
// APCS1 pd1
// HW#25 -- All Hallow's Eve
// 2017-11-01

public class Loopier {
    public static int[] populate (int x) {
        int[] array = new int[x];
	while (x > 0) {
	    array[x - 1] = (int) (Math.random() * 100);
	    x -= 1;
	}
	return array;
    }

    public static String retArray (int[] array) {
        String retStr = "";
	for (int index = 0; index < array.length; index += 1) {
	    retStr += array[index] + " ";
	}
	return retStr;
    }
    
    public static int linSearch (int[] a, int target) {
	int index = 0;
	while (index < a.length) {
	    if (a[index] == target) {
		return index;
	    }
	    index += 1;
	}
	return -1;
    }

    public static int linSearchR (int[] a, int target) {
	for (int index = 0; index < a.length; index += 1, linSearchR(a,target)) {
	    if (a[a.length - 1] != target) {
		return index;
	    }
	}
	return -1;
    }
    
    public static int freq (int[] a,int target) {
	int count = 0;
	int index = 0;
	while (index < a.length) {
	    if (a[index] == target) {
		count += 1;
		index += 1;
	    }
	    else {
		index += 1;
	    }
	}
	return count;
    }

    public static int freqRec (int[] a,int target) {
	int count = 0;
	for (int index = 0; index < a.length; index += 1) {
	    if (a[index] == target) {
		count += 1;
	    }
	}
	return count;
    }
    
    public static void main (String[] args) {
	System.out.println("-----retArray Tests-----");
	System.out.println(retArray(populate(3)));
	System.out.println(retArray(populate(5)));
	System.out.println(retArray(populate(7)));
	System.out.println("-----linSearch Tests-----");
	System.out.println(linSearch(populate(5),25));
	System.out.println(linSearch(populate(11),58));
	System.out.println(linSearch(populate(19),64));
	System.out.println("-----linSearchR Tests-----");
	System.out.println(linSearchR(populate(4),7));
	System.out.println(linSearch(populate(99),36));
	System.out.println(linSearch(populate(76),59));
	System.out.println("-----freq Tests-----");
	System.out.println(freq(populate(7),5));
	System.out.println(freq(populate(10),20));
	System.out.println(freq(populate(16),19));
	System.out.println("-----freqRec Tests-----");
	System.out.println(freqRec(populate(6),2));
	System.out.println(freqRec(populate(2),9));
	System.out.println(freqRec(populate(8),13));
    }
}
