public class DeleteMiddleElement {

    public static void main(String[] args) {
        runTestCaseWithSize(4);
        runTestCaseWithSize(5);
    }

    private static void runTestCaseWithSize(int size) {
        MyStack stack = new MyStack(size);
        for (int i = 0; i < size; i++) {
            stack.push(i+1 + "");
        }
        stack.deleteMiddleElement();
        stack.printStack();
    }
}