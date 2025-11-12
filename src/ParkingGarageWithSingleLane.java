public class ParkingGarageWithSingleLane {
    private String[] arr;
    private int capacity;
    private int top;

    public ParkingGarageWithSingleLane(int size) {
        capacity=size;
        arr=new String[size];
        top=-1;
    }

    /* stack operations */

    public void push(String car){
        if(isFull()){
            System.out.println("Parking is full");
            return;
        }
        top++;
        arr[top]=car;
    }
    public String pop(){
        if(isEmpty()){
            System.out.println("Parking is Empty");
            return "";
        }
        top--;
        return arr[top];
    }

    public String peek(){
        if(isEmpty()){
            System.out.println("Parking is Empty");
            return " ";
        }
        return arr[top];
    }

    public boolean isFull(){
        return top==capacity-1;
    }
    public boolean isEmpty(){
        return top == -1;
    }

    /* actual operations */
    public void enter(String car){
        push(car);
    }

    public String whoCanLeaveNow(){
        return peek();
    }

    public String leave(){
        return pop();

    }

    public String whoWillGetTicketFirst() {
       int numberOfTimesToPop=top;
       for(int i=0;i<numberOfTimesToPop;i++){
           pop();
       }
       return peek();
    }


    public static void main(String[] args) {
        ParkingGarageWithSingleLane parkingGarageWithSingleLane = new ParkingGarageWithSingleLane(5);
        parkingGarageWithSingleLane.enter("car1");
        parkingGarageWithSingleLane.enter("car2");
        parkingGarageWithSingleLane.enter("car3");
        parkingGarageWithSingleLane.enter("car4");
        parkingGarageWithSingleLane.leave();
        parkingGarageWithSingleLane.leave();
        System.out.println("Who Can Leave Now: "+parkingGarageWithSingleLane.whoCanLeaveNow());
        parkingGarageWithSingleLane.enter("car5");
        System.out.println("Who will get ticket first: "+parkingGarageWithSingleLane.whoWillGetTicketFirst());



    }
}
