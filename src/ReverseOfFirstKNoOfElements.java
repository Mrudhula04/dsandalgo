public class ReverseOfFirstKNoOfElements {
    public static void main(String[] args){
        try {
            ArrayQueue queue = new ArrayQueue(10);
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
            queue.enqueue(6);
            queue.enqueue(7);
            queue.enqueue(8);
            queue.enqueue(9);
            queue.enqueue(10);
            printReverseOfFirstKNoOfElements(queue, 3);
            queue.print();
        }
        catch ( MrudusQueueUnderflowException | MrudusStackOverflowException | MrudusQueueOverflowException | MrudusStackUnderflowException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void printReverseOfFirstKNoOfElements(ArrayQueue queue, int k) throws MrudusQueueUnderflowException, MrudusStackOverflowException, MrudusQueueOverflowException, MrudusStackUnderflowException{
       MyIntStack stack=new MyIntStack(k);
       ArrayQueue queue2=new ArrayQueue(queue.size()-k);
        for(int i=0;i<k;i++){
            stack.push(queue.dequeue());
        }
        while(!queue.isEmpty()){
            queue2.enqueue(queue.dequeue());
        }
        while(!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }
        while(!queue2.isEmpty()){
            queue.enqueue(queue2.dequeue());
        }

    }

}
