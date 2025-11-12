public class Phone {
    private String[] arr;
    private int capacity;
    private int top;
    public Phone(int size){
        capacity=size;
        arr=new String[size];
        top=-1;

    }
    public void dial(String number){
        if(isFull()){
            System.out.println("recently dialed are full");
            return;
        }

        top++;
        arr[top]=number;
        System.out.println("dialing "+number);
    }

    public void redial(){
        if(isEmpty()){
            System.out.println("recently dialed are full");
            return;
        }
        System.out.println("redialing " + arr[top]);
        }

    public void printCallHistory(){
        if(isEmpty()){
            System.out.println("recently dialed are empty");
            return;
        }
        System.out.println("............. Printing Call History .............");
        for(int i=top;i>=0;i--){
                System.out.println(arr[i]);
            }
        System.out.println(".................................................");
        }

    public boolean isFull(){
        return top==capacity-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public static void main(String[] args)
    {
        Phone p = new Phone(100);
        p.dial("9408733600");
        p.dial("786543212");
        p.dial("987654321");
        p.dial("123456789");

        p.printCallHistory();

        p.redial();

        p.dial("9999999999");

        p.printCallHistory();
        p.redial();
    }
}

