public class PostfixToPrefix {
    private String[] arr;
    private int top;
    private int capacity;

    public PostfixToPrefix(int size) {
        capacity = size;
        arr = new String[size];
        top = -1;
    }

    public void push(String input) {
        if (isFull()) {
            System.out.println("Stack is Overflow");
            return;
        }
        top++;
        arr[top] = input;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is Underflow");
            return null;
        }
        String result = arr[top];
        top--;
        return result;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is Underflow");
            return null;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isOperator(char ch) {
        return ch == '+' || ch == '*' || ch == '/' || ch == '-' || ch == '^';
    }

    public String convertToPrefix(String postfix) {
        for (int i = 0; i < postfix.length(); i++) {
            char temp = postfix.charAt(i);
            if (isOperator(temp)) {
                String right = pop();
                String left = pop();
                String result = temp + left + right;
                push(result);
            } else {
                push(" "+temp);
            }
        }
        return peek();
    }

    public static void main(String[] args) {
        PostfixToPrefix ptp = new PostfixToPrefix(100);
        System.out.print(ptp.convertToPrefix("76+942/-*"));
    }
}