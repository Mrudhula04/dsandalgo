public class ArrayOperations {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 3, 4, 5};

        System.out.println(isInArray(arr, 60));
        System.out.println(getXFromRight(arr, 2));
        
        int[][] multiply = getMultiplicationOfTwoArrays(arr1, arr2);
        for (int i = 0; i < multiply.length; i++) {
            for (int j = 0; j < multiply[i].length; j++) {
                System.out.print(multiply[i][j] + " ");
            }
            System.out.println();
        }
        
        int[][] sum = getSumOfTwoArrays(arr1, arr2);
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[i].length; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        
        int[] intersection = getIntersection(arr1, arr2);
        for (int num : intersection) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static boolean isInArray(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
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

    static int[][] getSumOfTwoArrays(int[] arr1, int[] arr2) {
        int[][] sum = new int[arr1.length][arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                sum[i][j] = arr1[i] + arr2[j];
            }
        }
        return sum;
    }

    static int[][] getMultiplicationOfTwoArrays(int[] arr1, int[] arr2) {
        int[][] multiply = new int[arr1.length][arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                multiply[i][j] = arr1[i] * arr2[j];
            }
        }
        return multiply;
    }

    static int[] getIntersection(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int count = 0;
        
        for (int i = 0; i < arr1.length; i++) {
            if (isInArray(arr2, arr1[i])) {
                boolean alreadyAdded = false;
                for (int k = 0; k < count; k++) {
                    if (result[k] == arr1[i]) {
                        alreadyAdded = true;
                        break;
                    }
                }
                if (!alreadyAdded) {
                    result[count++] = arr1[i];
                }
            }
        }
        
        int[] finalResult = new int[count];
        for (int i = 0; i < count; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }
}