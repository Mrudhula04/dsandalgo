public class MaxTripletProduct {
    
    public static void main(String[] args) {
        System.out.println(maxTripletProduct(new int[]{1, -4, 3, -6, 7, 0}));
        System.out.println(maxTripletProduct(new int[]{-1, -3, -4, 2, 0, -5}));
        System.out.println(maxTripletProduct(new int[]{1, 2, 3, 4, 5}));
    }
    
    static int maxTripletProduct(int[] arr) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        
        for (int num : arr) {
            if (num > max1) {
                max3 = max2; max2 = max1; max1 = num;
            } else if (num > max2) {
                max3 = max2; max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            
            if (num < min1) {
                min2 = min1; min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}