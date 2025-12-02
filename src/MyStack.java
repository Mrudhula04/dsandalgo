public class MyStack
{
    String ar[];
    int top;
    int capacity;
    MyStack(int capacity)
    {
        this.capacity=capacity;
        ar=new String[capacity];
        top=-1;
    }
    void push(String data)
    {
        if(top==capacity-1)
        {
            System.out.println("Stack is full");
            return;
        }
        top++;
        ar[top]=data;
    }
    String pop()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
            return "";
        }
        String res=ar[top];
        top--;
        return res;
    }
    String peek()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
            return "-";
        }
        return ar[top];
    }
    int size()
    {
        return top+1;
    }
    boolean isEmpty()
    {
        return top==-1;
    }
    public void deleteMiddleElement() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        if (size() % 2 == 0) {
            System.out.println("Stack size is even");
            return;
        }
        int mid = size() / 2;
        MyStack tempStack = new MyStack(mid);
        for (int i = 0; i < mid; i++) {
            tempStack.push(pop());
        }
        pop();
        for (int i = 0; i < mid; i++) {
            push(tempStack.pop());
        }
    }
    public void printStack(){
        for(int i=top;i>=0;i--){
            System.out.println(ar[i]);
        }
    }
}