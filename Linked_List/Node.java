package Linked_List;

public class Node {

  // private class members
  private int nodeData; // node's data
  private Node next; // node's next pointer

  public Node(int data) {
    nodeData = data; // initialize node data
    next = null; // initialize next to null
  }

  public void setData(int data) {
    nodeData = data; // set node's data
  }

  public void setNext(Node newnode) {
    next = newnode; // set node's next pointer
  }

  public int getData() {
    return nodeData; // return node's data
  }

  public Node getNext() {
    return next; // return node's next pointer
  }
}
