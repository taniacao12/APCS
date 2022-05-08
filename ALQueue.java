// Tania Cao
// APCS2 pd2
// HW#35 -- ...Nor Do Aussies
// 2018-04-16

import java.util.ArrayList;

public class ALQueue<Quasar> implements Queue<Quasar>{
    ArrayList<Quasar> ar = new ArrayList<Quasar>();
    
    public ALQueue<Quasar>() {
	ar = new Quasar(0); 
    }
    
    public Quasar dequeue() {
        return ar.remove(0);
    }

    public void enqueue( Quasar x ) {
        ar.add(x);
    }
	
    public boolean isEmpty() {
	return ar[0].equals(null);
    }
    
    public Quasar peekFront() {
	return ar[0];
    }
} // end ALQueue
