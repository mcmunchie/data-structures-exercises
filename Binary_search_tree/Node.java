package Binary_search_tree;

public class Node {

  // private members
  private Node leftNode; // left child node
  private Node rightNode; // right child node
  private int value; // node data

  /**
   * node constructor with initial node value
   *
   * @param value initial value for this node
   */
  public Node(int value) {
    leftNode = null; // initialize left child to null
    rightNode = null; // initialize right child to null
    this.value = value; // initialize node data
  }

  // setter methods
  public void setLeftNode(Node node) {
    this.leftNode = node;
  }

  public void setRightNode(Node node) {
    this.rightNode = node;
  }

  public void setValue(int value) {
    this.value = value;
  }

  // getter methods
  public Node getLeftNode() {
    return leftNode;
  }

  public Node getRightNode() {
    return rightNode;
  }

  public int getValue() {
    return value;
  }

  /**
   * @return String representation of this Node
   */
  @Override
  public String toString() {
    String result = value + "";
    if (leftNode != null)
      result = leftNode.toString() + ", " + result;
    if (rightNode != null)
      result = result + ", " + rightNode.toString();
    return result;
  }
}
