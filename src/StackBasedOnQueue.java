public class StackBasedOnQueue
{
    int capacity;
    ArrayQueue arrayQueue;
    public StackBasedOnQueue(final int capacity)
    {
        this.capacity = capacity;
        this.arrayQueue = new ArrayQueue(capacity);
    }
    public void push(int x) throws MrudusQueueOverflowException, MrudusQueueUnderflowException {
        arrayQueue.enqueue(x);
        for(int i=0;i<arrayQueue.size()-1;i++)
        {
            arrayQueue.enqueue(arrayQueue.dequeue());
        }
    }
    public int pop() throws MrudusQueueUnderflowException
    {
        return arrayQueue.dequeue();
    }
    public int peek() throws MrudusQueueUnderflowException
    {
        return arrayQueue.getFront();
    }
    public boolean isEmpty()
    {
        return arrayQueue.isEmpty();
    }
    public boolean isFull()
    {
        return arrayQueue.isEmpty();
    }

    public static  void main(String[] args)
    {
        try {
            final StackBasedOnQueue stackBasedOnQueue = new StackBasedOnQueue(5);
            stackBasedOnQueue.push(10);
            stackBasedOnQueue.push(20);
            stackBasedOnQueue.push(30);
            stackBasedOnQueue.push(40);
            stackBasedOnQueue.push(50);
            System.out.println("Top element: " + stackBasedOnQueue.peek());
            System.out.println("Popped: " + stackBasedOnQueue.pop());
            System.out.println("Popped: " + stackBasedOnQueue.pop());
            System.out.println("Top element: " + stackBasedOnQueue.peek());
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
