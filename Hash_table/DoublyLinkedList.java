package Hash_table;

public class DoublyLinkedList {

  // private variables
  private Node head;
  private Node tail;

  // constructor
  public DoublyLinkedList(Node newnode) {
    if (head == null) { // creates first node if list is empty
      head = newnode; // sets head to newnode
      tail = head; // also sets tail to newnode
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

  public void add(Node newnode) { // adds a node to the doubly linked list
    Node cursor = tail; // start the cursor at the tail

    if (size() == 0) { // if the linked list is empty, create head with current node
      head = newnode; // sets the node put into the DLL as the head
      tail = newnode; // sets the node put into the DLL as the tail
    } else {
      cursor.setNext(newnode); // sets the node at the end of the DLL
      newnode.setPrev(cursor); // sets the newnode's previous pointer to the cursor
      tail = newnode; // newnode becomes the tail
    }
  }

  public void insert(Node newnode, int position) { // inserts an item into the doubly linked list
    Node cursor = head; // cursor used to traverse to position and points to the head
    Node cursor2 = head.getNext(); // cursor used to traverse one node ahead of first cursor
    Node cursor3 = tail; // cursor pointing to the tail
    int count = 0; // create counter to keep track of positions traversed

    if (position > size() + 1 || position < 0) { // error handing when entered position is less than 0 or greater than
                                                 // the list size (except for plus 1)
      System.out.println("ERROR! This position is not within the list's size.");
    } else {
      if (position == 0) { // checks if the postion is equal to zero, to insert at the head
        newnode.setNext(cursor); // sets next pointer of new node to cursor
        cursor.setPrev(newnode); // sets previous pointer of cursor to new node
        head = newnode; // sets new node as head
      } else if (position == size()) { // inserts a node at the end of the list
        cursor3.setNext(newnode); // sets the tail pointer to the new node
        newnode.setPrev(cursor3); // sets previous pointer from new node to cursor3
        tail = newnode; // new node is set as the tail
      } else if (count == position - 1 || position == 1) { // inserts at position 1 of list
        newnode.setNext(cursor.getNext()); // sets node to next position
        cursor.setNext(newnode); // saves node to position entered
        newnode.setPrev(cursor2.getPrev()); // sets the previous pointer from newnode to cursor2's previous
        cursor2.setPrev(newnode); // sets previous pointer from cursor2 to node
      } else {
        while (count < position - 1 && cursor != null) { // loop until the previous node in the linked list
          cursor = cursor.getNext(); // traverse the first cursor
          cursor2 = cursor.getNext(); // traverses second cursor
          count++; // increment counter

          if (count == position - 1) {
            newnode.setNext(cursor.getNext()); // sets node to next position
            cursor.setNext(newnode); // saves node to position entered
            newnode.setPrev(cursor2.getPrev()); // sets the previous pointer from newnode to cursor2's previous
            cursor2.setPrev(newnode); // sets previous pointer from cursor2 to node
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
    }

    else if (position > size() || position < 0) { // error handing when entered position is less than 0 or greater than
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

  public void remove(String key) { // removes the first instance of a specified key value
    Node cursor = head; // creates cursor pointing to head
    Node cursor2 = head.getNext(); // cursor used to traverse one node ahead of first cursor
    Node cursor3 = tail; // creates cursor pointing to tail
    String value = head.getKey(); // saves cursor2 getData()
    String value2 = cursor.getKey(); // saves cursor2's getData()
    int count = 0; // creates counter

    if (isEmpty()) { // error handler for removing in an empty list
      System.out.println("ERROR! The list is empty.");
    } else {
      if (cursor.getKey() == key && cursor.getNext() == null) {
        head = null;
      } else if (cursor.getKey() == key) { // when the first cursor is on the specified value
        head = cursor2; // sets the next node after the cursor to the current cursor
        cursor2.setPrev(null); // sets the previous pointer from cursor2 to null
        cursor.setNext(null); // sets the next pointer from cursor to null
      } else {
        while ((value != key && value2 != key) && count < size() && cursor2.getNext() != null) {
          value2 = cursor2.getKey(); // when cursor2 lands on value to be removed
          cursor = cursor.getNext(); // traverse the first cursor
          cursor2 = cursor2.getNext(); // traverse cursor2
          value = cursor2.getKey(); // records the getData() from each node that cursor2 traverses over, then store
                                    // it in value
          count++; // increment counter

          if ((count == (size() - 2)) && (value == key)) { // remove from the tail
            cursor.setNext(null); // sets the next pointer of cursor to null
            cursor3.setPrev(null); // sets the previous pointer of cursor3 to null
            tail = cursor; // cursor becomes the new tail
          }

          else if ((count != (size() - 2)) && ((value == key))) { // removes nodes in the list (not from head, tail, or
                                                                  // index 1)
            cursor2 = cursor2.getNext(); // traverse cursor2
            cursor.setNext(cursor2); // sets the node after specified position to first cursor
            cursor2.setPrev(cursor); // sets the previous pointer from cursor2 to cursor
          }

          else if ((count != (size() - 2)) && ((value2 == key))) { // removes the node at index 1
            cursor = cursor.getPrev(); // traverse the cursor back 1
            cursor.setNext(cursor2); // sets the node after specified position to first cursor
            cursor2.setPrev(cursor); // sets the previous pointer from cursor2 to cursor
          }

          else if (cursor2.getNext() == null) { // error handling for a value that is not in the list
            System.out.println("ERROR! The number " + key + " is not in the list.");
          }
        }
      }
    }
  }

  public Node NodeFind(String key) { // finds a node in the linked list and returns the node
    Node cursor = head; // cursor is set to head
    String value = head.getKey(); // gets the key of the head node and stores it in value

    if (isEmpty() == true) { // returns null if list is empty
      return null;
    } else {
      while (value != key && cursor.getNext() != null) { // finds node equal to key value and next node is not null
        value = cursor.getKey(); // gets the key of the node
        cursor = cursor.getNext(); // gets the next item in the list
        if (value == key) {
          return cursor;
        }
      }
      return null;
    }
  }

  public void print() { // prints out the linked list
    Node cursor = head;
    while (cursor != null) { // traverse through the entire linked list using getNext()
      System.out.print(cursor.getKey());
      System.out.print(' ');
      System.out.print(cursor.getValue());
      System.out.print(", ");
      cursor = cursor.getNext();
    }
    System.out.println();
  }

  public void ReversePrint() { // prints the list in reverse
    Node cursor = tail;
    while (cursor != null) { // traverse through the linked list using getPrev()
      System.out.print(cursor.getKey());
      System.out.print(' ');
      System.out.print(cursor.getValue());
      System.out.print(", ");
      cursor = cursor.getPrev();
    }
    System.out.println();
  }

  public Node getHead() { // gets the head node in a linked list
    Node cursor = head;
    if (size() >= 1 && cursor != null) { // returns the head if size of the list is greater than or equal to 1
      return head;
    }
    return null;
  }
}
