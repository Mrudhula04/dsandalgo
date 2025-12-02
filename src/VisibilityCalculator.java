import java.util.Arrays;
import java.util.Stack;

public class VisibilityCalculator {

    // Function to compute Previous Greater Element for each index
    static int[] previousGreater(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];

        Arrays.fill(prev, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) prev[i] = st.peek();
            st.push(i);
        }
        return prev;
    }

    // Function to compute Next Greater Element for each index
    static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] next = new int[n];
        Arrays.fill(next, n);
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (!st.isEmpty()) next[i] = st.peek();
            st.push(i);
        }
        return next;
    }

    static void print(int[] arr)
    {
        for(int i=0;i<arr.length;++i)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static int maxPeople(int[] arr) {
        int n = arr.length;

        // Compute Previous Greater and Next Greater
        int[] prev = previousGreater(arr);
        int[] next = nextGreater(arr);
        print(prev);
        print(next);

        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            int leftBound = (prev[i] == -1 ? 0 : prev[i] + 1);
            int rightBound = (next[i] == n ? n - 1 : next[i] - 1);

            // Range size gives how many people visible including self
            int count = rightBound - leftBound + 1;

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(maxPeople(arr));
    }
}