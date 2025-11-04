public class ArrayWithOnes {
    public static void main(String[] args) {
        // Initialize array of size 7
        int[] arr = new int[7];
        
        // Fill array with 1's
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        
        // Print array
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }
}