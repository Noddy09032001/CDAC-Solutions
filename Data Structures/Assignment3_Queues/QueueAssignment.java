package Assignment3;

/*
Write a program to perform the following operations using Java.
1. Read the count of elements from user to create the simple queue using array.
2. Create the class and methods for the following and call them using a menu based program and
call them using a loop.
a. Show the queue
b. Store the data in the queue
c. Access the data from the queue
d. Check how many elements are there in the queue.
e. Check to see if the queue is full?
f. Check to see if queue is empty.
*/

import java.util.Scanner;

public class QueueAssignment {
    private int front;   // the front pointer in the queue
    private int rear;    // the rear pointer in the queue
    private int queueSize;  // getting the user defined queue size
    private int [] queue;   // the queue
    protected int elementCount;   // variable for storing the number of elements in the queue

    // constructor to initialise the parameters of the class
    public QueueAssignment(int queueSize){
        this.queueSize = queueSize;
        queue = new int[this.queueSize];
        this.front = -1;
        this.rear = -1;
        this.elementCount = 0;
    }

    // function returning the count of the elements in the queue
    public int getElementCount() {
        return elementCount;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public boolean isEmpty() throws QueueExceptions{
        if(this.front == -1 && this.rear == -1)  // condition for checking if the queue is empty or not
            throw new QueueExceptions("Queue is empty");
        else
            return false;
    }

    public void isFull(int queueSize) throws QueueExceptions{
        if(this.front == 0 && this.rear == queueSize - 1)  // condition for checking whether the queue is full or not
            throw new QueueExceptions("Queue is full");

    }

    public void enqueue(int element)throws QueueExceptions{
        isFull(queueSize);   // calling the isFull function to validate whether element can be inserted or not

        if(front == -1 && rear == -1){
            front+=1;
            rear+=1;
            queue[rear] = element;
            this.elementCount++;
        }
        else{
            rear+=1;
            queue[rear] = element;
            this.elementCount++;
        }
        System.out.println("Element inserted successfully.");
    }

    public void dequeue() throws QueueExceptions{
        int element;
        isEmpty();          // calling the isEmpty function to validate whether element can be deleted or not
        if(front == rear){
            element = queue[rear];
            front = -1;
            rear = -1;
            this.elementCount--;
            System.out.println("Element removed: " + element);
        }
        else{
            element = queue[front];
            front+=1;
            this.elementCount--;
            System.out.println("Element removed: " + element);
        }
    }

    public void display()throws QueueExceptions{
        isEmpty();
        System.out.println("=================================================");
        System.out.println("\nDisplaying the elements of the queue: ");
        for (int i = front; i <=rear ; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println("\n================================================");
    }

    public void getSpecificElement(int position) throws QueueExceptions {
        if(position < getQueueSize())
            System.out.println("Element at position: " + position + " -> " + queue[position]);
        else{
            throw new QueueExceptions("The following index does not exist");
        }
    }
}
