abstract class Shape {

  boolean [][]grid = new boolean [4][5];  

  void gridFill (String[] arrString) {
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
  }  // method

  void display() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        if (  grid [i][j] )
        {
          fill(this.getColor());
          rect(i * unit+xpos*unit, j * unit+ypos*unit, unit, unit);
        } else
        {
          // fill(255);
        }
      }
    }
  } // method

abstract color getColor();

  void rotate() {
    boolean [][]temp = new boolean [4][5];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        temp [i][j]=grid [i][j];
      }
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        grid [3-j][i]=temp [i][j];
      }
    }
  }
 
}
