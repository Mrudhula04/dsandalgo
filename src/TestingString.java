public class TestingString {
    public static int sum(int k) {
        if (k > 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }
    public static int getDividedByResult(int arr[]) throws MruduException
    {
        if(arr.length<2 || arr.length>2)
            throw new MruduException("length of array size should be 2");

        return arr[0]/arr[1];
    }

    public static void main(String[] args) {
        //String str = "DurgaPrasad";
        //System.out.println(str.indexOf('P'));
        try {
            int arr[]={20,0,3};
            System.out.println(getDividedByResult(arr));

        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Please provide atleast two elements to run this function");
        }
        catch (ArithmeticException e){
            System.out.println("Divider Should not be zero");
        }
        catch (MruduException e){
            System.out.println(e.getMessage());
        }

        System.out.println();
        int result = sum(10);
        System.out.println(result);
        int x = 92;
        System.out.println("About to initiate bitwise operations on " + Integer.toBinaryString(x));
        int y = x>>3;
        int z = x<<3;
        System.out.println(y);
        System.out.println(z);
        for (int i = 1; i <= 2; i++) {
            System.out.println("Outer: " + i); // Executes 2 times

            // Inner loop
            for (int j = 1; j <= 3; j++) {
                System.out.println(" Inner: " + j); // Executes 6 times (2 * 3)
            }

        }
        int arr[] = new int[5];
        int x1=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++) {
            arr[i]=i;
            if(arr[i]<x1){
                x1=arr[i];
                System.out.println(x1);
            }
            }
        }


}
