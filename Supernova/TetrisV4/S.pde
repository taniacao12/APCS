class S extends Shape {
  String arr[] = new String [4];
  color c;

  S() {
    arr[0] = "00000";
    arr[1] = "00110";
    arr[2] = "01100";
    arr[3] = "00000";
    xpos = 2;
    ypos = 2;
    gridFill (arr);
    c = #F5B2F2; //pink
  }
  
  color getColor(){
    return c;
  }
  
  int blockNum(){
     return 5; 
  }
}
