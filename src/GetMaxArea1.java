import java.util.Stack;
public class GetMaxArea1 {
    
    public  static void main(String[] args){
        try {
            int arr[] = {3, 5, 1, 7, 5, 9};
            int result = getMaxArea(arr);
            System.out.println("Maximum area: " + result);
        } catch (MrudusStackOverflowException | MrudusStackUnderflowException e) {
            System.err.println(e);
        }
    }

    private static int getMaxArea(int[] arr) throws MrudusStackUnderflowException, MrudusStackOverflowException {
        Stack<Integer> S=new Stack<>();
        int res=0, curr, tp, n=arr.length, width;
        for(int i=0;i< arr.length;i++) {
            while (!S.isEmpty() && arr[S.peek()] >= arr[i]) {
                tp = S.pop();
                if (!S.isEmpty()) {
                    width = i - S.peek() - 1;
                } else {
                    width = i;
                }
                res = Math.max(res, arr[tp] * width);
            }
            S.push(i);
        }
        
        while(!S.isEmpty()){
            tp=S.pop();
            if(!S.isEmpty()) {
                curr = arr[tp] * (n - S.peek() - 1);
            }
            else{
                curr = arr[tp]*n;
            }
            res=Math.max(res, curr);
        }
        
        return res;
    }

}
