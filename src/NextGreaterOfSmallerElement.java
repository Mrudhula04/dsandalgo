public class NextGreaterOfSmallerElement {
    public static void main(String[] args){
        try {
            int[] arr = {5, 1, 9, 2, 5, 1, 7};
            int[] NGE_arr=new int[arr.length];
            int[] NSE_arr=new int[arr.length];

            NGE(arr, NGE_arr);
            NSE(arr, NSE_arr);
            for(int i=0;i<arr.length;i++) {
                System.out.print( NGE_arr[i]+" ");
            }
            System.out.println();
            for(int i=0;i<arr.length;i++) {
                System.out.print( NSE_arr[i]+" ");
            }
            System.out.println();
            for(int i=0;i<arr.length;i++){
                if(NGE_arr[i]==-1||NSE_arr[NGE_arr[i]]==-1)
                    System.out.print("-1 ");
                else
                    System.out.print(arr[NSE_arr[NGE_arr[i]]]+ " ");
            }

        }
        catch(MrudusStackOverflowException | MrudusStackUnderflowException e){
            System.err.println(e.getMessage());
        }

    }


        public static void NGE(int[] arr, int[] result) throws MrudusStackOverflowException, MrudusStackUnderflowException {
            MyIntStack s=new MyIntStack(arr.length);
            for(int i=arr.length-1;i>=0;i--){
                while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    result[i]=-1;
                }
                else{
                    result[i]=s.peek();
                }
                s.push(i);
            }
        }
        public static void NSE(int[] arr, int[] result) throws MrudusStackOverflowException, MrudusStackUnderflowException {
            MyIntStack s=new MyIntStack(arr.length);
            for(int i=arr.length-1;i>=0;i--){
                while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    result[i]=-1;
                }
                else{
                    result[i]=s.peek();
                }
                s.push(i);
            }
        }

}
