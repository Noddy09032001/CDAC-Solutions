package Assignment6;

import Assignment5.LinkedListException;

public class DoublyLinkedList {
    protected static Node headNode;   // getting the head node of the linked list

    public void insertNodeAtBeginning(int data){
        Node newNode = new Node(data);
        if(headNode == null){
            headNode = newNode;
            newNode.next = null;
            System.out.println("\nNode inserted at the head successfully\n");
        }
        else{
            newNode.next = headNode;
            newNode.previous = null;
            if(headNode!=null){
                headNode.previous = newNode;
            }
            headNode = newNode;
            System.out.println("\nNode inserted at the beginning successfully\n");
        }

    }

    public void insertNodeAtEnd(int data){
        // consider the following sample linked list
        // 1 -> 2 -> 3 -> 4

        Node traversal = headNode;  // assigning the head node for traversal
        Node endNode = new Node(data);  // creating the new node

        while(traversal.next != null){
            traversal = traversal.next;
        }

        // inserting the node at the end
        traversal.next = endNode;
        endNode.previous = traversal;
        System.out.println("\nNode inserted at the end successfully\n");
    }

    public boolean deleteNode(int data){

        // 1 -> 2 -> 3 -> 4
        // need to delete 2 from the linked list

        Node traversal = headNode;  // node used for traversing the linked list
        Node previousNode = null;   // storing the previous node during traversal

        while(traversal.next != null){
            if(traversal.data == data){
                previousNode.next = traversal.next;
                traversal.previous = previousNode;
                Node.nodeCount--;   // decrementing the node count
                return true;
            }
            previousNode = traversal;
            traversal = traversal.next;
        }
        return false;
    }


    public void display() throws doubleLinkedListException {
        isEmpty();
        Node traversal = headNode;
        System.out.println("\n======================================");
        System.out.println("Displaying the elements of the doubly linked list: ");
        while (traversal!=null){
            System.out.print(traversal.data + "->");
            traversal = traversal.next;
        }
        System.out.println("\n=====================================\n");
    }


    public void isEmpty() throws doubleLinkedListException {
        if(Node.getNodeCount() == 0){
            throw new doubleLinkedListException("The linked list is empty");
        }
    }
}


/*

*/