public class NewClass {

    public static boolean main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 3, 4, 5};

        System.out.println(isInArray(arr, 60));
        System.out.println(getXFromRight(arr, 5));
        int[][] multiply = getMultiplicationoftwoArrays(arr1, arr2);

        for (int i = 0; i < multiply.length; i++) {
            for (int j = 0; j < multiply[i].length; j++) {
                System.out.print(multiply[i][j] + " ");
            }
        }
        System.out.println();
        int[] sum = getSumoftwoArrays(arr1, arr2);

        return false;
    }

    static boolean isInArray(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x){
                return true;
            }
        }
        return false;
    }

    static int getXFromRight(int[] arr, int x) {
        if (x > 0 && x <= arr.length) {
            return arr[arr.length - x];
        }
        return -1;
    }

    static int[] getSumoftwoArrays(int[] arr1, int[] arr2) {
        int sum[] = new int[arr2.length];
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
              sum[i]  = arr1[i] + arr2[j];

            }
        }

        return sum;
    }

    static int[][] getMultiplicationoftwoArrays(int[] arr1, int[] arr2) {
        int multiply[][] = new int[arr1.length][arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                multiply[i][j] = arr1[i] * arr2[j];
            }
        }
        return multiply;
    }


}







