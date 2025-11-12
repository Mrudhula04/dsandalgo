public class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        arr[top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        top--;
        return arr[top];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        if(top == capacity-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(99);
        stack.push(101);
        System.out.println("Is Empty: " + stack.isEmpty());
        System.out.println("Is Full: " + stack.isFull());
        
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Is Empty: " + stack.isEmpty());
        System.out.println("Is Full: " + stack.isFull());
    }


}