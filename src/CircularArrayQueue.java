public class CircularArrayQueue {
    // fixed-size array
    private final int[] arr;
    // index of front element
    private int front;
    // current number of elements
    private int size;
    // maximum capacity
    private final int capacity;

    public CircularArrayQueue(int cap) {
        capacity = cap;
        arr = new int[capacity];
        front = 0;
        size = 0;
    }

    // Insert an element at the rear
    public void enqueue(int x) {
        if (size == capacity) {
            System.out.println("Queue is full!");
            return;
        }
        int rear = (front + size)%capacity;
        System.out.println("While pushing "+x+" front is "+front+" size is "+size+", so rear ="+rear);
        arr[rear] = x;
        size++;
        System.out.println("At the end of push, now the size is "+size);
    }

    // Remove an element from the front
    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int res = arr[front];
        front = (front + 1)%capacity;
        System.out.println("After popping "+res+" front is "+front);
        size--;
        System.out.println("At the end of pop, now the size is "+size);
        return res;
    }

    // Get the front element
    public int getFront() {
        if (size == 0) return -1;
        return arr[front];
    }

    // Get the rear element
    public int getRear() {
        if (size == 0) return -1;
        int rear = (front + size - 1)%capacity;
        return arr[rear];
    }

    public static void main(String[] args) {
        int x3 = 4;
        System.out.println(x3);
        x3^= 1;
        System.out.println(x3);
        CircularArrayQueue q = new CircularArrayQueue(5);
        for (int i = 1; i <= 8; i++)
        {
            q.enqueue(i*10);
        }
        for (int i = 1; i <= 8; i++)
        {
            q.dequeue();
        }
        System.out.println(q.getFront() + " " + q.getRear());
        q.dequeue();
        System.out.println(q.getFront() + " " + q.getRear());
        q.enqueue(40);
        System.out.println(q.getFront() + " " + q.getRear());
    }
}