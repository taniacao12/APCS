// Tania Cao
// APCS2 pd2
// HW#10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
// 2018-02-27

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard {
    public int[][] _board;
    
    public QueenBoard (int size) {
	_board = new int[size][size];
    }
    
    /**
     * precondition: board is filled with 0's only.
     * postcondition: If a solution is found, board shows position of N 
     *     queens, returns true. If no solution, board is filled with 0's,
     *     returns false.
     */
    public boolean solve() {
	if (solveH(0) == true) {
	    printSolution();
	    return true;
	}
	_board = new int[_board.length][_board.length];
	return false;
    }
  
    /**
     * Helper method for solve. 
     */
    public boolean solveH (int col) {
	if (col >= _board[0].length) {
	    return true;
	}
	for (int row = 0; row < _board[0].length; row++) {
	    if (addQueen(row,col)) {
		addQueen(row,col);
		if (solveH(col+1) == true) {
		    return true;
		}
	        removeQueen(row,col);
	    }
	}
	return false;
    }
    
    public void printSolution() {
        String ans = "";
	for( int r = 0; r < _board.length; r++) {
	    for( int c = 0; c < _board[0].length; c++) {
		if (_board[r][c] == 1) {
		    ans += "Q\t";
		}
		else {
		    ans += "-\t";
		}
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }

    //================= YE OLDE SEPARATOR =================

    /***
     * If the given coordinate doesn't have a queen, a queen is added.
     * precondition: board exists
     * postcondition: the given coordinate doesn't have a queen 
     */
    public boolean addQueen (int row,int col) {
	if (_board[row][col] != 0) {
	    return false;
	}
	_board[row][col] = 1;
	int offset = 1;
	while (col + offset < _board[row].length){
	    _board[row][col + offset]--;
	    if (row - offset >= 0){
		_board[row - offset][col + offset]--;
	    }
	    if (row + offset < _board.length){
		_board[row + offset][col + offset]--;
	    }
	    offset++;
	}
	return true;
    }

    /***
     * If the given coordinate has a queen, the queen will be removed.
     * precondition: board exists
     * postcondition: the given coordinate has a queen
     */
    public boolean removeQueen (int row,int col) {
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;
	int offset = 1;

	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }

    /***
     * Overwrite default toString to print out the chess board
     * precondition: board exists
     * postcondition: 
     */
    public String toString() {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }

    // main method for testing...
    public static void main (String[] args) {
	QueenBoard a = new QueenBoard(5);
	a.solve();
	// // System.out.println(a); // prints empty board (only 0s)
	// a.addQueen(0,0);
	// a.addQueen(1,3);
        // a.addQueen(2,1);
	// a.addQueen(3,4);
	// a.addQueen(4,2);
	// //a.addQueen(3,2); // false solution
	// //a.addQueen(4,4); // false solution
	// System.out.println(a);
	// a.solve();
	// System.out.println(a);

	QueenBoard b = new QueenBoard(6);
	b.solve();
	// // System.out.println(b); // prints empty board (only 0s)
	// b.addQueen(0,2);
	// b.addQueen(1,5);
	// b.addQueen(2,1);
	// b.addQueen(3,4);
	// b.addQueen(4,0);
	// b.addQueen(5,3);
	// //b.addQueen(4,3); // false solution
	// //b.addQueen(5,0); // false solution
	// System.out.println(b);
	// b.solve();
	// System.out.println(b);
    } 
} // end class
