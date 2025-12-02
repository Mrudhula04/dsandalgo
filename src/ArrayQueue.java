public class ArrayQueue {
    private int[] arr;
    private int front, rear, size, capacity;
    
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    public void push(int x) throws MrudusQueueOverflowException {
        if (isFull()) {
            throw new MrudusStackOverflowException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }
    
    public int pop() throws MrudusStackUnderflowException{
        if (isEmpty()) {
            throw new MrudusStackUnderflowException("Queue is empty");
        }
        int result = arr[front];
        front = (front + 1) % capacity;
        size--;
        return result;
    }
    
    public int peek() throws MrudusStackUnderflowException {
        if (isEmpty()) {
            throw new Mr
        }
        return arr[front];
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        
        queue.push(10);
        queue.push(20);
        queue.push(30);
        
        System.out.println("Front element: " + queue.peek());
        System.out.println("Popped: " + queue.pop());
        System.out.println("Front element: " + queue.peek());
        
        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println("Is full: " + queue.isFull());
    }
}