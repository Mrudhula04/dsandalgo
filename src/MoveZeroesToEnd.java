public class MoveZeroesToEnd {
    
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0, 3, 12};
        getZeroesAtEnd1(arr1);
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int[] arr2 = {1, 2, 0, 4, 3, 0, 5, 0};
        getZeroesAtEnd1(arr2);
        for (int num : arr2) {
            System.out.print(num + " ");
        }
    }
    
    static void getZeroesAtEnd1(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                if (i != j) {
                    arr[i] = 0;
                }
                j++;
            }
        }
    }
}