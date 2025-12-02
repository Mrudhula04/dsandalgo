public class CountSubarrayswithFirstElementasMinimum1 {
    public static void main(String[] args) {
            int arr[] = new int[]{4, 6, 8, 10};
            System.out.println(countSubarrays(arr));

    }
    public static int countSubarrays(int arr[]){
        try {
            MyIntStack S = new MyIntStack(arr.length);
            int ans = 0;
            int n = arr.length;

            for (int i = n - 1; i >= 0; i--) {
                while (S.isEmpty() == false
                        && arr[S.peek()] >= arr[i]) {
                   S.pop();
                }
                int last;
                if (S.isEmpty()) {
                    last = n;
                } else {
                    last = S.peek();
                }
                ans += (last - i);
                S.push(i);
            }
            return ans;
        }
        catch (Exception e){
            System.out.println(e);
            return -1;
        }

    }
}
