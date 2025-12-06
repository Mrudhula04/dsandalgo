import java.util.HashSet;

public class ArrayQueue {
    private final int[] arr;
    private final int capacity;
    private int front, rear, size;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;

    }

    public int size() {
        return size;
    }

    public void enqueue(int x) throws MrudusQueueOverflowException {
        if (isFull()) {
            throw new MrudusQueueOverflowException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }

    public int dequeue() throws MrudusQueueUnderflowException {
        if (isEmpty()) {
            throw new MrudusQueueUnderflowException("Queue is empty");
        }
        int result = arr[front];
        front = (front + 1) % capacity;
        size--;
        return result;
    }

    public int getFront() throws MrudusQueueUnderflowException {
        if (isEmpty()) {
            throw new MrudusQueueUnderflowException("Queue is empty");
        }
        return arr[front];
    }
    public int getRear() throws MrudusQueueUnderflowException {
        if(isEmpty()){
            throw new MrudusQueueUnderflowException("Queue is empty");
        }
        return arr[rear];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void reverse() throws MrudusQueueUnderflowException {
        if(isEmpty()) {
            throw new MrudusQueueUnderflowException("Queue is full");
        }
        int j=rear;
        int  i=front;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }

    public void print()
    {
        for(int i=front;i<=rear;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public int getMax() throws MrudusQueueUnderflowException
    {
        if(isEmpty()) {
            throw new MrudusQueueUnderflowException("Queue is empty");
        }
        int max=Integer.MIN_VALUE;
        for(int i=front;i<=rear;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    public int getMin()
    {
        int min=Integer.MAX_VALUE;
        for(int i=front;i<=rear;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }

    public int getUniqueElementsCount()
    {
        HashSet<Integer> s=new HashSet<Integer>();
        for(int i=front;i<=rear;i++){
            s.add(arr[i]);
        }
        return s.size();
    }

    public static void main(String[] args) {
        try {
            ArrayQueue queue = new ArrayQueue(5);

            queue.enqueue(10);
            queue.enqueue(10);
            queue.enqueue(30);
            queue.enqueue(30);
            queue.enqueue(10);

            queue.print(); //10 20 30 40 50

            System.out.println("Front element: " + queue.getFront());
            System.out.println("Popped: " + queue.dequeue());
            System.out.println("Max: "+queue.getMax());
            System.out.println("Min: "+queue.getMin());
            System.out.println("UniqueElementsCount: "+queue.getUniqueElementsCount());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}