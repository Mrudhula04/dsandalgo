public class TopThreeMultiplier {
    
    public static void main(String[] args) {
        System.out.println(getTopThreeProduct(new int[]{1, 5, 3, 9, 2, 8, 4}));
        System.out.println(getTopThreeProduct(new int[]{10, 20, 30}));
        System.out.println(getTopThreeProduct(new int[]{-1, -5, -3, -2}));
    }
    
    static int getTopThreeProduct(int[] arr) {
        if (arr.length < 4) {
            return -1;
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        int fourth = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num > first) {
                fourth = third;
                third = second;
                second = first;
                first = num;
            } else if (num > second) {

                fourth = third;
                third = second;
                second = num;
            } else if (num > third) {
                fourth = third;
                third = num;
            }
            else if(num > fourth){

                fourth = num;
            }
        }
        
        return first * second * third * fourth;
    }
}