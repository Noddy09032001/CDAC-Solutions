package Assignment3;

import java.util.Scanner;

public class MainFiles {
    public static void main(String[] args) {
        System.out.println("\nCode for the Queue Assignment 3: ");
        try(Scanner scanner = new Scanner(System.in)){
            boolean running = true;
            System.out.print("Enter the size of the queue: ");
            int size = scanner.nextInt();
            QueueAssignment newQueue = new QueueAssignment(size);
            while(running){
                try{
                    System.out.print("\n1. Display the Queue \n2. Add the elements in the queue " +
                            "\n3. Access an element from the queue \n4. Check number of elements in the queue " +
                            "\n5. Check if the queue is full  \n6. Check if the queue is empty  \n7. Dequeue element" +
                            "\n Your choice: ");
                    switch(scanner.nextInt()){
                        case 1:{
                            newQueue.display();
                            break;
                        }

                        case 2:{
                            System.out.println("Entering the elements into the queue: ");
                            System.out.println("\nEnter the element: ");
                            newQueue.enqueue(scanner.nextInt());
                            break;
                        }

                        case 3:{
                            int position;
                            System.out.println("Enter the position of the element to be accessed: ");
                            position = scanner.nextInt();
                            newQueue.getSpecificElement(position);
                            break;
                        }

                        case 4:{
                            System.out.println("The number of elements in the queue are: " + newQueue.getElementCount());
                            break;
                        }

                        case 5:{
                            System.out.println("Checking if the queue is empty");
                            boolean answer = newQueue.isEmpty();
                            if(answer == false)
                                System.out.println("Queue is not empty");
                            break;
                        }

                        case 6:{
                            System.out.println("Checking if the queue is full");
                            newQueue.isFull(newQueue.getElementCount());

                            break;
                        }

                        case 7:{
                            System.out.println("\nRemoving the element from the queue: ");
                            newQueue.dequeue();
                            break;
                        }

                        default:{
                            System.out.println("Exiting the system");
                            running = false;
                            break;
                        }
                    }
                }
                catch (Exception exception){
                    scanner.nextLine();
                    exception.printStackTrace();
                }
            }
        }
    }
}
