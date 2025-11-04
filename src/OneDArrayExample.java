public class OneDArrayExample {
    public static void main(String[] args) {
        // Array initialization
        int[] arr1 = {1992, 2008, 2025, 1986, 1999};
        int[] arr2 = {23, 25, 27, 2008, 28};


        // Traverse and print with addresses

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.println(arr1[i]);
                }

            }

        }
    }
}