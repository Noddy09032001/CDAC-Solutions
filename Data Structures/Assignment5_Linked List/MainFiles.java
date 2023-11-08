package Assignment5;
/*
Write a program to perform the following operations using Java.
1. Read the count of elements from user to create the simple linked list.
2. Create the class and methods for the following and call them using a menu based program and
call them using a loop.
a. Show the contents of linked list
b. Insert the data in the linked list
c. Check how many elements are there in the linked list.
d. Check to see if linked list is empty.
*/


import java.util.Scanner;

import static Assignment5.LeetcodeProblemsFiles.removeDuplicates;
import static Assignment5.LeetcodeProblemsFiles.removeDuplicates2;
import static Assignment5.Node.getNodeCount;

public class MainFiles {
    public static void main(String[] args) {
        System.out.println("\nCode for Assignment 5: Linked List");
        try(Scanner scanner = new Scanner(System.in)){
            boolean running = true;
            LinkedList linkedList = new LinkedList();
            while (running){
                try{
                    System.out.print("\n1. Show the contents of linked list\n" +
                            "2. Insert the data in the linked list\n" +
                            "3. Insert the data at the end of the list\n" +
                            "4. Delete a node from the linked list\n" +
                            "5. Check how many elements are there in the linked list.\n" +
                            "6. Removes duplicates from the linked list.\n" +
                            "7. Check if the linked list is empty or not:\n " +
                            "Your choice: ");
                    switch (scanner.nextInt()){

                        case 1:{
                            // displaying the contents of the linked list
                            linkedList.display();
                            break;
                        }

                        case 2:{
                            // adding nodes to the linked list. Adding nodes in the beginning
                            System.out.println("\nEnter the element to be added to the linked list: ");
                            linkedList.insertNodeAtBeginning(scanner.nextInt());
                            break;
                        }

                        case 3:{
                            System.out.println("\nEnter the element to be added to the end of the linked list: ");
                            linkedList.insertNodeAtEnd(scanner.nextInt());
                            break;
                        }

                        case 4:{
                            System.out.println("Enter the element to be deleted from the linked list: ");
                            linkedList.deleteNode(scanner.nextInt());
                            break;
                        }

                        case 5:{
                            System.out.println("\n============================================================");
                            System.out.println("\nThe number of nodes in the linked list is: " + getNodeCount());
                            System.out.println("\n=============================================================\n");
                            break;
                        }

                        case 6:{
                            System.out.println("Code for removing duplicates from the list: ");
                            removeDuplicates();
                            linkedList.display();
                            break;
                        }

                        case 7:{
                            if(getNodeCount() == 0)
                                System.out.println("\nThe linked list is empty");
                            else
                                System.out.println("\nThe linked list is not empty");
                            break;
                        }

                        default:{
                            System.out.println("\nHere the assignment code ends.");
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
