import java.util.Stack;

class Histogram {

    static int getMaxArea(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int res = 0, tp, curr;

        for (int i = 0; i < n; i++) {

            // Process the stack while the current element 
            // is smaller than the element corresponding to 
            // the top of the stack
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                System.out.println("At i="+i+", found that stack is not empty and current index "+i+" is less than current stack top. so time to pop and find result so far before pushing "+ i +" to stack");
                // The popped item is to be considered as the
                // smallest element of the Histogram
                tp = st.pop();
                System.out.println("Just popped "+tp);

                // For the popped item, previous smaller element
                // is just below it in the stack (or current stack 
                // top) and next smaller element is i
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                if(st.empty())
                {
                    System.out.println("width="+i);
                }
                else {
                    System.out.println("width="+i+"-"+st.peek()+"-1 = "+width);
                }

                // Update the result if needed
                res = Math.max(res, arr[tp] * width);
                System.out.println("res="+res);
            }
            if(st.empty())
                System.out.println("Now stack is empty");
            else
                System.out.println("Stack is not empty, so i will keep pushing elements in ascending order");
            st.push(i);
            System.out.println("Pushed "+i+" to Stack");
        }

        // For the remaining items in the stack, next smaller does
        // not exist. Previous smaller is the item just below in
        // the stack.
        System.out.println("Going through remaining items");
        while (!st.isEmpty()) {
            System.out.println("Stack is not empty");
            tp = st.pop();
            System.out.println("top = "+tp);
            curr = arr[tp] * (st.isEmpty() ? n : n - st.peek() - 1);
            if(st.empty())
                System.out.println("Stack is empty, So curr = arr["+tp+"]*"+n+" = "+ curr);
            else
                System.out.println("Stack is not empty So ,curr = arr["+tp+"]*("+n+"-"+st.peek()+"-1 = "+ curr);
            res = Math.max(res, curr);
            System.out.println("res = Math.max("+res+","+"curr) = "+ res);
        }

        System.out.println("Finally returning res = "+res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 7, 5, 9};
        System.out.println(getMaxArea(arr));
    }
}