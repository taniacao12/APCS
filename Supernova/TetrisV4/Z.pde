class Z extends Shape {
  String arr[] = new String [4];
  color c;

  Z() {
    arr[0] = "00000";
    arr[1] = "01100";
    arr[2] = "00110";
    arr[3] = "00000";
    xpos = 1;
    ypos = 2;
    gridFill (arr);
    c = #B2F5F4; // light blue
  }
  color getColor() {
    return c;
  }
  
  int blockNum(){
     return 7; 
  }
}
