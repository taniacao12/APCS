class T extends Shape {
  String arr[] = new String [4];
  color c;

  T() {
    arr[0] = "00000";
    arr[1] = "01000";
    arr[2] = "11100";
    arr[3] = "00000";
    xpos = 0;
    ypos = 2;
    gridFill (arr);
    c = #FF9D9D; //red
  }
  color getColor() {
    return c;
  }
  
  int blockNum(){
     return 6; 
  }
}
