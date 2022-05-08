
abstract class Shape {

  boolean grid[][] = new boolean [4][5];  

  void gridFill (String[] arrString) {
    try {
      for (int i = 0; i < arrString.length; i++) {
        for (int j = 0; j < arrString[i].length(); j++) {
          char currLetter = arrString [i].charAt(j);
          if (currLetter == '1') {
            grid [i][j] = true;
          } else {
            grid [i][j] = false;
          }
        }
      }
    }
    catch(Exception e) {
      endGame();
      println("Game Over");
      gameOver = true;
    }
  }  

  void display() {
    try {
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid.length; j++) {
          if (  grid [i][j] )
          {
            fill(this.getColor());
            rect(i * unit+xpos*unit, j * unit+ypos*unit, unit, unit);
          }
        }
      }
    } 
    catch(Exception e) {
      endGame();
      println("Game Over");
      gameOver = true;
    }
  } 

  abstract color getColor();
  abstract int blockNum();
  void fall() {
    if (millis() > time + 1000) {
      time = millis();
      ypos++;
    }
  }

  void stop() {
    ypos+=0;
  }

  int getX() {
    return xpos;
  }

  int getY() {
    return ypos;
  }
}
