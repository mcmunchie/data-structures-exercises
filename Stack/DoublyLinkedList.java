package Stack;

public class DoublyLinkedList {

  // private variables
  private Node head;
  private Node tail;

  public DoublyLinkedList(int data) {
    if (head == null) { // creates first nocd if list is empty
      head = new Node(data); // sets new node to head
      tail = head; // also sets new node to tail
    }
  }

  public int size() { // returns the size of the doubly linked list
    Node cursor = head; // set cursor to head
    int count = 0; // initialize counter

    while (cursor != null) { // check to see if at end of list
      count++; // increment counter
      cursor = cursor.getNext(); // move cursor through the list
    }
    return count; // return the count (i.e. size of list)
  }

  public boolean isEmpty() { // returns true if the list is empty, false otherwise
    if (size() == 0) { // check if size equals 0
      return true; // true if 0
    } else {
      return false; // false otherwise
    }
  }

  public void add(int num) { // adds a node to the end of DLL
    Node node = new Node(num); // creates new node
    Node cursor = tail; // start the cursor at the tail

    if (size() == 0) { // if DLL is empty, create head with new node
      head = node; // sets the node put into the DLL as the head
      tail = node; // sets the node put into the DLL as the tail
    } else {
      cursor.setNext(node); // sets the node at the end of the DLL
      node.setPrev(cursor);

      tail = node; // newnode becomes the tail
    }
  }

  public void insert(int num, int position) { // inserts an item into the doubly linked list
    Node node = new Node(num); // creates node
    Node cursor = head; // cursor used to traverse to position and set to head
    Node cursor2 = head.getNext(); // cursor used to traverse one node ahead of first cursor
    Node cursor3 = tail; // cursor pointing to tail
    int count = 0; // create counter to keep track of positions traversed

    if (position > size() + 1 || position < 0) { // error handing when entered position is less than 0 or greater than
                                                 // the list size (except for plus 1)
      System.out.println("ERROR! This position is not within the list's size.");
    } else {
      if (position == 0) { // checks if the postion is equal to zero, to insert at the head
        node.setNext(cursor); // sets next pointer of new node to cursor
        cursor.setPrev(node); // sets the previous pointer of cursor to new node
        head = node; // sets new node as head
      } else if (position == size()) { // inserts a node at the end of the list
        cursor3.setNext(node); // sets the tail pointer to the new node
        node.setPrev(cursor3); // sets previous pointer from new node to cursor3
        tail = node; // new node is set as the tail
      } else if (count == position - 1 || position == 1) { // inserts at position 1 of DLL
        node.setNext(cursor.getNext()); // sets node to next position
        cursor.setNext(node); // saves node to position entered
        node.setPrev(cursor2.getPrev()); // sets the previous pointer from newnode to cursor2's previous
        cursor2.setPrev(node); // sets previous pointer from cursor2 to node
      } else {
        while (count < position - 1 && cursor != null) { // loop until the previous node in the linked list
          cursor = cursor.getNext(); // traverse the first cursor
          cursor2 = cursor.getNext(); // traverse second cursor
          count++; // increment counter

          if (count == position - 1) {
            node.setNext(cursor.getNext()); // sets node to next position
            cursor.setNext(node); // saves node to position entered
            node.setPrev(cursor2.getPrev()); // sets the previous pointer from newnode to cursor2's previous
            cursor2.setPrev(node); // sets previous pointer from cursor2 to node
          }
        }
      }
    }
  }

  public void delete(int position) { // deletes a node at a specific position
    Node cursor = head; // creates cursor, points to head
    Node cursor2 = head.getNext(); // creates second cursor used to traverse one node ahead of first cursor
    Node cursor3 = tail; // creates third cursor, points to tail
    int count = 0; // creates counter

    if (isEmpty() || size() < 1) { // error handler for deleting if a list is empty
      System.out.println("ERROR! The list is empty.");
    } else if (position > size() || position < 0) { // error handing when entered position is less than 0 or greater
                                                    // than
                                                    // the list size
      System.out.println("ERROR! This position is not within the list's size.");
    } else {
      if (position == 0) { // deleting from the head
        head = cursor2; // sets the head of the list to cursor2
        cursor2.setPrev(null); // sets cursor2 previous pointer to null
        cursor.setNext(null); // sets cursor next pointer to null
      } else if (position == size() - 1) { // deleting from the tail
        while (count != position - 1) { // traverse to the last node -1
          cursor = cursor.getNext(); // traversing the cursor
          count++; // increase counter
          if (count == position - 1) { // deletes node when cursor is at the correct position
            cursor.setNext(null); // cursor sets the next pointer to node to null
            cursor3.setPrev(null); // cursor3 sets the previous pointer to node to null
            tail = cursor; // node of cursor becomes the new tail
          }
        }
      } else {
        while (count != position) { // loop until count equals the position entered
          cursor = cursor.getNext(); // traverse the first cursor
          cursor2 = cursor2.getNext(); // traverse cursor2
          count++; // increment counter
          if (count == position) { // when cursor2 lands on the position entered
            cursor = cursor.getPrev(); // cursor traverses back one to get behind node
            cursor.setNext(cursor2); // sets the node after position to first cursor
            cursor2.setPrev(cursor); // sets cursor2 to cursor
          }
        }
      }
    }
  }

  public void remove(int num) { // removes the first instance of a specified value
    Node cursor = head; // creates cursor to pointing to head
    Node cursor2 = head.getNext(); // creates cursor used to traverse one node ahead of first cursor
    Node cursor3 = tail; // creates cursor pointing to tail
    int value = head.getData(); // saves cursor2 getData()
    int value2 = cursor.getData(); // saves cursor2's getData()
    int count = 0; // creates counter

    if (isEmpty()) { // error handler for removing in an empty list
      System.out.println("ERROR! The list is empty.");
    } else {
      if (cursor.getData() == num) { // when the first cursor is on the specified value
        head = cursor2; // sets the next node after the cursor to the current cursor
        cursor2.setPrev(null); // sets the previous pointer from cursor2 to null
        cursor.setNext(null); // sets the next pointer from cursor to null
      } else {
        while ((value != num && value2 != num) && count < size() && cursor2.getNext() != null) {
          value2 = cursor2.getData(); // when cursor2 lands on value to be removed
          cursor = cursor.getNext(); // traverse cursor
          cursor2 = cursor2.getNext(); // traverse cursor2
          value = cursor2.getData(); // records the getData() from each node that cursor2 traverses over, then stores
                                     // it in value
          count++; // increment counter

          if ((count == (size() - 2)) && (value == num)) { // remove from the tail
            cursor.setNext(null); // sets the next pointer of cursor to null
            cursor3.setPrev(null); // sets the previous pointer of cursor3 to null
            tail = cursor; // cursor becomes the new tail
          }

          else if ((count != (size() - 2)) && ((value == num))) { // removes nodes in the list (not from head, tail or
                                                                  // index 1)
            cursor2 = cursor2.getNext(); // traverses cursor2
            cursor.setNext(cursor2); // sets the node after specified position to first cursor
            cursor2.setPrev(cursor); // sets the previous pointer from cursor2 to cursor
          }

          else if ((count != (size() - 2)) && ((value2 == num))) { // removes the node at index 1
            cursor = cursor.getPrev(); // traverse the cursor back 1
            cursor.setNext(cursor2); // sets the node after specified position to first cursor
            cursor2.setPrev(cursor); // sets the previous pointer from cursor2 to cursor
          }

          else if (cursor2.getNext() == null) { // error handling for a value that is not in the list
            System.out.println("ERROR! The number " + num + " is not in the list!");
          }
        }
      }
    }
  }

  public int sum(Node node) { // recursivly sum the nodes
    if (node.getNext() == null) {
      return node.getData();
    }
    return node.getData() + sum(node.getNext());
  }

  public void sumPrint() { // prints the sum returned from the sum method
    System.out.println("Sum: " + sum(head));
  }

  public void print() { // prints out the linked list
    Node cursor = head;
    while (cursor != null) { // traverse through the entire linked list
      System.out.print(cursor.getData());
      if (cursor.getNext() == null) {
        break;
      }
      System.out.print(", ");
      cursor = cursor.getNext();
    }
  }

  public void ReversePrint() { // prints the list in reverse
    Node cursor = tail;
    while (cursor != null) { // traverse through the linked list using getPrev()
      System.out.print(cursor.getData());
      if (cursor.getPrev() == null) {
        break;
      }
      System.out.print(", ");
      cursor = cursor.getPrev();
    }
    System.out.println();
  }

  public int getHead() { // gets the data from the head node and returns it
    if (size() <= 1) {
      System.out.println("ERROR! Cannot pop off stack.");
    }
    Node cursor = head;
    int value = cursor.getData();
    return value;
  }

  public static void main(String[] args) {
    DoublyLinkedList myList = new DoublyLinkedList(1);

    System.out.println("Is empty?: " + myList.isEmpty()); // check if list is empty, should return false

    myList.add(5); // adding items to the linked list
    myList.add(27);
    myList.add(100);
    myList.add(20);
    myList.add(7);
    myList.add(14);
    myList.add(26);
    myList.add(4);
    myList.add(27);
    myList.add(7);
    myList.add(8);
    myList.add(2);
    myList.add(0);
    myList.add(340);

    System.out.print("Linked List: ");
    myList.print();
    System.out.println("\nSize: " + myList.size()); // print current size of DLL, return 15

    myList.insert(9, 14); // inserts 9 at the tail position
    myList.insert(22, 0); // inserts 22 at the head position (index 0)
    myList.insert(6, 5); // inserts 6 at the fifth position

    myList.remove(2); // removes the first instance of 2
    myList.remove(22); // removes the first instance of 22
    myList.remove(5); // removes the first instance of 5
    myList.remove(45); // removes the first instance of 45, which is out of range

    myList.delete(3); // deletes position 3 of the list
    myList.delete(0); // deletes position 0 of the list
    myList.delete(8); // deletes position 8 of the list

    System.out.println("Head of Doubly Linked List: " + myList.getHead()); // return head of the list, returns 27

    System.out.print("Linked List: ");
    myList.print();
    System.out.print("\nLinked List in reverse: ");
    myList.ReversePrint();

    System.out.println("Size: " + myList.size()); // print current size of DLL, returns 12

    myList.sumPrint(); // prints sum of the list, returns 582
  }
}
