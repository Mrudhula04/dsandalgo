public class CountSubarrayswithFirstElementasMinimum {

    static int countSubarrays(int arr[])
    {
        try
        {
            MyIntStack st = new MyIntStack(arr.length);
            int ans = 0;
            int n = arr.length;

            for (int i = n - 1; i >= 0; i--) {
                while (st.isEmpty() == false
                        && arr[st.peek()] >= arr[i])
                {
                    System.out.println("Stack is not empty && arr["+st.peek()+"]>=arr["+i+"]");
                    int popped_index = st.pop();
                    System.out.println("So, Popped index is "+popped_index);
                }
                // The index of next smaller element
                // starting from i'th index
                int last = ((st.isEmpty() == true) ? n : st.peek());

                // Adding the number of subarray which
                // can be formed in the range [i, last]
                ans += (last - i);
                System.out.println("Ans is "+ans);
                System.out.println("One valid sub-array is ["+i+","+last+"]");
                st.push(i);
                System.out.println("Pushed "+i+" in stack");
            }
            return ans;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return -1;
        }

    }


    public static void main(String[] args) {
        int arr[] = new int[]{4, 6, 8, 10};
        System.out.println(countSubarrays(arr));
    }
}
