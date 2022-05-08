class Tetromino {
  Shape shape;
  int x, y;
  int finalRow;

  // creates the tetromino displayed on the grid
  Tetromino(Shape shape) {
    this.shape = new Shape(shape);
    x = 3;
    y = -2;
    finalRow = getFinalRow();
    gameOver = !isLegal(this.shape.matrix, 3, -1);
  }

  // checks whether the given coordinate is occupied
  boolean isLegal(boolean[][] matrix, int col, int row) {
    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix.length; j++)
        if (matrix[i][j] && gameBoard.isOccupied(col + i, row + j))
          return false;
    return true;
  }

  // moves the tetromino to the left
  void left() {
    if (isLegal(shape.matrix, x - 1, y))
      x--;
    else if (isLegal(shape.matrix, x - 2, y))
      x -= 2;
    update();
  }

  // moves the tetromino to the right
  void right() {
    if (isLegal(shape.matrix, x + 1, y))
      x++;
    else if (isLegal(shape.matrix, x + 2, y))
      x += 2;
    update();
  }

  // updates the location of the finalRow and resets the timer if the player is at bottom to allow the play to move the tetromino left or right before it locks in place
  void update() {
    finalRow = getFinalRow();
    if (y == finalRow)
      currentTime = -20;
  }

  // speeds up the drop of the tetromino
  void down() {
    // if the tetromino is at the bottom, the tetromino is locked and the next one is loaded
    if (y >= finalRow) {
      gameBoard.endTurn();
    } else {
      stepDown();
      score += 1;  // add a point to the score for the manual down
    }
  }

  // default drop of the tetromino
  void stepDown() {
    // if the tetromino is at the bottom, the tetromino is locked and the next one is loaded
    if (y >= finalRow) {
      gameBoard.endTurn();
    } else {
      y++;
      currentTime = 0;
    }
  }

  // force drop the tetromino the the bottom
  void hardDown() {
    score += (gameBoard.rows - y); // add points to the score based on the number of lines the force drop passed by to get to the bottom
    y = finalRow;
    gameBoard.endTurn();
  }

  // rotate the tetromino
  void rotate() {
    boolean[][] ret = new boolean[shape.matrix.length][shape.matrix.length];
    for (int x = 0; x < ret.length; x++)
      for (int y = 0; y < ret.length; y++)
        ret[x][y] = shape.matrix[y][ret.length - 1 - x];
    if (isLegal(ret, x, y)) {
      shape.matrix = ret;
      update();
    } else if (isLegal(ret, x + 1, y) || isLegal(ret, x + 2, y)) {
      shape.matrix = ret;
      right();
    } else if (isLegal(ret, x - 1, y) || isLegal(ret, x - 2, y)) {
      shape.matrix = ret;
      left();
    }
  }

  int getFinalRow() {
    int start = max (0, y);
    for (int row = start; row <= gameBoard.rows; row++)
      if (!isLegal(shape.matrix, x, row))
        return row - 1;
    return -1;
  }

  /*
  // creates the tetromino shown in the nextBoard
   void holdBoard(Tetromino tetromino) {
   int start = 1;
   for (int i = 0; i < tetromino.shape.matrix.length; i++)
   if (tetromino.shape.matrix[i][0])
   start = 0;
   for (int i = 0; i < tetromino.shape.matrix.length; i++)
   for (int j = start; j < tetromino.shape.matrix.length; j++)
   if (tetromino.shape.matrix[i][j])
   nextBoard.fillSquare(i, j - start, tetromino.getColor());
   }
   */

  void draw() {
    for (int i = 0; i < shape.matrix.length; i++)
      for (int j = 0; j < shape.matrix.length; j++)
        if (shape.matrix[i][j]) {
          gameBoard.fillSquare(x + i, y + j, shape.c);
          gameBoard.outlineSquare(x + i, finalRow + j);
        }
  }

  color getColor() { 
    return shape.c;
  }
}
