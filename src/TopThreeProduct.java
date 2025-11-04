public class TopThreeProduct {
    
    public static void main(String[] args) {
        System.out.println(getTopThreeProduct(new int[]{1, 5, 3, 9, 2, 8, 4}));
        System.out.println(getTopThreeProduct(new int[]{10, 20, 30, 5, 15}));
        System.out.println(getTopThreeProduct(new int[]{1, 2, 3, 4, 5}));
    }
    
    static int getTopThreeProduct(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }
        
        System.out.println("Largest: " + first + ", Second: " + second + ", Third: " + third);
        return first * second * third;
    }
}