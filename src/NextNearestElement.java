public class NextNearestElement {
        public static void main(String[] args) {
            int[] arr = {4, 5, 2, 25};
            try {
                printNNE(arr);
            } catch (MrudusStackOverflowException | MrudusStackUnderflowException e) {
                System.out.println(e.getMessage());
            }
    }
    private static void printNNE(int[] arr) throws MrudusStackOverflowException, MrudusStackUnderflowException {
        int[] result = new int[arr.length];
        MyIntStack s = new MyIntStack(arr.length);

        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && s.peek() >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = s.peek();
            }
            s.push(arr[i]);

        }


        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " --> " + result[i]);
        }
    }
}