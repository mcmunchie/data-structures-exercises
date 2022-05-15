package Binary_search_tree;

public class Main {
  public static void main(String[] args) {
    BinarySearchTree myTree = new BinarySearchTree();
    myTree.isEmpty(); // checks if tree is empty, returns true
    
    myTree.insertValue(14); // adding items into the tree
    myTree.insertValue(20);
    myTree.insertValue(27);
    myTree.insertValue(4);
    myTree.insertValue(26);
    myTree.insertValue(10);
    myTree.insertValue(11);
    myTree.insertValue(9);
    myTree.insertValue(20);
    myTree.insertValue(15);
    
    System.out.print("Tree: ");
    System.out.println(myTree.toString()); // prints string representation of tree, returns 4, 9, 10, 11, 14, 15, 20, 26, 27
    
    myTree.isEmpty(); // returns false

    myTree.containsValue(10); // checks if 10 is in the tree, returns true
    myTree.containsValue(30); // checks if 30 is in the tree, returns false

  }
}
