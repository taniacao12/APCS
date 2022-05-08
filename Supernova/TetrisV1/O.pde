class O extends Shape {
  String arr[] = new String [4];
  color c;

  O() {
    arr[0] = "00000";
    arr[1] = "00110";
    arr[2] = "00110";
    arr[3] = "00000";

    gridFill (arr);
    c = #FFFF9D;
 
}
  color getColor(){
    return c;
  }
  
}
