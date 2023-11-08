package ADS_4;

import java.util.Scanner;

//        a. Show the contents of circular queue
//        b. Enqueue the data in the circular queue
//        c. Access the data from the circular queue
//        d. Check how many elements are there in the circular queue.
//        e. Check to see if the circular queue is full?
//        f. Check to see if circular queue is empty.

public class ADS {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Circular LinkedList");
            System.out.print("Enter no of elements to be stored in the queue: ");
            CircularQueue q = new CircularQueue(in.nextInt());
            boolean running = true;
            while (running) {
                System.out.println("1. Show the contents of circular queue \n2. Enqueue the data in the circular queue" +
                        " \n3. Access the data from the circular queue \n4. Check how many elements are there in the circular queue." +
                        " \n5. Check to see if the circular queue is full? \n6. Check to see if circular queue is empty? \n0. Exit");
                switch (in.nextInt()) {
                    case 1:
                        q.display();
                        break;
                    case 2:
                        System.out.print("Enter element: ");
                        q.enqueue(in.nextInt());
                        break;
                    case 3:
                        System.out.print("Enter the position: ");
                        System.out.println(q.get(in.nextInt()));
                        break;
                    case 4:
                        System.out.println("Total elements in the queue: " + q.countElements());
                        break;
                    case 5:
                        System.out.println(q.isFull());
                        break;
                    case 6:
                        System.out.println(q.isEmpty());
                        break;
                    case 0:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                }
            }
        }
    }
}
