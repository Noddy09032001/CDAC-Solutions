package Assignment5;

import java.util.ArrayList;

public class LinkedList {
    protected static Node headNode;   // setting the head node of the linked list to be null

    public void insertNodeAtBeginning(int data){
        Node newNode = new Node(data);   // creating the new node for the linked list

        // checking if head node exist or not
        // if not present set the newNode as the headNode else add at the beginning
        if(headNode == null){
            headNode = newNode;
            System.out.println("Head of the linked list created successfully");
        }
        else{
            newNode.next = headNode;  // the next pointer of the newNode points to the headNode
            headNode = newNode;    // the head of the linked list is now the newNode created
            System.out.println("Node inserted successfully");
        }
    }

    public void insertNodeAtEnd(int data){
        Node endNode = new Node(data);  // creating the new node
        // checking if head node exist or not
        // if not present set the newNode as the headNode else add at the beginning

        if(headNode == null){
            headNode = endNode;
            System.out.println("Head of the linked list created successfully\n");
        }
        else{
            // creating a newNode for traversing the list till the end
            // the newNode created points to the head of the linked list so that complete traversal till the end occurs
            Node traversalNode = headNode;
            while(traversalNode.next!=null){
                traversalNode = traversalNode.next;   // making the current node point to the next node
            }
            traversalNode.next = endNode;  // inserting node at the end
            System.out.println("Node inserted at the end successfully\n");
        }
    }

    public void deleteNode(int data){
        // here we need two nodes one for traversal and other to store the previous node as we go on traversing
        // we need the previous node so that the pointer of previous will point to the next node of the node to be deleted
        Node temp = headNode, previousNode = null;

        // If head node itself holds the data to be deleted
        if (temp != null && temp.data == data) {
            headNode = temp.next; // Changed head
            return;
        }

        // Search for the data to be deleted, keep track of the previous node as we need to change temp.next
        while (temp != null && temp.data != data) {
            previousNode = temp;
            temp = temp.next;
        }
        // If data was not present in linked list
        if (temp == null)
            return;

        // Unlink the node from linked list
        previousNode.next = temp.next;
        Node.nodeCount--;
        System.out.println("Node removed from the linked list.\n");
    }

    public void display() throws LinkedListException {
        isEmpty();
        System.out.println("\n===========================================");
        System.out.println("The linked list is: ");
        Node traversal = headNode;
        while(traversal!=null){
            System.out.print(traversal.data + " -> ");
            traversal = traversal.next;
        }
        System.out.println("\n=========================================\n");
    }

    public void isEmpty() throws LinkedListException {
        if(Node.getNodeCount() == 0){
            throw new LinkedListException("The linked list is empty");
        }
    }

}
