public class AnotherFile {
    public static void main(String[] args) {


        for(int j=4;j<=4;j++) {
            printMultiplicationResult(j, 1, 20);


        }}
    
    static int[] getMultiplicationResult(int num, int start, int end ) {
        int[] arr = new int[end-start+1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i+start)*num;
        }
        return arr;
    }

    static void printMultiplicationResult(int num, int start, int end )
    {
        int[] arr = new int[end-start+1];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (i+start)*num;
            System.out.println(num+"*"+(i+1)+"="+arr[i]);
        }
    }
}

