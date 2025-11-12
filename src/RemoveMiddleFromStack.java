import java.util.Stack;

public class RemoveMiddleFromStack {
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        
        System.out.println("Before: " + stack);
        removeMiddle(stack);
        System.out.println("After: " + stack);
    }
    
    static void removeMiddle(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        int mid = stack.size() / 2;
        
        for (int i = 0; i < mid; i++) {
            temp.push(stack.pop());
        }
        
        stack.pop();
        
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
}