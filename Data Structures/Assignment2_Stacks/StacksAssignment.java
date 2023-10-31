package Assignment2;

/*
Write a program to perform the following operations using Java.
1. Read the count of elements from user to create the stack using array.
2. Create the class and functions for the following and call them using a menu based program.
a. Display the stack
b. Push the data on the stack
c. Pop the data from the stack
d. Check how many elements are there on the stack.
e. Check to see if the stack is full?
f. Check to see if stack is empty.

*/


import java.util.Scanner;

public class StacksAssignment {
    private int top = -1;  // variable to access the top and pop element of the stack
    private int[] stacks;   // the stacks array implementation
    private int stackSize;   // size of the stack getting from the user
    protected int elementCount;

    public StacksAssignment(int stackSize) {
        this.stackSize = stackSize;
        stacks = new int[stackSize];     // initialising the stack array size according to the given user input
        this.elementCount = 0;
    }

    public int getElementCount() {
        return elementCount;
    }

    // defining the methods of the stack

    public void display() throws stacksException{
        isEmpty();
        int x = top;   // assigning the value of top to another variable for traversing the entire stack
        System.out.println("\n==========================================================");
        System.out.println("The elements in the stack are as follows: ");
        while(x>=0){
            System.out.print(stacks[x] + "->");
            x--;
        }
        System.out.println("\n==========================================================");
    }

    public boolean isEmpty() throws stacksException {
        if(top == -1)   // if the value of top is 0 that means the stack has no elements in it
            //return true;
            throw new stacksException("Queue is empty");
        return false;
    }

    public boolean isFull(){
        if(top > this.stackSize)  // if the value of top goes beyond the stack size then the stack has exceeded its size
            return true;
        return false;
    }

    public void push(int element) throws stacksException {
        if(top>this.stackSize)
            //System.out.println("Stack overflow. Element cannot be inserted");
            throw new stacksException("Stack overflow. Element cannot be inserted");  // throwing an exception
        else{
            stacks[++top] = element;   // inserting the element and incrementing the value of top
            System.out.println("Element inserted successfully");
            this.elementCount++;
        }
    }

    public void pop(){
        // pop method removes the top most element from the stack
        System.out.println("\nThe popped out element is: " + stacks[top--]);  // getting the top element and decrementing the value of top
        this.elementCount--;
    }

    public void peek(){
        // peek method just displays the top most element from the stack
        System.out.println("\nThe top most element in the stack is: " + stacks[top]);  // displays the top most element
    }

}
