// Clyde "Thluffy" Sinclair
// APCS1 pd0
// HW46 -- getting acquainted w ArrayList
// 2017-12-05t

/***************************
 * class ALTester
 * Driver/tester class for ArrayList
 ***************************/

import java.util.ArrayList;

public class ALTester
{

  public static void main( String[] args )
  {
    ArrayList<Comparable> portmanteau = new ArrayList<Comparable>();

    System.out.println( portmanteau );

    //populate
    for( int i=0; i<23; i++ ){
      portmanteau.add(i*2);
    }

    System.out.println( portmanteau );

    portmanteau.set( 5, 100 );

    //check for sortedness
    for( int i=0; i<portmanteau.size()-1; i++ ) {
      System.out.println( "at i: " + portmanteau.get(i) );
      if ( portmanteau.get(i).compareTo(portmanteau.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
      System.out.println( "AYO! That one was sorted." );
    }

  }//end main

}//end class
