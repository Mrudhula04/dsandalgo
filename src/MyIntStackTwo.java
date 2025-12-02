public class MyIntStackTwo {

    private MyIntStack mainStack;
    private MyIntStack minStack;

    public MyIntStackTwo(int size) {
        mainStack = new MyIntStack(size);
        minStack  = new MyIntStack(size);
    }
    public void push(int x)
            throws MrudusStackOverflowException, MrudusStackUnderflowException {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public int pop() throws MrudusStackUnderflowException {

        int removed = mainStack.pop();

        if (!minStack.isEmpty() && removed == minStack.peek()) {
            minStack.pop();
        }

        return removed;
    }

    public int peek() throws MrudusStackUnderflowException {
        return mainStack.peek();
    }

    public int getMin() throws MrudusStackUnderflowException {
        return minStack.peek();
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }
    public static void main(String[] args) {
        try {
            MyIntStackTwo s = new MyIntStackTwo(5);
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
