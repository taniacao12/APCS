class Grid {
  int x, y;
  int myWidth, myHeight;
  int rows, cols;
  int[][] colors;
  ArrayList<Integer> clearRows = new ArrayList<Integer>();
  int animateCount = -1;

  // create the grids
  Grid (int xcorr, int ycorr, int w, int h, int numRows, int numCols) {
    x = xcorr;
    y = ycorr;
    myWidth = w;
    myHeight = h;
    rows = numRows;
    cols = numCols;
    colors = new int[cols][rows];
    for (int r = 0; r < cols; r++)
      for (int c = 0; c < rows; c++)
        colors[r][c] = 0;
  }

  // clear the grid (used when restarting the game)
  void clear() {
    for (int r = 0; r < rows; r++)
      for (int c = 0; c < cols; c++)
        colors[r][c] = 0;
  }

  // draws the grids onto the screen
  void draw() {
    stroke(255);
    strokeWeight(2);
    rect(x, y, myWidth, myHeight);
    for (int i = 0; i < cols; i++)
      for (int j = 0; j <rows; j++)
        fillSquare(i, j, colors[i][j]);
    // line clear animation
    if (animateCount >= 0) {
      int c;
      // create a background that goes between black and white on the lines being cleared
      if (animateCount < 255)
        c = animateCount;
      else c = 255 - animateCount % 255;
      if (clearRows.size() == 4)
        c = color(0, c, c);
      for (int row : clearRows)
        for (int i = 0; i < cols; i++)
          fillSquare(i, row, color(c, 200));
      animateCount += 10;
      // stop animation, clear the lines, and load the next Tetromino
      if (animateCount > 2 * 255) {
        animateCount = -1;
        eraseCleared();
        loadNext();
      }
    }
  }

  // precondition: given col and row are exist
  // fill the square in the grid with the color c
  void fillSquare (int col, int row, color c) {
    if (col < 0 || col >= cols || row < 0 || row >= rows)
      return;
    noStroke();
    fill(c);
    rect(x + col * (myWidth / cols), y + row * (myHeight / rows), myWidth / cols, myHeight / rows);
  }

  // precondition: given col and row are exist
  // creates the outlines of the current tetromino at the bottom white for easier preview of where the block will land
  void outlineSquare(int col, int row) {
    if (col < 0 || col >= cols || row < 0 || row >= rows)
      return;
    noFill();
    stroke(255);
    strokeWeight(2);
    rect(x + col * (myWidth / cols), y + row * (myHeight / rows), myWidth / cols, myHeight / rows);
  }

  // place the tetromino on the grid
  void endTurn() {
    for (int i = 0; i < current.shape.matrix.length; i++)
      for (int j = 0; j < current.shape.matrix.length; j++)
        if (current.shape.matrix[i][j] && j + current.y >= 0) 
          colors[i + current.x][j + current.y] = current.getColor();
    if (checkLines()) {
      current = null;
      animateCount = 0;
    } else
      loadNext();
  }

  // check whether the the game has exceeded the row limit (game over or not?)
  boolean checkLines() {
    clearRows.clear(); // clear any completed rows
    for (int j = 0; j < rows; j++) {
      int count = 0;
      for (int i = 0; i < cols; i++)
        if (isOccupied(i, j))
          count++;
      if (count >= cols)
        clearRows.add(j);
    }
    // if row limit is exceeded, return false
    if (clearRows.isEmpty())
      return false;
    // otherwise, continue the game --> update score and number of lines cleared; level up and increase speed of default drop if needed
    if (lines/10 < (lines + clearRows.size()) / 10) {
      level++;
      timer -= SPEED_DECREASE;
    }
    lines += clearRows.size();
    score += (1 << clearRows.size() - 1)*100;
    return true;
  }

  // erase the completed row
  void eraseCleared() {
    for (int row : clearRows) {
      for (int j = row - 1; j > 0; j--) {
        int[] rowCopy = new int[cols];
        for (int i = 0; i < cols; i++)
          rowCopy[i] = colors[i][j];
        for (int i = 0; i < cols; i++)
          colors[i][j + 1] = rowCopy[i];
      }
    }
  }

  // checks whether the given coordinate in the grid is occupied
  boolean isOccupied (int x, int y) {
    if (y < 0 && x < cols && x >= 0)
      return false;
    return (x >= cols || x < 0 || y >= rows || colors[x][y] != 0);
  }
}
