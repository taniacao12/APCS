class L extends Shape {
  String arr[] = new String [4];
  color c;

  L() {
    arr[0] = "00000";
    arr[1] = "00010";
    arr[2] = "01110";
    arr[3] = "00000";
    xpos = 0;
    ypos = 2;

    gridFill (arr);
    c = #ADB2E8; //blue
  }
    color getColor(){
    return c;
  }
  
  int blockNum(){
     return 3; 
  }
}
