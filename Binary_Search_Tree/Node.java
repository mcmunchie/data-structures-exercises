package Binary_Search_Tree;

public class Node {

  private String nodeData; // node's data
  private Node next; // node's next pointer

  public Node(String data) {
    nodeData = data; // initialize node data
    next = null; // initialize next to null
  }

  public void setData(String data) {
    nodeData = data; // set node's data
  }

  public void setNext(Node newnode) {
    next = newnode; // set node's next pointer
  }

  public String getData() {
    return nodeData; // return node's data
  }

  public Node getNext() {
    return next; // return node's next pointer
  }
}
