public class MaximumLRProduct {
    public static void main(String[] args){
        try {
            int arr[] = {5, 4, 3, 4, 5};
            int left[] = {0, 0 , 0, 0, 0};
            int right[] = {0, 0 , 0, 0, 0};
            findLGreater(arr,left);
            findRGreater(arr,right);
            int result=0;
            for(int i=0;i< arr.length;i++){
                result=Math.max(result, left[i]*right[i]);
            }
            System.out.print(result);
        } catch (MrudusStackOverflowException| MrudusStackUnderflowException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void findLGreater(int[] arr, int[] left) throws MrudusStackOverflowException, MrudusStackUnderflowException {
        MyIntStack s = new MyIntStack(arr.length);
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                left[i] = s.peek() + 1;
            } else {
                left[i] = 0;
            }
            s.push(i);
        }
    }
        private static void findRGreater(int[] arr, int[] right) throws MrudusStackOverflowException, MrudusStackUnderflowException {
            MyIntStack s = new MyIntStack(arr.length);
            for (int i = arr.length - 1; i >= 0; i--) {
                while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                    s.pop();
                }
                if (!s.isEmpty()) {
                    right[i] = s.peek() + 1;
                } else {
                    right[i] = 0;
                }
                s.push(i);
            }
        }
    }

