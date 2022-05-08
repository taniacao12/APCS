class Tetromino {
  int[][] grid;
  int unit = 30;
  int motion = 0; // 1: LEFT; 2: RIGHT; 3: SOFTDOWN; 4: HARDDOWN

  Tetromino (Shape shape) {
  }

  void rotateT() {
  }

  void left() { 
    if (motion == 1) {
    }
  }

  void right() {
    if (motion == 2) {
    }
  }

  void down() {
  }

  void softDown() {
    if (motion == 3) {
    }
  }

  void hardDown() {
    if (motion == 4) {
    }
  }

  void keyPressed() {
    if (key == CODED) {
      if (key == LEFT) {
        motion = 1;
      }
      if (key == RIGHT) {
        motion = 2;
      }
      if (key == DOWN) {
        motion = 3;
      }
      if (key == BACKSPACE) {
        motion = 4;
      }
    }
  }
}
