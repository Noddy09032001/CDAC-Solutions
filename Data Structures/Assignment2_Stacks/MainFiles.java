package Assignment2;

import java.util.Scanner;

public class MainFiles {
    public static void main(String[] args) {
        System.out.println("The code for the stacks implementation assignment using arrays: ");
        int size;
        try(Scanner scanner = new Scanner(System.in)){     // auto closing the scanner using the try method
            System.out.println("Enter the size of the stack: ");
            size = scanner.nextInt();
            StacksAssignment newStacks = new StacksAssignment(size);   // passing the user defined stack size in the array
            boolean running = true;
            while (running){
                try{
                    System.out.print("\n1. Display the stack\n" +
                            "2. Push the data on the stack\n" +
                            "3. Pop the data from the stack\n" +
                            "4. Check how many elements are there on the stack.\n" +
                            "5. Check to see if the stack is full?\n" +
                            "6. Check to see if stack is empty. \nYour choice: ");
                    switch (scanner.nextInt()){
                        case 1:{
                            System.out.println("\nDisplaying the elements in the stack: ");
                            newStacks.display();
                            break;
                        }

                        case 2:{
                            System.out.println("\nPushing the elements inside the stack: ");
                            System.out.println("Enter the elements to be pushed: ");
                            newStacks.push(scanner.nextInt());
                            break;

                        }

                        case 3:{
                            System.out.println("\nPopping operation results: ");
                            newStacks.pop();
                            break;
                        }

                        case 4:{
                            System.out.println("The number of elements in the stack: " + newStacks.getElementCount());
                            newStacks.peek();
                            break;
                        }

                        case 5:{
                            boolean answer = newStacks.isEmpty();
                            if(answer == false)
                                System.out.println("The stack is not empty");
                            else
                                System.out.println("Stack is full");
                            break;
                        }

                        case 6:{
                            boolean answer = newStacks.isFull();
                            if(answer == true)
                                System.out.println("The stack is full");
                            else
                                System.out.println("The stack is not full");
                            break;
                        }

                        default:{
                            System.out.println("Exiting from the system");
                            running = false;
                            break;
                        }
                    }
                }
                catch (Exception exception){   // used for catching the exception if any occurring during the program
                    scanner.nextLine();
                    exception.printStackTrace();
                }
            }

        }
    }

}
