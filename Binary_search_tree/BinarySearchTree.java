package Binary_search_tree;

public class BinarySearchTree {
  private Node root;

  /**
   * Create new Node with value and insert into this Tree
   *
   * @param value Initial value for new Node
   */
  public void insertValue(int value) {
    insertNode(new Node(value));
  }

  /**
   * Insert new Node into this Tree
   *
   * @param newNode Node to be inserted into this Tree
   */
  public void insertNode(Node newNode) {
    if (root == null) {
      root = new Node(newNode.getValue());
    } else {
      insertNode(root, newNode);
    }
  }

  /**
   * Checks if this Tree is empty
   * 
   * @return True if empty, False otherwise
   */
  public boolean isEmpty() {
    if (root == null) {
      System.out.println("Tree is empty.");
      return true;
    } else {
      System.out.println("Tree is not empty.");
      return false;
    }
  }

  /**
   * Search this tree for a value
   *
   * @param value Value to be searched in this Tree
   * @return True if this tree contains value
   */
  public boolean containsValue(int value) {
    if (getNode(root, value) == null) {
      System.out.println(value + " is not in this tree.");
      return false;
    } else {
      System.out.println(value + " is in this tree.");
      return true;
    }
  }

  /**
   * Get Node in this Tree that contains value
   *
   * @param value Value to be searched within this Tree
   * @return Node that matches value or null if no match found
   */
  public Node getNode(Node currentNode, int value) {
    if (currentNode == null)
      return null;
    if (currentNode.getValue() == value)
      return currentNode;
    if (value < currentNode.getValue())
      return getNode(currentNode.getLeftNode(), value);
    return getNode(currentNode.getRightNode(), value);
  }

  /**
   * Insert a new node into this tree
   *
   * @param currentNode Current node we are comparing to newNode
   * @param newNode     New node that is to be inserted
   */
  private void insertNode(Node currentNode, Node newNode) {
    if (newNode.getValue() < currentNode.getValue()) {
      if (currentNode.getLeftNode() == null)
        currentNode.setLeftNode(newNode);
      else
        insertNode(currentNode.getLeftNode(), newNode);
    }
    if (newNode.getValue() > currentNode.getValue()) {
      if (currentNode.getRightNode() == null)
        currentNode.setRightNode(newNode);
      else
        insertNode(currentNode.getRightNode(), newNode);
    }
  }

  /**
   * @return String representation of this Tree
   */
  @Override
  public String toString() {
    if (root != null) {
      return root.toString();
    }
    return "";
  }
}
