package Assignment1;

import java.util.Scanner;

public class MainFiles {
    public static void main(String[] args) {

        System.out.println("\nCode for assignment 1: ");
        try(Scanner scanner = new Scanner(System.in)){
            boolean running = true;
            System.out.println("Enter the size of the array: ");
            int size;
            size = scanner.nextInt();

            assignment1 newArray = new assignment1(size);   // passing the user defined stack size in the array
            while (running){
                try{
                    System.out.println("\n1. Add elements in the array \n2. Display the array\n" +
                            "3. Reverse the array\n" +
                            "4. Replace the nth element from the array and print\n" +
                            "5. Find the addition of all elements of the array\n" +
                            "6. Find the maximum number from the array and Print the average of all the elements from the array.\n" +
                            "7. Display the even and odd number from the array separately." + "\nYour choice: ");
                    switch (scanner.nextInt()){
                        case 1:{
                            newArray.addElements();
                            break;
                        }

                        case 2:{
                            newArray.display();
                            break;
                        }

                        case 3:{
                            newArray.reverse();
                            break;
                        }

                        case 4:{
                            int position,element;
                            System.out.println("\nEnter the position of the element to be replaced and the new element: ");
                            newArray.replaceNthElement(scanner.nextInt(), scanner.nextInt());
                            break;
                        }

                        case 5:{
                            newArray.sumArrayElements();
                            break;
                        }

                        case 6:{
                            newArray.maximumArrayElement();
                            break;
                        }

                        case 7:{
                            newArray.evenOdd();
                            break;
                        }

                        default:{
                            System.out.println("Exiting from the system");
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
