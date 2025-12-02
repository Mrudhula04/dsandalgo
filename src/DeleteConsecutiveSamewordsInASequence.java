public class DeleteConsecutiveSamewordsInASequence {
    public static void main(String[] args) {
        String[] arr = {"ab", "aa","bb", "aa", "ab"};
        deleteConsecutiveSameWords(arr);

        }
    public static void deleteConsecutiveSameWords(String[] arr) {
    MyStack stack = new MyStack(arr.length);
    for(int i=0;i<arr.length;i++) {
        if (!stack.isEmpty() && stack.peek().equals(arr[i])) {
            stack.pop();
        }
        else {
            stack.push(arr[i]);
        }
    }
    System.out.println(stack.size());
}
}
