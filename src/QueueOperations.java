public class QueueOperations {
    public static void main(String[] args) throws MrudusQueueUnderflowException, MrudusQueueOverflowException {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        for (int i = 1; i < 11; i++) {
            try {
                arrayQueue.enqueue(i);
            } catch (MrudusQueueOverflowException e) {
                System.out.println(e.getMessage());
            }
        }
        deleteMiddleElementIn(arrayQueue);

    }

    private static void deleteMiddleElementIn(final ArrayQueue arrayQueue) throws MrudusQueueUnderflowException, MrudusQueueOverflowException {

        if(arrayQueue.size()%2==0){
            System.out.println("THere is no middle element in the queue");
        }
        else{
            int mid=arrayQueue.size()/2;
            ArrayQueue tempQueue = new ArrayQueue(mid);
            for(int i=0;i<mid;i++){
                tempQueue.enqueue(arrayQueue.dequeue());
            }
            arrayQueue.dequeue();
            for(int i=0;i<mid;i++){
                arrayQueue.enqueue(tempQueue.dequeue());
            }
        }
    }
}
