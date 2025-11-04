public class SimpleFibonacci {
    public static void main(String[] args) {
        int[] fib = fibonacci(8);
        print(fib);
    }
    
    static int[] fibonacci(int n) {
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr;
    }
    
    static void print(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}