public class SimpleThreeProduct {
    
    public static void main(String[] args) {
        System.out.println(getProduct(new int[]{1, 5, 3, 9, 2, 8, 4}));
        System.out.println(getProduct(new int[]{10, 20, 30, 5, 15}));
    }
    
    static int getProduct(int[] arr) {
        int a = arr[0], b = arr[1], c = arr[2];
        
        for (int i = 3; i < arr.length; i++) {
            if (arr[i] > a) {
                c = b; b = a; a = arr[i];
            } else if (arr[i] > b) {
                c = b; b = arr[i];
            } else if (arr[i] > c) {
                c = arr[i];
            }
        }
        
        return a * b * c;
    }
}