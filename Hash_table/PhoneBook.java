package Hash_table;

public class PhoneBook {

    // private variable(s)
    private Hash myHash;

    public PhoneBook(int size) { // constructor for the phonebook
        myHash = new Hash(size);
    }

    public void Insert(String name, int number) { // inserts a contact into the phonebook
        myHash.Insert(name, number);
    }

    public void Retrieve(String key) { // retrieves a name and phone number from the phone book
        Node node; // stores the node that will be found in the linked list
        int size = myHash.Capacity(); // retrieves the size of the current hash array
        int index = 0;

        while (index < size) { // loop over each index of the hash array
            if (myHash.hashArray[index] != null) { // if the index of the hash is not equal to null the loop will
                                                   // continue
                node = myHash.hashArray[index].getHead(); // retrieves the node at the indexed location of the hash
                                                          // array

                String name = node.getKey(); // retrieves the name from the node
                int number = node.getValue(); // retrieves the phone number from the node

                if (key == name) {
                    System.out.println("...Calling: " + name + " " + "at " + number);
                }
            }
            index++;
        }
    }

    public void Delete(String name) { // deletes a name and number from the hash table
        myHash.Delete(name);
    }

    public void Print() {
        Node node; // stores the node that will be found in the linked list
        int size = myHash.Capacity(); // retrieves the size of the current hash array
        int index = 0;

        while (index < size) { // loop over each index of the hash array
            if (myHash.hashArray[index] != null) { // if the index of the hash is not equal to null the loop will
                                                   // continue
                node = myHash.hashArray[index].getHead(); // retrieves the node at the indexed location of the hash
                                                          // array

                String name = node.getKey(); // retrieves the name from the node
                int number = node.getValue(); // retrieves the phone number from the node
                System.out.println("Contact name: " + name + ", " + "Phone Number: " + number);
            }
            index++;
        }
        System.out.println("Load Factor: " + myHash.LoadFactor());
    }
}
