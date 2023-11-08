package Assignment6;

import java.util.Scanner;

import static Assignment6.Node.getNodeCount;
import static Assignment6.Node.nodeCount;

public class MainFiles {
    public static void main(String[] args) {
        System.out.println("\nCode for Assignment 6: Doubly Linked List: ");
        try(Scanner scanner = new Scanner(System.in)){
            boolean running = true;
            DoublyLinkedList dll = new DoublyLinkedList();
            while (running){
                try{
                    System.out.println("1. Show the contents of linked list\n" +
                            "2. Insert the data in the linked list\n" +
                            "3. Insert the data at the end of the list\n" +
                            "4. Delete a node from the linked list\n" +
                            "5. Check how many elements are there in the linked list.\n" +
                            "6. Check if the linked list is empty or not.\n" +
                            "Your choice: ");
                    switch (scanner.nextInt()){

                        case 1:{
                            // function to display all the elements of the doubly linked list
                            dll.display();
                            break;
                        }

                        case 2:{
                            System.out.println("\nInserting elements in the linked list from the beginning: ");
                            System.out.println("\nEnter the element to be inserted: ");
                            dll.insertNodeAtBeginning(scanner.nextInt());
                            break;
                        }

                        case 3:{
                            System.out.println("\nInserting elements in the linked list at the end: ");
                            System.out.println("\nEnter the element to be inserted: ");
                            dll.insertNodeAtEnd(scanner.nextInt());
                            break;
                        }

                        case 4:{
                            System.out.println("Enter the element to be deleted from the linked list: ");
                            boolean ans = dll.deleteNode(scanner.nextInt());
                            if(ans == true)
                                System.out.println("The node has been deleted successfully");
                            else
                                System.out.println("The given node does not exist in the linked list");
                            break;
                        }

                        case 5:{
                            System.out.println("\n============================================================");
                            System.out.println("\nThe number of nodes in the linked list is: " + getNodeCount());
                            System.out.println("\n=============================================================\n");
                            break;
                        }

                        case 6:{
                            if(getNodeCount() == 0)
                                System.out.println("\nThe linked list is empty");
                            else
                                System.out.println("\nThe linked list is not empty");
                            break;
                        }

                        default:{
                            System.out.println("\nExiting from the assignment code.");
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
