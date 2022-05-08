class J extends Shape {
  String arr[] = new String [4];
  color c;

  J() {
    arr[0] = "00000";
    arr[1] = "01000";
    arr[2] = "01110";
    arr[3] = "00000";

    gridFill (arr);
    c = #9CFAC2;
  }
    color getColor(){
    return c;
  }
  
}
