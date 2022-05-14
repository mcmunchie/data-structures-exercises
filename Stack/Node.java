package Stack;

public class Node {

  // private members
  private int nodeData; // node's data
  private Node next; // node's next pointer
  private Node prev; // node's prev pointer

  public Node(int data) {
    nodeData = data; // initialize node data
    next = null; // initialize next to null
    prev = null; // initialize prev to null
  }

  public void setData(int data) {
    nodeData = data; // set node's data
  }

  public void setNext(Node newnode) {
    next = newnode; // set node's next pointer
  }

  public void setPrev(Node newnode) {
    prev = newnode; // set node's next pointer
  }

  public int getData() {
    return nodeData; // return node's data
  }

  public Node getNext() {
    return next; // return node's next pointer
  }

  public Node getPrev() {
    return prev; // return node's next pointer
  }
}
