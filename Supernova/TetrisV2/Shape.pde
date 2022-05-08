class Shape {
  boolean[][] shape;
  int num, size, c;

  Shape() { // creates a random block
    size = 20;
    int num = (int) random(7) + 1;
    if (num == 1) J();
    else if (num == 2) S();
    else if (num == 3) Z();
    else if (num == 4) T();
    else if (num == 5) O();
    else if (num == 6) I();
    else L();
  }

  void J() {
    c = #9CFAC2;
    shape = new boolean[3][3];
    for (int row = 0; row < shape.length; row++)
      for (int col = 0; col < shape[0].length; col++)
        if ((col == 0 && row = 2) || (col == 1))
          shape[row][col] = true;
  }

  void S() {
    c = #F5B2F2;
    shape = new boolean[3][3];
    for (int row = 0; row < shape.length; row++)
      for (int col = 0; col < shape[0].length; col++)
        if ((row == 0 && col > 0) || (row == 1 && col < 2))
          shape[row][col] = true;
  }

  void Z() {
    c = #B2F5F4;
    shape = new boolean[3][3];
    for (int row = 0; row < shape.length; row++)
      for (int col = 0; col < shape[0].length; col++)
        if ((row == 0 && col < 2) || (row == 1 && col > 0))
          shape[row][col] = true;
  }

  void T() {
    c = #FF9D9D;
    shape = new boolean[3][3];
    for (int row = 0; row < shape.length; row++)
      for (int col = 0; col < shape[0].length; col++)
        if ((row == 0 && col == 1) || (row == 1))
          shape[row][col] = true;
  }

  void O() {
    c = #FFFF9D;
    shape = new boolean[2][2];
    for (int row = 0; row < shape.length; row++)
      for (int col = 0; col < shape[0].length; col++)
        shape[row][col] = true;
  }

  void I() {
    c = #D4A3DE;
    shape = new boolean[4][4];
    for (int row = 0; row < shape.length; row++)
      for (int col = 0; col < shape[0].length; col++)
        if (col == 0) shape[row][col] = true;
  }  

  void L() {
    c = #ADB2E8;
    shape = new boolean[3][3];
    for (int row = 0; row < shape.length; row++)
      for (int col = 0; col < shape[0].length; col++)
        if ((col == 0) || (col == 1 && row = 2))
          shape[row][col] = true;
  }

  int getColor() {
    return c;
  }
}