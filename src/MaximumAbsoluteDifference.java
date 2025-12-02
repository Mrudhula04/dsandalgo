public class MaximumAbsoluteDifference {
    public static void main(String[] args) {
        try {
            int[] arr = {2, 4, 8, 7, 7, 9, 3};
            System.out.println(maxArr(arr, arr.length));
        } catch (MrudusStackOverflowException | MrudusStackUnderflowException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int maxArr(int[] arr, int n)
            throws MrudusStackOverflowException, MrudusStackUnderflowException {

        int mxDiff = 0;
        int leftSmaller, rightSmaller;

        MyIntStack st = new MyIntStack(n);

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int ind = st.peek();
                rightSmaller = arr[i];
                st.pop();

                if (!st.isEmpty()) {
                    leftSmaller = arr[st.peek()];
                } else {
                    leftSmaller = 0;
                }

            mxDiff = Math.max(mxDiff, Math.abs(rightSmaller - leftSmaller));
            }
            st.push(i);
        }
        
        if (!st.isEmpty())
        {
        int ind = st.peek();
        rightSmaller = 0;
        st.pop();
        if (!st.isEmpty()) {
            leftSmaller = arr[st.peek()];
        }
        else {
            leftSmaller = 0;
        }
        mxDiff = Math.max(mxDiff, Math.abs(rightSmaller - leftSmaller));
        }
        return mxDiff;

    }
}
