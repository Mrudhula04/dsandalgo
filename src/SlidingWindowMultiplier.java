public class SlidingWindowMultiplier {

    public static void main(String[] args) {
        System.out.println(getMaxProductFromWindow(new int[]{1, 5, 3, 9, 2, 8, 4}));
        System.out.println(getMaxProductFromWindow(new int[]{10, 20, 30, 5, 15}));
        System.out.println(getMaxProductFromWindow(new int[]{1, 2, 3, 4, 5}));
        System.out.println(getMaxProductFromWindow(new int[]{5, 4, 3, 2, 1}));
    }

    static int getMaxProductFromWindow(int[] arr) {
        int big = arr[0];
        int middle = arr[1];
        int small = arr[2];

        for (int i = 0; i < arr.length - 2; i++) {
            int first = arr[i];
            int second = arr[i + 1];
            int third = arr[i + 2];
            int currentProduct = first * second * third;
            int maxProduct = big * middle * small;
            if (currentProduct > maxProduct) {
                big = first;
                middle = second;
                small = third;
            }

        }
        return big * middle * small;
    }
}