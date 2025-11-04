public class ArrayExample {
    
    public static void main(String[] args) {
        // Method 1: Create array variable first
        int[] arr = {1, 2, 3, 4, 5};
        printArray(arr);
        
        // Method 2: Pass array directly using 'new int[]'
        printArray(new int[]{10, 20, 30, 40, 50});
        
        // Method 3: Multiple direct calls
        findMax(new int[]{7, 3, 9, 1});
        findMax(new int[]{-5, -2, -8});
    }
    
    static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    static void findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        System.out.println("Max: " + max);
    }
}