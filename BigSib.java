public class BigSib {
    // instance variables
    public String helloMsg;

    // default constructor
    public BigSib(String newMsg) {
	helloMsg = newMsg;
    }
    
    // methods
    public void setHelloMsg (String newMsg) {
	helloMsg = newMsg;
    }
    
    public String greet (String name){
	helloMsg += " " + name;
	return helloMsg;
    }
}
