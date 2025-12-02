public class MyIntStack {
    int ar[];
    int top;
    int capacity;
    int stack_min;

    MyIntStack(int size1) {
        capacity = size1;
        ar = new int[capacity];
        top = -1;
        stack_min = Integer.MAX_VALUE;
    }

    void push(int data) throws MrudusStackOverflowException {
        if (top == capacity - 1) {
            System.out.println("Stack is full");
            throw new MrudusStackOverflowException("Stack is full. Please do not call");
        }
        top++;
        ar[top] = data;
        if (data < stack_min) {
            stack_min = data;
        }
    }

    int pop() throws MrudusStackUnderflowException {
        if (top == -1) {
            System.out.println("Stack is empty");
            throw new MrudusStackUnderflowException("Stack is empty. Please do not call");
        }
        int removed=ar[top];
        top--;
        if (removed == stack_min) {
            //resetting.
            stack_min = Integer.MAX_VALUE;
            for (int i = 0; i <= top; i++) {
                if (ar[i] < stack_min) {
                    stack_min = ar[i];
                }
            }
        }
        return removed;
    }

    int peek() throws MrudusStackUnderflowException {
        //verifying edge-cases
        if (top == -1) {
            throw new MrudusStackUnderflowException("Stack is empty. Cannot peek");
        }
        return ar[top];
    }

    int size() {
        return top + 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    int getMin() throws MrudusStackUnderflowException {
        if (top == -1) {
            throw new MrudusStackUnderflowException("Stack is Empty");

        }
        return stack_min;
    }

    public static void main(String[] args) {
        try {
            MyIntStack s = new MyIntStack(5);
            s.push(20);
            s.push(10);
            s.push(40);
            s.pop();
            s.pop();
            System.out.println("Min: " + s.getMin());
        } catch (MrudusStackOverflowException | MrudusStackUnderflowException e) {
            System.err.println(e.getMessage());
        }
    }
}
