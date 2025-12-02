import java.util.HashMap;
import java.util.Map;

public class NextGreaterFrequencyElement {
    public static void main(String[] args){
        try{
            int arr[]={1,1,2,3,4,2,1};
            for(int i=0;i<arr.length;i++){
                System.out.print(" "+arr[i]);
            }
            System.out.println();
            greaterFrequencyElement(arr);
        }
        catch (MrudusStackUnderflowException | MrudusStackOverflowException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void greaterFrequencyElement(int[] arr) throws MrudusStackOverflowException, MrudusStackUnderflowException{
        MyIntStack S = new MyIntStack(arr.length);
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            freq.put(arr[i],freq.getOrDefault(arr[i],0)+1);
        }
        int[] result = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!S.isEmpty() && freq.get(arr[S.peek()])<=freq.get(arr[i])){
                S.pop();
            }
            if(S.isEmpty()){
                result[i]=-1;
            }
            else{
                result[i]=arr[S.peek()];
            }
            S.push(i);
        }
        for(int i=0;i<arr.length;i++) {
            System.out.print(" "+result[i]);
        }

    }
}
