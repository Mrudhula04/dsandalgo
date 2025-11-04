import java.util.Arrays;

public class FreshClass {

    public static void main(String[] args) {
        int[] arr1 = {9, 9, 9};
        int[] arr2 = {0, 0, 0, 1};
        //printArrayInformation(arr1, arr);
        //printArray(arr, arr1);
        //printArrayInReverse(arr);
        //justTestWhatLoopInsideLoopMeans();
        //addArrays(arr1, arr2);
        //System.out.println();
        //System.out.println(getSecondLargestElement(arr));


        //reverseArray(arr);

        //for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        //}
        //System.out.println();

        //System.out.println(getThirdLargestElement(arr));
        //int k = 3;

        //reverseInGroups(arr, k);
        // for (int num : arr) {
        // System.out.print(num + " ");
        //int k = 3;


        //}
        int[] arr = {1, 0, 3, 0, 4, 0};
       /* arr = getRotateClockwise(arr, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();*/
        /*System.out.println(getMaxiumProductOfTriplet(arr));
        arr = getAllZeroesAtEnd(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*/
        arr=getZeroesAtEnd1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        arr = new int[]{1, 0, 1, 0, 1, 0};
        arr=getZeroesAtEnd1(arr);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void printArrayInformation(int[] arr, int[] arr1) {
        System.out.println("Length of the array: " + arr.length);
        System.out.println("Length of the second array: " + arr1.length);
        if (arr.length > arr1.length) {
            System.out.println(arr.length);
        } else {
            System.out.println(arr1.length);
        }

    }

    static void addArrays(int[] arr1, int[] arr2) {
        int range;
        if (arr1.length > arr2.length) {
            range = arr1.length;
        } else {
            range = arr2.length;
        }
        int[] sum = new int[range + 1];
        int carry = 0;
        for (int i = range - 1; i >= 0; i--) {
            sum[i + 1] = carry;
            if (i - (range - arr1.length) >= 0) {
                sum[i + 1] = sum[i + 1] + arr1[i - (range - arr1.length)];
            }

            if (i - (range - arr2.length) >= 0) {
                sum[i + 1] = sum[i + 1] + arr2[i - (range - arr2.length)];
            }
            carry = sum[i + 1] / 10;
            sum[i + 1] = sum[i + 1] % 10;
        }
        sum[0] = carry;
        for (int i = 1; i < sum.length; i++) {
            System.out.print(sum[i]);
        }

    }


    static void printArray(int[] arr, int[] arr1) {
        int range;
        if (arr.length > arr1.length) {
            range = arr.length;
        } else {
            range = arr1.length;
        }
        for (int i = 0; i < range; i++) {

            if (i < arr.length) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.print("null" + " ");
            }

            if (i < arr1.length) {
                System.out.print(arr1[i]);
            } else {
                System.out.print("null");
            }
            System.out.println();
        }

    }

    static void printArrayInReverse(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void justTestWhatLoopInsideLoopMeans() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("i: " + i + " j: " + j);
            }

        }
    }

    static int getSecondLargestElement(int[] arr) {

        for (int i = arr.length - 3; i >= 0; i--) {
            if (arr[i] != arr[arr.length - 2]) {
                if (arr[i] != arr[arr.length - 1]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    static int getThirdLargestElement(int[] arr) {
        int n = arr.length;
        int firstlargest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > firstlargest) {
                firstlargest = arr[i];
            }
        }
        int secondlargest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > secondlargest && arr[i] < firstlargest) {
                secondlargest = arr[i];
            }
        }
        int thirdlargest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > thirdlargest && arr[i] < secondlargest) {
                thirdlargest = arr[i];
            }
        }
        return thirdlargest;
    }

    static void reverseArray(int[] arr) {

        // Initialize left to the beginning
        // and right to the end
        int n = arr.length;

        // Iterate over the first half
        // and for every index i, swap
        // arr[i] with arr[n - i - 1]
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    static void reverseInGroups(int[] arr, int k) {
        int n = arr.length;

        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);

            // reverse the sub-array
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    static int[] getReverseOfArray(int[] arr) {
        int j = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }

        }
        return arr;

    }

    static int getArrayReverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

        }
        return -1;
    }

    static int getArrayInReverse1(int[] arr) {
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i > j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;

            }
        }
        return -1;
    }

    static int getThirdLargest(int[] arr) {
        int j = 0;
        for (int i = arr.length - 3; i >= 0; i--) {
            if (arr.length < 3) {
                System.out.println("Invalid Input");
            } else {
                Arrays.sort(arr);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                return arr[j];
            }
        }
        return -1;
    }

    static int getSecondLargest(int[] arr) {
        int j = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr.length < 2) {
                System.out.println("Invalid Input");
            } else {
                Arrays.sort(arr);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                return arr[j];
            }
        }
        return -1;
    }

    static int[] getRotateAnArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        return arr;

    }

    static int[] getRotateArray(int[] arr, int d) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < d; i++) {
            temp[arr.length - 2 + i] = arr[i];
        }
        int j = 0;
        for (int i = d; i < arr.length; i++) {
            temp[j] = arr[i];
            j++;
        }
        return temp;
    }

    static int[] getRotateClockwise(int[] arr, int r) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < r; i++) {
            temp[arr.length - r + i] = arr[i];
        }
        int j = 0;
        for (int i = r; i < arr.length; i++) {
            temp[j] = arr[i];
            j++;
        }
        return temp;
    }

    static int getMaxiumProductOfTriplet(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        return arr[n-1] * arr[n-2] * arr[n-3];
    }

    static int[] getZeroesAtEnd(int[] arr) {
        // Implementation needed

        int[] temp=new int[arr.length];
        int j=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0) {
                temp[j] = arr[i];
                j++;
            }
        }
        return temp;
    }
    static int[] getZeroesAtEnd1(int[] arr){
        int j=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0){
                arr[j]=arr[i];
                if(i!=j){
                    arr[i]=0;
                }
                j++;
            }

        }
        return arr;
    }
    
}