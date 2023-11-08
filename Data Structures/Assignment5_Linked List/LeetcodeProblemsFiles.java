package Assignment5;

import java.util.ArrayList;

import static Assignment5.LinkedList.headNode;

public class LeetcodeProblemsFiles {
    // solution for the leetcode problem number 83
    public static void removeDuplicates(){
        // this code works for both sorted and unsorted linked lists
        ArrayList<Integer> checker = new ArrayList<>();
        Node current = headNode, previous = null;
        while(current!=null){
            if(checker.contains(current.data)){
                previous.next = current.next;          // checking if the data is already present in the linked list or not
            }
            else{
                checker.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    public static void removeDuplicates2(){
        // consider the following sorted linked list for the above problem
        // 1-1-2-3-3-4--4-5-
        // brute force approach = use two while loops

        Node currentNode = headNode;
        Node previousNode = new Node(0);   // storing the previous node
        previousNode = headNode;

        while(currentNode.next!=null){
            int value = currentNode.data;

            /*Node nextNode = currentNode.next;   // node after the current Node
            while(nextNode.next!=null){
                if(nextNode.data == currentNode.data){
                    previousNode.next = nextNode.next;
                }
                previousNode = nextNode.next;
                nextNode = nextNode.next;
            }
            currentNode = currentNode.next;*/
        }
    }
}
