package Assignment5;

public class Node {
    protected int data;
    protected Node next;   // the pointer to the next node
    protected static int nodeCount = 0;

    public Node(int data) {
        this.data = data;  // storing the data in the data section of the linked list
        this.next = null; // setting the null pointer of the linked list to be null
        this.nodeCount++;
    }

    public static int getNodeCount(){
        return nodeCount;
    }
}
