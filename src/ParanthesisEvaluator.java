public class ParanthesisEvaluator {
    private char[] arr;
    private int capacity;
    private static int top;
    private static int Count;


    public ParanthesisEvaluator(int size) {
        capacity = size;
        arr = new char[size];
        top = -1;
        Count = 0;
    }

    public void type(char ch) {
            if (ch == '(') {
                if (isFull()) {
                    System.out.println("stack is full");
                    return;
                }
                top++;
                arr[top] = ch;
                //System.out.print(ch);
            }
            else if (ch == ')') {
                if (isEmpty()) {
                    //System.out.println("No matching '(' for ')'");
                    Count++;
                } else {
                    //System.out.println("Deleted: " + arr[top]); // pop
                    top--;
                }
            }
    }
    public boolean evaluate()
    {
        if (isEmpty() && Count==0) {
            System.out.println("All parentheses matched ");
            return true;
        }
        else{
            System.out.println("Unbalanced: extra ')' remaining ");
            return false;
        }

    }
    public boolean isFull(){
        return top==capacity-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }


    public static void main(String[] args) {
        ParanthesisEvaluator paranthesisEvaluator = new ParanthesisEvaluator(10);
        runTestcase("()", paranthesisEvaluator);
        runTestcase("(()", paranthesisEvaluator);
        runTestcase("((())", paranthesisEvaluator);
        runTestcase("((4+3)*(5+6))", paranthesisEvaluator);
        runTestcase("))))", paranthesisEvaluator);
        runTestcase("", paranthesisEvaluator);
        runTestcase("()))))", paranthesisEvaluator);
        runTestcase("(4+3)*(5+6)", paranthesisEvaluator);
        System.out.println("---------------------------------------------------------------------");
    }

    public static void runTestcase(String s, ParanthesisEvaluator paranthesisEvaluator)
    {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Testing: " + s);
        top = -1;
        Count = 0;
        for (int i = 0; i < s.length(); i++) {
            paranthesisEvaluator.type(s.charAt(i));
        }
        paranthesisEvaluator.evaluate();
    }
}