/*

Write a program to perform the following operations using Java.
1. Read the count of elements from user to create the array.
2. Inttialize the array using user input.
3. Create the functions for the following and call them using a menu based program.
a. Display the array
b. Reverse the array
c. Replace the nth element from the array and print
d. Find the addition of all elements of the array
e. Find the maximum number from the array
f. Print the average of all the elements from the array.
g. Display the even and odd number from the array separately.

*/


package Assignment1;

import java.util.Scanner;

public class assignment1 {

    private int arraySize;  // declaring the user defined size
    private int[] userArray;  // declaring the input array

    public assignment1(int size){
        this.arraySize = size;  // getting the size from the user
        userArray = new int[arraySize];   // creating a dynamic user array
    }

    public void addElements(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < this.arraySize; i++) {
            userArray[i] = scanner.nextInt();
        }
    }

    public void display(){
        System.out.println("The elements of the array are: ");
        for (int element: this.userArray) {
            System.out.print(element + " ");
        }
    }

    public void reverse(){

        int startIndex = 0;
        int endIndex = userArray.length - 1;

        while (startIndex < endIndex) {
            // Swap the values
            int temp = userArray[startIndex];
            userArray[startIndex] = userArray[endIndex];
            userArray[endIndex] = temp;

            // Move indices towards the center
            startIndex++;
            endIndex--;
        }
        System.out.println("\nThe reversed array becomes: " );
        for (int number: this.userArray) {
            System.out.print(number + " ");
        }
    }

    public void replaceNthElement(int position, int element){
        userArray[position] = element;
        display();
    }

    public void maximumArrayElement(){
        int max = 0;
        for (int nos: this.userArray) {
            if(nos>max)
                max = nos;
        }
        System.out.println("\nThe maximum element in the array is: " + max);
    }

    public void sumArrayElements(){
        int additon = 0;
        for (int nos: this.userArray) {
            additon+=nos;
        }
        System.out.println("\nThe addition of array elements is: " + additon);
        System.out.println("\nThe average of the array elements is: " + (additon/this.arraySize));
    }

    public void evenOdd(){
        System.out.println("\nThe even numbers are: ");
        for (int nos: this.userArray) {
            if(nos%2 == 0)
                System.out.print(nos + " ");
        }

        System.out.println("\nThe odd numbers are: ");
        for (int no: this.userArray) {
            if(no%2!=0)
                System.out.print(no + " ");
        }
    }
}



