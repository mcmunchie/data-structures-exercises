package Hash_table;

public class Hash {

  DoublyLinkedList[] hashArray;

  public Hash(int size) { // constructor for the hash table
    hashArray = new DoublyLinkedList[size];
  }

  public int HashKey(String key) { // hash function for the hash table
    int size = Capacity(); // retreives the size of the list
    int constantHashInt = 73; // constant interger to use in the hashing
    int position = 0; // position tracker
    int strLength = key.length(); // finds the length of the string

    for (int i = 0; i < strLength; i++) { // this will look over each character of the string and convert each
                                          // character to ascii while multiplying the constant with the current
                                          // total poition, this will keep a running total
      position += constantHashInt * position + key.charAt(i); // allows for a word to get different positions
                                                              // based on the order of letters (i.e. flower and
                                                              // plant
                                                              // will not have the same positon in the table)
    }
    return position % size; // mod the position by size of the hash array to keep it inside the limits of
                            // the hasharray
  }

  public void Insert(String key, int value) { // inserts a name and number into the hash table
    int index = HashKey(key); // retrieves the index from hashing
    Node newnode = new Node(key, value); // creates a new node using the name and number
    hashArray[index] = new DoublyLinkedList(null); // creates a new doubly linked list in the index of the hash
                                                   // table
    hashArray[index].add(newnode); // adds the new node at the index of the hash table

    if (LoadFactor() > 0.7) { // checks the load factor and resizes the hash table if load is greater than 0.7
                              // (70%)
      Resize(); // resize the hash array
    }
  }

  public int NumKeys() { // finds and returns the number of keys in the hash table
    int counter = 0;

    for (DoublyLinkedList element : hashArray) { // loop over the hasharray and retrieves the element for each index
      if (element != null) { // if an element is not null
        counter++; // increase counter
      }
    }
    return counter; // returns the number of keys in the hash table
  }

  public void Delete(String key) { // deletes a name and corresponding number from the hash table
    Node node; // stores the node that will be found in the linked list
    int size = Capacity(); // retrieves the size of the current hash array
    int index = 0; // indexing

    while (index < size) { // loop over each index of the hash array
      if (hashArray[index] != null) { // if the index of the hash is not equal to null the loop will continue
        node = hashArray[index].getHead(); // retrieves the node at the indexed location of the hash array

        String name = node.getKey(); // retrieves the key of the node

        if (key == name) { // if the key passed is equal to the name in the array, it will be removed
          hashArray[index] = null;
        }
      }
      index++;
    }
  }

  public int Capacity() { // returns the length of the hash array
    return hashArray.length;
  }

  public double LoadFactor() { // returns the load factor of the hash table
    double size = Capacity(); // retrieves the size of the hash table
    double usedSpaces = NumKeys(); // retrieves the number of keys in the hash table
    double load = usedSpaces / size; // divide the number of keys by the size of the list

    return load;
  }

  public void Resize() {
    Node node; // stores the node that will be found in the linked list
    int size = Capacity(); // retrieves the size of the current hash array
    int index = 0; // indexing
    DoublyLinkedList[] tempHashArray = hashArray; // creates temporary array to store original hash array
    hashArray = new DoublyLinkedList[size * 2]; // doubles the size of the original array

    while (index < size) { // loop over each index of the hash array
      if (tempHashArray[index] != null) { // if the index of the hash is not equal to null the loop will continue
        node = tempHashArray[index].getHead(); // retrieves the node at the indexed location of the hash array
        String key = node.getKey(); // retrieves the name from the node
        int value = node.getValue(); // retrieves the phone number from the node
        Insert(key, value);
      }
      index++;
    }
  }
}
