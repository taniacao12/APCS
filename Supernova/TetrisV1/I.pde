class I extends Shape {
  String arr[] = new String [4];
  color c;

  I() {
    arr[0] = "00000";
    arr[1] = "00000";
    arr[2] = "11110";
    arr[3] = "00000";

    gridFill (arr);
      c = #D4A3DE;
  }
    color getColor(){
    return c;
  }
  
}
