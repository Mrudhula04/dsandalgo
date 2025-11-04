import java.util.Date;
import java.util.Calendar;

public class SimpleDateComparison {
    public static void main(String[] args) {
        //dateOperations();
        //recursiveAlgorithms();
        int[] arr = {1, 2, 3, 2};
        System.out.println(isPalindrome(arr, 0, arr.length-1));

    }

    static boolean isPalindrome(int arr[], int left, int right){
        if(arr[left]==arr[right]){
            if(left==right||left==right-1){
                return true;
            }
            return isPalindrome(arr, left+1, right-1);
        }
        else{
            return false;
        }
    }

    static void dateOperations() {
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.OCTOBER, 1);
        Date inputDate = cal.getTime();

        int days = NumberOfDays(inputDate);
        System.out.println("Days: " + days);
        System.out.println("Leap Year: " + isLeapYear(inputDate));
        

    }

    static void recursiveAlgorithms() {
        System.out.println("\n=== Recursive Algorithms ===");
        
        System.out.print("Fibonacci (10 numbers): ");
        printWithoutLoopsFibonacci(0, 1, 10, 0);
        System.out.println();
        
        System.out.println("Sum of even numbers till 10: " + printWithoutLoopsAddEvenNumbers(10));
        System.out.println("Sum of even numbers till 9: " + printWithoutLoopsAddEvenNumbers(9));
        System.out.println("Factorial of 5: " + printWithoutLoopsFactorial(5));
        System.out.println("5 to power 2: " + getPower(5, 2));
        System.out.println("Reverse of 12321: " + Palindrome(12321, 0));
        System.out.println("Multiplied by 4 sum: " + getMultipliedByFour(4, 1, 9));
    }



    static boolean isLeapYear(Date inputDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(inputDate);
        int year = cal.get(Calendar.YEAR);
        
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    static int NumberOfDays(Date inputDate) {
        Date today = new Date();
        System.out.println("Today: " + today);

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(today);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(inputDate);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);

        long daysDiff = (cal1.getTimeInMillis() - cal2.getTimeInMillis()) / (1000 * 60 * 60 * 24);
        return (int) daysDiff;
    }

    static void printWithoutLoops(int start, int end) {
        System.out.println(start);
        if (start == end)
            return;
        else
            printWithoutLoops(start + 1, end);
    }

    static void printWithoutLoopsInReverse(int start, int end) {
        if (start == end) {
            System.out.println(start);
            return;
        } else {
            printWithoutLoopsInReverse(start + 1, end);
            System.out.println(start);
        }
    }


    static void printWithoutLoopsFibonacci(int first, int second, int size, int current) {
        if (current >= size) {
            return;
        }
        System.out.print(first + " ");
        printWithoutLoopsFibonacci(second, first + second, size, current + 1);
    }
    static int printWithoutLoopsFactorial(int num){
        if(num <= 1){
            return 1;
        }
        return num * printWithoutLoopsFactorial(num - 1);
    }
    static int printWithoutLoopsAddEvenNumbers(int num){
        if(num <= 2)
        {
            return num;
        }
        if (num%2 == 0)
        {
            return num + printWithoutLoopsAddEvenNumbers(num - 2);
        }
        else
        {
            return printWithoutLoopsAddEvenNumbers(num - 1);
        }
    }
    static int getPower(int num, int power){
        if(power==0) {
            return 1;
        }
        return num*getPower(num, power-1);
    }
    static int Palindrome(int num, int rev){
        if(num==0){
            return rev;
        }
        return Palindrome(num/10, rev*10+num%10);
    }
    static int getMultipliedByFour(int num,int start, int end){
        if(start>end){
            return 0;
        }
        return num*4 + getMultipliedByFour(num, start+1, end);
    }

}
