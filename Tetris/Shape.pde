class Shape {
  boolean[][] matrix;
  int c;

  // create the shapes
  Shape (int n, int[] blockNums, color clr) { // example: F T F
    matrix = new boolean[n][n];               // J Block  F T F
    for (int x = 0; x < n; x++)               //          T T F
      for (int y = 0; y < n; y++) 
        matrix[x][y] = false;
    for (int i = 0; i < blockNums.length; i++)
      matrix[blockNums[i] % n][blockNums[i] / n] = true;
    c = clr;
  }

  // creates shapes using pre-existing shapes (used in next shapes)
  Shape (Shape other) {
    matrix = new boolean[other.matrix.length][other.matrix.length];
    for (int x = 0; x < matrix.length; x++)
      for (int y = 0; y < matrix.length; y++)
        matrix[x][y] = other.matrix[x][y];
    c = other.getColor();
  }

  // creates the shape shown in the nextBoard
  void nextBoard() {
    int start = 1;
    for (int i = 0; i < matrix.length; i++)
      if (matrix[i][0])
        start = 0;
    for (int i = 0; i < matrix.length; i++)
      for (int j = start; j < matrix.length; j++)
        if (matrix[i][j])
          nextBoard.fillSquare(i, j - start, c);
  }

  color getColor() {
    return c;
  }
}
