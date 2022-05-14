package Stack;

import java.util.*;

public class PezDispenser {

    private Stack mystack = null; // implement stack to create pez dispenser

    public PezDispenser(int data) {
        this.mystack = new Stack(data);
    }

    public int random() { // generates a random integer
        Random rand = new Random();
        int RandomNum = rand.nextInt(101);
        return RandomNum;
    }

    public void push() { // pushes an item into pez dispenser
        mystack.push(random());
    }

    public int pop() { // pops an item out of the pez dispenser
        return mystack.pop();
    }

    public void print() { // prints all items in the pez dispenser
        System.out.print("Pez Dispenser: ");
        mystack.print();
    }

    public void ReversePrint() { // prints all items in the pez dispenser but in reverse
        System.out.print("\nPez Dispenser in Reversed: ");
        mystack.ReversePrint();
    }

    public void sum() { // sums all items in the pez dispenser
        mystack.sum();

    }
}
