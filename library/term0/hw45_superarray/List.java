/***************************
 * interface List
 * Declares methods that will be implemented by any
 *  class wishing to adhere to this specification.
 * This interface specifies behaviors of a list of Objects.
 ***************************/

public interface List
{
  // Return number of elements in the list
  int size();

  // Append an Object to the end. Return true.
  boolean add( Object o );

  // Insert an Object at index
  void add( int index, Object o ); 

  // Retrieve the Object at index
  Object get( int index );

  // Overwrite the Object at index
  Object set( int index, Object o );

  // Remove the Object at index,
  // shifting any elements after it to the left.
  // Return removed value.
  Object remove( int index );

}//end interface List
