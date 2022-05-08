// Tania Cao
// APCS2 pd2
// HW#12 -- 
// 2018-02-28

/***
 * class KnightBoard
 * Generates solutions for NxN-Knight problem.
 */

public class KnightBoard {
    public int[][] _board;
    
    public KnightBoard (int size) {
	_board = new int[size][size];
	for (int r = 0; r < size; r++) {
	    for (int c = 0; c < size; c ++) {
		_board[r][c] = -1;
	    }
	}
    }
    
    /**
     * precondition: board is filled with -1's only.
     * postcondition: If a solution is found, board shows the order/path the
     *     knight travels through, returns true. If no solution, board is 
     *     filled with 0's, returns false.
     */
    public boolean solve() {
	_board[0][0] = 0; // Knight always starts from (0,0)
	// rowMove and colMove defines the Knight's next move
	int[] rowMove = {2, 1, -1, -2, -2, -1, 1, 2};
	int[] colMove = {1, 2, 2, 1, -1, -2, -2, -1};
	if (solveH(0,0,1,rowMove,colMove) == true) {
	    printSolution();
	    return true;
	}
	_board = new int[_board.length][_board.length];
	for (int r = 0; r < _board.length; r++) {
	    for (int c = 0; c < _board.length; c ++) {
		_board[r][c] = -1;
	    }
	}
	return false;
    }
    
    /**
     * Helper method for solve. 
     */
    public boolean solveH(int row,int col,int moves,int[] rowM,int[] colM) {
	int nextRow, nextCol;
	if (moves == _board.length * _board.length) {
	    return true;
	}
	for (int index = 0; index < 8; index++) {
	    nextRow = row + rowM[index];
	    nextCol = col + colM[index];
	    if ((nextRow >= 0 && nextRow < _board.length &&
		nextCol >= 0 && nextCol < _board.length &&
		 _board[nextRow][nextCol] == -1) == true) {
		_board[nextRow][nextCol] = moves;
		if (solveH(nextRow,nextCol,moves+1,rowM,colM) == true) {
		    return true;
		}
		else {
		    _board[nextRow][nextCol] = -1;
		}
	    }
	}
	return false;
    }
    
    public void printSolution() {
        String ans = "";
	for( int r = 0; r < _board.length; r++) {
	    for( int c = 0; c < _board[0].length; c++) {
		ans += _board[r][c] + "\t";
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }

    //================= YE OLDE SEPARATOR =================
        
    /***
     * Overwrite default toString to print out the chess board
     * precondition: board exists
     * postcondition: 
     */
    public String toString() {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c] + "\t";
	    }
	    ans += "\n";
	}
	return ans;
    }

    // main method for testing...
    public static void main (String[] args) {
	KnightBoard a = new KnightBoard(5);
	a.solve();
	KnightBoard b = new KnightBoard(8);
	b.solve();
    } 
} // end class
