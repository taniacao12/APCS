class Grid { //<>//
  boolean grid[][] = new boolean[10][20];

  Grid() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 20; j++) {
        grid[i][j] = false;
      }
    }
  }

  boolean isOccupied(int x, int y) {
    if (x < 10 && y < 20) {
      return grid[x][y];
    }
    return false;
  }

  void setOccupied(int x, int y) {
    grid[x][y] = true;
  }

  void setOccupied() {
    switch(currPiece.blockNum()) {
    case 1:  
      //pink long
      try {
        g.setOccupied(xpos, ypos);
        print("long");
        g.setOccupied(xpos, ypos - 1);
        g.setOccupied(xpos, ypos - 2);
        g.setOccupied(xpos, ypos - 3);
      } 
      catch(Exception e) {
        endGame();
        println("Game Over");
        gameOver = true;
      }
      break;
    case 2:
      //green
      print("J");
      try {
        g.setOccupied(xpos, ypos);
        g.setOccupied(xpos, ypos - 1);
        g.setOccupied(xpos, ypos - 2);
        g.setOccupied(xpos - 1, ypos - 2);
      } 
      catch(Exception e) {
        endGame();
        println("Game Over");
        gameOver = true;
      }
      break;
    case 3:
      //blue
      print("L");
      try {
        g.setOccupied(xpos - 1, ypos);
        g.setOccupied(xpos, ypos);
        g.setOccupied(xpos, ypos - 1);
        g.setOccupied(xpos, ypos - 2);
      } 
      catch(Exception e) {
        endGame();
        println("Game Over");
        gameOver = true;
      }
      break;
    case 4:
      //yellow
      print("O");
      try {
        g.setOccupied(xpos, ypos);
        g.setOccupied(xpos - 1, ypos);
        g.setOccupied(xpos - 1, ypos - 1);
        g.setOccupied(xpos, ypos - 1);
      } 
      catch(Exception e) {
        endGame();
        println("Game Over");
        gameOver = true;
      }
      break;
    case 5:
      //pink
      print("S");
      try {
        g.setOccupied(xpos - 1, ypos);
        g.setOccupied(xpos - 1, ypos - 1);
        g.setOccupied(xpos, ypos - 1);
        g.setOccupied(xpos, ypos - 2);
      } 
      catch(Exception e) {
        endGame();
        println("Game Over");
        gameOver = true;
      }
      break;
    case 6:
      //red
      print("T");
      try {
        g.setOccupied(xpos - 1, ypos - 1);
        g.setOccupied(xpos, ypos);
        g.setOccupied(xpos, ypos - 1);
        g.setOccupied(xpos, ypos - 2);
      } 
      catch(Exception e) {
        endGame();
        println("Game Over");
        gameOver = true;
      }
      break;
    case 7:
      //light blue
      print("Z");
      try {
        g.setOccupied(xpos, ypos);
        g.setOccupied(xpos, ypos - 1);
        g.setOccupied(xpos - 1, ypos - 1);
        g.setOccupied(xpos - 1, ypos - 2);
      } 
      catch(Exception e) {
        endGame();
        println("Game Over");
        gameOver = true;
      }
      break;
    }
  }

  void display() {
    for (int x = 0; x < 10; x++) {
      for (int y = 0; y < 20; y++) {
        if (isOccupied(x, y)) {
          fill(200);
        } else {
          fill(255);
        }
        rect(x*unit + 60, y*unit + 90, unit, unit);
      }
    }
  }

  // for debugging
  void printGrid() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 20; j++) {
        print( grid[i][j] + " ");
      }
      println();
    }
    println();
    println();
  }

  void removeRow() {
    int nb = 0;//number of full lines
    for (int j = 0; j < 20; j ++) {
      boolean fullLine = true;
      for (int i = 0; i < 10; i++) {
        fullLine = grid[i][j] == true;
        if (!fullLine) {
          break;
        }
      }
      // this jth line if full, delete it
      if (fullLine) {
        nb++;
        for (int k = j; k > 0; k--) {
          for (int i = 0; i < 10; i++) {
            grid[i][k] = grid[i][k-1];
          }
        }
        // top line will be empty
        for (int i = 0; i < 10; i++) {
          grid[i][0] = false;
        }
      }
    }
    score += nb;
  }
}
