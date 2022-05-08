/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
  // instance of class ArrayList, holding objects of type Comparable 
  // (ie, instances of a class that implements interface Comparable)
  private ArrayList<Comparable> _data;


  // default constructor initializes instance variable _data
  public OrderedArrayList()
  {
    // *** YOUR IMPLEMENTATION HERE ***
  }


  public String toString()
  {
    // *** YOUR IMPLEMENTATION HERE ***
    return ""; //placeholder
  }


  public Comparable remove( int index )
  {	
    // *** YOUR IMPLEMENTATION HERE ***
    return ""; //placeholder 
  }


  public int size()
  { 
    // *** YOUR IMPLEMENTATION HERE ***
    return -1; //placeholder 
  }

    
  public Comparable get( int index )
  { 
    // *** YOUR IMPLEMENTATION HERE ***
    return ""; //placeholder  
  }


  public void add(Comparable newVal)
  { 
    // *** YOUR IMPLEMENTATION HERE ***
  }



  // main method solely for testing purposes
  public static void main( String[] args )
  {
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    OrderedArrayList Franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.add( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    //check for sorted-ness
    //if msg does not appear, list was sorted
    for( int i=0; i<Franz.size()-1; i++ ) {
      System.out.println("at i: " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }
       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class OrderedArrayList
