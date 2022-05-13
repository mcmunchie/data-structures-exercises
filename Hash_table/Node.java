package Hash_table;

public class Node {

  // private variables
  private int nodeData; // node's data
  private String nodeKey; // node's key
  private Node next; // node's next pointer
  private Node prev; // node's previous pointer

  // constructor
  public Node(String key, int value) {
    nodeData = value; // initialize node data
    nodeKey = key; // initialize node key
    next = null; // initialize next to null
    prev = null; // initialize previous to null
  }

  // setter methods
  public void setValue(int value) { // set node's data
    nodeData = value;
  }

  public void setKey(String key) { // sets the key in the linked list
    nodeKey = key;
  }

  public void setNext(Node newnode) { // set node's next pointer
    next = newnode;
  }

  public void setPrev(Node newnode) { // set node's next pointer
    prev = newnode;
  }

  // getter methods
  public int getValue() { // return node's data
    return nodeData;
  }

  public String getKey() { // gets the key from the linked list
    return nodeKey;
  }

  public Node getNext() { // return node;s next pointer
    return next;
  }

  public Node getPrev() { // return node's next pointer
    return prev;
  }
}
