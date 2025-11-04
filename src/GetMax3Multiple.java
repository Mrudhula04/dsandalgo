public class GetMax3Multiple {

    public static void main(String[] args) {
        /*getMaxTwoDemo(3,5);
        getMaxTwoDemo(5, 3);
        getMaxTwoDemo(3, 3);
        getMaxThreeDemo(3, 5, 7);
        getMaxThreeDemo(3, 7, 5);
        getMaxThreeDemo(5, 3, 7);
        getMaxThreeDemo(6,6,6);
        getMaxThreeDemo(-1,-1,-1);*/
        //getMaxThreeMultipleFromArray(new int[]{ 1, 5, 6, 2, 7, 8, 9});
        getMaxThreeMultipleFromArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
    }

    static void getMaxThreeMultipleFromArray(int[] arr) {
        if (arr.length < 3) {
            return;
        }
        int big = arr[0], middle = arr[1], small = arr[2];
        //
        for (int i = 0; i < arr.length - 2; i++) {
            int first = arr[i];
            int second = arr[i + 1];
            int third = arr[i + 2];
            if (first > second) {
                if (first > third) {
                    if (first > big) {
                        small = middle;
                        middle = big;
                        big = first;
                    } else if (first > middle) {
                        small = middle;
                        middle = first;
                    } else {
                        small = first;
                    }
                }


            }
            System.out.println("first is " + big + ", second is " + middle + " and third is " + small + " and their multiplication is " + big * middle * small);


        }
    }
    static void getMaxTwoDemo(int first, int second){
        if(first<second){
            int temp = first;
            first = second;
            second = temp;
        }
        System.out.println("first is "+ first+ " and second is "+ second);
    }

    static void getMaxThreeDemo(int first, int second, int third){
        //Mrudu's logic goes here
        int big= first,
                middle= second,
                small= third;
        if(first>second){
            if(first>third){
                big=first;
                if(second>third){
                    middle=second;
                    small=third;
                }
                else{
                    middle=third;
                    small=second;
                }
            }
            else {
                big=third;
                middle=first;
                small=second;
            }
        }
        else{
            if(second>third){
                big=second;
                if(third>first){
                    middle=third;
                    small=first;
                }
                else{
                    middle=first;
                    small=third;
                }

            }
            else{
                big=third;
                middle=second;
                small=first;
            }
        }
        //ends here
        System.out.println("first is "+ big + ", second is "+ middle + " and third is "+small);
    }

}