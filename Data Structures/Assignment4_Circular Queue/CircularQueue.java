package ADS_4;

public class CircularQueue {
    int start = 0;
    int end = 0;
    int len;
    private int[] arr;

    public CircularQueue(int size) {
        len = size;
        arr = new int[size];
    }

    public void enqueue(int elem) {
        if (end - start >= len) {
            System.out.println("Queue is full.");
            return;
        }

        arr[end % len] = elem;
        end++;
    }

    public void dequeue() {
        if (end - start == 0) {
            System.out.println("Queue is Empty.");
            return;
        }
        start++;
    }

    public void display() {
        if (end % len - 1 < start) {
            for (int i = start; i < len; i++)
                System.out.println(arr[i] + " ");

            for (int i = 0; i < end % len; i++)
                System.out.println(arr[i] + " ");
        } else {
            for (int i = start; i < end % len; i++) {
                System.out.println(arr[i] + " ");
            }
        }
    }

    public int get(int pos) {
        pos = (start + pos - 1) % len;
        return arr[pos];
    }

    public int countElements() {
        return end - start;
    }

    public boolean isEmpty() {
        return end - start == 0;
    }

    public boolean isFull() {
        return end - start == len;
    }
}





