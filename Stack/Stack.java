package Stack;

public class Stack {

  private DoublyLinkedList myList = null; // implement DLL to create a stack

  public Stack(int data) {
    this.myList = new DoublyLinkedList(data);
  }

  public void push(int num) { // add integer onto stack (adds to top)
    myList.insert(num, 0);
  }

  public int pop() { // remove integer from stack (removes from top)
    int num;
    num = myList.getHead();

    myList.delete(0);
    return num;
  }

  public boolean isEmpty() { // returns true if empty, false otherwise
    return myList.isEmpty();
  }

  public void sum() { // prints the sum of the items in the stack
    myList.sumPrint();
  }

  public void print() { // prints the items in the stack
    myList.print();
  }

  public void ReversePrint() { // prints the items in the stack in reverse
    myList.ReversePrint();
  }

  public static void main(String[] args) {
    Stack myStack = new Stack(7);

    System.out.println("Is empty?: " + myStack.isEmpty()); // check if stack is empty, should return false

    myStack.push(5); // pushing items onto stack
    myStack.push(4);
    myStack.push(26);
    myStack.push(14);
    myStack.push(27);
    myStack.push(20);

    System.out.print("Stack: ");
    myStack.print();

    System.out.println();
    myStack.sum(); // returns 103

    myStack.pop();
    myStack.pop();

    System.out.println("Is empty?: " + myStack.isEmpty()); // check if stack is empty, should return false

    System.out.print("Stack: ");
    myStack.print();
    System.out.print("\nStack Reversed: ");
    myStack.ReversePrint();

    myStack.sum(); // returns 56
  }
}
