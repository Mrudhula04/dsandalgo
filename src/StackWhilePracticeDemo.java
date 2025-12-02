public class StackWhilePracticeDemo {
    public static void main(String[] args) {
        try {
            MyIntStack stack = new MyIntStack(5);
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            stack.push(50);
            
            xyz(stack);
        } catch (MrudusStackOverflowException | MrudusStackUnderflowException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void xyz(MyIntStack stack) throws MrudusStackUnderflowException {
        int x = Integer.MIN_VALUE;
        while(!stack.isEmpty()) {
            if(stack.peek() > x) {
                x = stack.peek();
            }
            stack.pop();
        }
        System.out.println("Maximum element: " + x);
    }
}
