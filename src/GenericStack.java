public class GenericStack {
    private String[] arr;
    private int top;
    private int capacity;

    public GenericStack(int size) {
        arr = new String[size];
        capacity = size;
        top = -1;
    }

    public void push(String s1) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        arr[top] = s1;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return "-1";
        }
        top--;
        return arr[top];
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return "-1";
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
        GenericStack stack = new GenericStack(5);

        stack.push("Mrudu");
        stack.push("devansh");
        stack.push("sridevi");
        stack.push("sneha");
        stack.push("durga");
        System.out.println("Is Empty: " + stack.isEmpty());
        System.out.println("Is Full: " + stack.isFull());

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Is Empty: " + stack.isEmpty());
        System.out.println("Is Full: " + stack.isFull());
    }


}