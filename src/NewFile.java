public class NewFile {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int mean = findMean(arr);
        System.out.println("Mean = " + mean);
    }
    
    public static int findMean(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }
}