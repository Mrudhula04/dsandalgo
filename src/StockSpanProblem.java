public class StockSpanProblem {
    public static void main(String[] args) {
        try {
            int[] arr = {100, 80, 60, 70, 75, 85};
            Span(arr);
        }
        catch(MrudusStackUnderflowException | MrudusStackOverflowException e){
            System.err.println(e.getMessage());
        }
    }
    public static void Span(int[] arr) throws MrudusStackUnderflowException, MrudusStackOverflowException {
        MyIntStack s = new MyIntStack(arr.length);
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = i + 1;
            } else {
                result[i] = i - s.peek();
            }
            s.push(i);
            System.out.println(arr[i] + " --> " + result[i]);
        }
    }

}
