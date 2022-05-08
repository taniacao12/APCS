class Shape {

  color c;
  int blockNum;
  int blockDirection;
  String[] arrStr = new String[4];

  int xpos = 150;
  int ypos = 100;
  // Labeling blocks with numbers
  static final int S = 1;
  static final int Z = 2;
  static final int T = 3;
  static final int O = 4;
  static final int I = 5;
  static final int L = 6;
  static final int J = 7;



  // Labeling block directions (for rotations with numbers)
  static final int N = 0;
  static final int SS = 1;
  static final int E = 2;
  static final int W = 2;


  Shape() { // creates a random block
    blockDirection = N;
    blockNum = J;
    createRandShape();
  }

  void dropDown() {
    ypos += 30;
  }
  
  void stopMovement(){
    xpos += 0;
    ypos += 0;
  }
  
  void createRandShape() {
    int num = (int) random(7) + 1;
    switch (num) {
    case 1: 
      S();
    case 2: 
      Z();
    case 3: 
      T();
    case 4: 
      O();
    case 5: 
      I();
    case 6:
      J();
    default: 
      L();
    }
  }


  void J() {
    blockNum = J;
    c = #9CFAC2;
    
  }

  void S() {
    blockNum = S;
    c = #F5B2F2;
  }

  void Z() {
    blockNum = Z;
    c = #B2F5F4;
  }

  void T() {
    blockNum = T;
    c = #FF9D9D;
  }

  void O() {
    blockNum = O;
    c = #FFFF9D;
  }

  void I() {
    blockNum = I;
    c = #D4A3DE;
  }  

  void L() {
    blockNum = L;
    c = #ADB2E8;
  }

  int getColor() {
    return c;
  }

  int getBlockNum() {
    return blockNum;
  }

  int getBlockDirection() {
    return blockDirection;
  }

  /*  void buildShape(){
   switch (blockNum){
   case 1:  
   }
   */  // }
}
