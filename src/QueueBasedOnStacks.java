public class QueueBasedOnStacks
{
    private final int capacity;
    private final MyIntStack stack;
    private final MyIntStack stack1;
    public QueueBasedOnStacks(final int capacity)
    {
        this.capacity = capacity;
        this.stack = new MyIntStack(capacity);
        this.stack1 = new MyIntStack(capacity);
    }

    public void enqueue(int x) throws MrudusStackOverflowException, MrudusStackUnderflowException {
        while(!stack.isEmpty())
        {
            stack1.push(stack.pop());
        }
        stack.push(x);
        while(!stack1.isEmpty())
        {
            stack.push(stack1.pop());
        }
    }

    public int dequeue() throws MrudusStackUnderflowException {
        if(stack.isEmpty())
        {
            throw new MrudusStackUnderflowException("Queue is Empty");
        }
        return stack.pop();
    }

    public int getFront() throws MrudusStackUnderflowException {
        if(stack.isEmpty())
        {
            throw new MrudusStackUnderflowException("Queue is Empty");
        }
        return stack.peek();
    }

    public int getRear() throws MrudusStackUnderflowException, MrudusStackOverflowException {
        if(stack.isEmpty())
        {
            throw new MrudusStackUnderflowException("Queue is Empty");
        }
        while(!stack.isEmpty()){
            stack1.push(stack.pop());
        }
        final int x = stack1.peek();
        while(!stack1.isEmpty())
        {
            stack.push(stack1.pop());
        }
        return x;
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public boolean isFull()
    {
        return stack.size() == capacity;
    }

    public static  void main(String[] args)
    {
        try {
            final QueueBasedOnStacks queueBasedOnStacks = new QueueBasedOnStacks(6);
            queueBasedOnStacks.enqueue(10);
            queueBasedOnStacks.enqueue(20);
            queueBasedOnStacks.enqueue(30);
            queueBasedOnStacks.enqueue(40);
            queueBasedOnStacks.enqueue(50);

            System.out.println("Rear element: " + queueBasedOnStacks.getRear());
            System.out.println("Front element: " + queueBasedOnStacks.getFront());
            System.out.println("Dequeued element: " + queueBasedOnStacks.dequeue());
            System.out.println("Dequeued element: " + queueBasedOnStacks.dequeue());
            System.out.println("Dequeued element: " + queueBasedOnStacks.dequeue());
            queueBasedOnStacks.enqueue(10);
            System.out.println("Rear element: " + queueBasedOnStacks.getRear());
            System.out.println("Front element: " + queueBasedOnStacks.getFront());

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
