package Linked_List;

public class LinkedList {

  private Node head;

  public int size() {
    Node cursor = head; // set cursor to head
    int count = 0; // initialize counter to 0
    while (cursor != null) { // check to see if at end of list
      count++; // increment counter
      cursor = cursor.getNext(); // move cursor through the list
    }
    return count; // return the count (i.e. size of list)
  }

  public boolean isEmpty() {
    if (size() == 0) { // check if size equals 0
      return true; // true if 0
    } else {
      return false; // false otherwise
    }
  }

  public void add(int data) { // adds a node to end of the list
    Node node = new Node(data); // create new node
    Node cursor = head; // start the cursor at the head
    if (cursor == null) { // if the list is empty
      head = node; // sets the new node as head
    } else {
      while (cursor.getNext() != null) { // checks if next node is null
        cursor = cursor.getNext(); // traverse list
      }
      cursor.setNext(node); // sets new node to end of list
    }
  }

  public void insert(int data, int position) { // inserts an item into the list
    Node node = new Node(data); // creates new node
    Node cursor = head; // start the cursor at head
    int count = 0; // counter
    if (position == 0) { // checks if position is equal to 0
      node.setNext(cursor); // connect node's next pointer to cursor
      head = node; // sets new node to head
    } else {
      while (count < position - 1 && cursor != null) { // loop until the previous node in the linked list
        cursor = cursor.getNext(); // traverse list
        count++;
      }
      node.setNext(cursor.getNext()); // sets node to next position
      cursor.setNext(node); // sets node to position entered
    }
  }

  public void delete(int position) { // deletes a node at a given position
    Node cursor = head; // start the cursor at the head
    Node cursor2 = head.getNext(); // second cursor to traverse one node ahead of first cursor
    int count = 0; // counter

    if (position == 0) { // deleting from the head if position equals 0
      cursor.setNext(cursor.getNext());
      cursor.setNext(null); // sets the node to delete to null
      head = cursor2; // cursor2 is set as the head to replace previous item
    } else {
      while (count != position - 1) { // loop until count equals the position entered
        cursor = cursor.getNext(); // traverse the first cursor
        cursor2 = cursor2.getNext(); // traverse second cursor
        count++;
        if (count == position - 1) { // cursor is on previous node and cursor2 is on given position
          cursor.setNext(cursor2.getNext()); // sets node after given position to cursor
          cursor2.setNext(null); // sets given position to null
        }
      }
    }
  }

  public void remove(int data) { // removes first instance of given value
    Node cursor = head; // start the cursor at the head
    Node cursor2 = head.getNext(); // second cursor to traverse one node ahead of first cursor
    int value;

    if (cursor.getData() == data) {
      cursor.setNext(cursor.getNext());
      cursor.setNext(null); // sets the node to delete to null
      head = cursor2; // cursor2 is set as the head to replace previous item at position zero
    } else {
      while (cursor2.getData() != data) {
        cursor = cursor.getNext(); // traverse the first cursor
        cursor2 = cursor2.getNext(); // traverse second cursor
        value = cursor2.getData();
        if (value == data) {
          cursor.setNext(cursor2.getNext());
          cursor2.setNext(null);
        }
      }
    }
  }

  public void print() { // prints out the linked list
    Node cursor = head;
    System.out.print("Linked List: ");
    while (cursor != null) { // traverse through the entire linked list
      System.out.print(cursor.getData());
      if (cursor.getNext() == null) {
        break;
      }
      System.out.print(", ");
      cursor = cursor.getNext();
    }
  }

  public static void main(String[] args) {
    LinkedList myList = new LinkedList();
    System.out.println("Is empty?: " + myList.isEmpty()); // check if list is empty, should return true

    myList.add(5); // adding items to the linked list
    myList.add(27);
    myList.add(100);
    myList.add(0);
    myList.add(26);
    myList.add(20);
    myList.add(4);
    myList.add(14);
    myList.add(0);
    myList.add(340);
    myList.add(12);
    myList.add(8);

    myList.print();
    System.out.println("\nSize: " + myList.size()); // print current size of linked list, return 12

    myList.insert(9, 5); // inserts 9 at the fifth position
    myList.insert(21, 0); // inserts 21 at position zero
    myList.insert(22, 13); // inserts 22 at thirteenth position

    myList.remove(8); // removes the fist instance of 8
    myList.remove(0); // removes the first instance of 0
    myList.remove(21); // removes the first instance of 21

    myList.delete(7); // deletes position 7
    myList.delete(0); // deletes position 0

    System.out.println("\nIs empty?: " + myList.isEmpty()); // return false

    myList.print(); // Linked list: 27, 100, 26, 9, 20, 4, 0, 340, 12, 22

    System.out.println("\nSize: " + myList.size()); // return 10
  }
}
