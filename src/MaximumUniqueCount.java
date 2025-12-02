import java.util.HashSet;
import java.util.Stack;
public class MaximumUniqueCount {
        public static void main(String [] args){
            try {
                int arr[] = {5, 1, 3};
                int arr1[] = {5, 2, 3, 8};
                System.out.println(getMaxUniqueCount(arr));
                System.out.println(getMaxUniqueCount(arr1));
            }
            catch(MrudusStackOverflowException|MrudusStackUnderflowException e){
                System.err.println(e.getMessage());
            }

        }
        public static  int getMaxUniqueCount(int[] arr) throws MrudusStackOverflowException, MrudusStackUnderflowException{
            int[] ngl=new int[arr.length];
            int[] ngr=new int[arr.length];
            Stack<Integer> S=new Stack<>();
            HashSet<Integer> s = new HashSet<>();
            ngl[0]=-1;
            S.push(arr[0]);
            for(int i=1;i<arr.length;i++){
                while(S.size() > 0 && arr[i]>S.peek()){
                    S.pop();
                }
                if(S.size()==0){
                    ngl[i]=-1;
                }
                else{
                    ngl[i]=S.peek();
                }
                S.push(arr[i]);
            }
            while(!(S.size() >0)){
                S.pop();
            }
            ngr[arr.length-1]=-1;
            S.push(arr[arr.length-1]);
                for(int i=arr.length-2;i>=0;i--){
                    while(S.size() > 0 && arr[i]>=S.peek()){
                        S.pop();
                    }
                    if (S.size()==0) {
                        ngr[i]=-1;
                    } else {
                        ngr[i]=S.peek();
                    }
                    S.push(arr[i]);
                }
                for(int i=0;i<arr.length;i++){
                    if(!(ngl[i] ==-1)){
                        s.add(ngl[i]-arr[i]);
                    }
                    if(!(ngr[i]==-1)){
                        s.add(ngr[i]-arr[i]);
                    }
                }
                return s.size();
            }

        }
