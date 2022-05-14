package Binary_Search_Tree;

public class BinarySearchTreeNode {

	private String nodeKey;
	private BinarySearchTreeNode rightChild; // node's next pointer
	private BinarySearchTreeNode leftChlld; // node's previous pointer

	public BinarySearchTreeNode(String key) {
		nodeKey = key;
		rightChild = null;
		leftChlld = null;
	}

	public void setValue(String key) {
		nodeKey = key; // set node's data
	}

	public void setRightNode(BinarySearchTreeNode newnode) {
		rightChild = newnode; // set tree's right node
	}

	public void setLeftNode(BinarySearchTreeNode newnode) {
		leftChlld = newnode; // set tree's left node
	}

	public String getValue() {
		return nodeKey; // return node's data
	}

	public BinarySearchTreeNode getRightNode() {
		return rightChild; // return tree's right node
	}

	public BinarySearchTreeNode getLeftNode() {
		return leftChlld; // return tree's left node
	}

	public int GetNumberOfChildren() { // returns the number of children a node has in the BST
		if (getLeftNode() == null && getLeftNode() == null) {
			return 0;
		} else if (getLeftNode() == null && getRightNode() != null) {
			return 1;
		} else if (getLeftNode() != null && getRightNode() == null) {
			return 1;
		} else {
			return 2;
		}
	}
}
