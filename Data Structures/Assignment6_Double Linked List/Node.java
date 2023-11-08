package Assignment6;

public class Node {
    protected int data;
    protected Node next;
    protected Node previous;
    protected static int nodeCount = 0;

    public Node(int data){
        this.data = data;
        this.next = null;
        this.previous = null;
        this.nodeCount++;
    }

    public static int getNodeCount() {
        return nodeCount;
    }
}
