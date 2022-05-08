class J extends Shape {
  String arr[] = new String [4];
  color c;

  J() {
    arr[0] = "00000";
    arr[1] = "01000";
    arr[2] = "01110";
    arr[3] = "00000";
    xpos = 1;
    ypos = 2;

    gridFill (arr);
    c = #9CFAC2; //green
  }
    color getColor(){
    return c;
  }
  
  int blockNum(){
     return 2; 
  }
}
