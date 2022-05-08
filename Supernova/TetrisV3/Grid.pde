class Grid {
  int startWidth = 150;
  int startHeight = 100;
  int endWidth = 450;
  int endHeight = 700;
  int spacing = 30;
  int numRows = 20;
  int numCols = 10;
  boolean[][] grid;
  

  Grid() {
    grid = new boolean[numRows][numCols];
    for (int x = 0; x < numRows; x++) {
      for (int y = 0; y < numCols; y++) {
        grid[x][y] = false;
      }
    }
    
  }
  void createMatrix() {
    for (int x = startWidth; x < endWidth; x += 30) {
      for (int y = startHeight; y < endHeight; y+= 30) {
        rect(x, y, 30, 30);
      }
    }
  } 
  void drawGrid(PImage img, int a, int b) {
    for (int i= 0; i < numRows; i++) {
      for (int y = 0; y < numCols; y++) {
        if (grid[i][y] != false) {
          return;
        }
      }
    }
    for (int x = startWidth; x < endWidth; x += 30) {
      for (int y = startHeight; y < endHeight; y+= 30) {
        image(img, a, b, 60, 60);
      }
    }
  }
  
  
  
  void registerShapeO(){
      grid[0][0] = true;
      grid[0][1] = true;
      grid[1][0] = true;
      grid[0][1] = true;
  }
  
  void removeShape(){
      
  }

  void registerDown(){
      for (int x = 0; x < numRows; x++) {
      for (int y = 0; y < numCols; y++) {
        grid[x][y] = false;
      }
    }
  }
  
  int getStartWidth() {
    return startWidth;
  }

  int getEndWidth() {
    return endWidth;
  }
  int getStartHeight() {
    return startHeight;
  }
  int getEndHeight() {
    return endHeight;
  }
}
