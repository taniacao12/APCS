class I extends Shape {
  String arr[] = new String [4];
  color c;

  I() {
    arr[0] = "00000";
    arr[1] = "00000";
    arr[2] = "11110";
    arr[3] = "00000";
    xpos = 0;
    ypos = 2;

    gridFill (arr);
      c = #D4A3DE; //pink-purple
  }
    color getColor(){
    return c;
  }
  
  int blockNum(){
     return 1; 
  }
  
}
