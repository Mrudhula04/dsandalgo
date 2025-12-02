public class ReverseString {
    private char[] arr;
    private int capacity;
    private static int top;
    public ReverseString(int size) {
        capacity = size;
        arr = new char[size];
        top = -1;
    }
    public void push(char ch){
        if(isFull()){
            System.out.println("Stack is full");
            return;
        }
        top++;
        arr[top]=ch;
    }
    public char pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return ' ';
        }
        char ch = arr[top];
        top--;
        return ch;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == capacity - 1;
    }
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString(100);
        runTestcase("Mrudu,Rishi", reverseString);
    }
    public static void runTestcase(String s, ReverseString reverseString)
    {
        System.out.println("Testing: " + s);
        top = -1;
        for (int i = 0; i < s.length(); i++) {
            reverseString.push(s.charAt(i));
        }
        for (int i = s.length()-1; i >= 0; i--) {
            System.out.print(reverseString.pop());
        }
    }
}
