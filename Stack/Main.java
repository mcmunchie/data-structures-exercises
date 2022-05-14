package Stack;

public class Main {
  public static void main(String[] args) {
    PezDispenser myPez = new PezDispenser(4);

    myPez.push(); // push random number into the pez dispenser
    myPez.push(); 
    myPez.push(); 
    myPez.push(); 
    myPez.push(); 
    
    myPez.pop();
    myPez.pop(); 
    
    myPez.push(); 
    myPez.push(); 
    myPez.push(); 
    
    myPez.pop(); 
    myPez.push();
    
    myPez.print();
    myPez.ReversePrint();
    myPez.sum();
  }
}
