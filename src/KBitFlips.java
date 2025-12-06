class KBitFlips {
    static int kBitFlips(int[] arr, int k) {
        try
        {
            int n = arr.length;
            int res = 0, flag = 0;
            ArrayQueue q = new ArrayQueue(n);

            for (int i = 0; i < n; i++) {
                System.out.println("________________________________");
                System.out.println("At i = "+i);
                System.out.println("________________________________");
                if(i >= k) {
                    System.out.println("i seems to be greater than or equal to k");
                    int popped = q.dequeue();
                    System.out.println("flag = "+flag+", q.dequeue() = "+popped);
                    flag ^= popped;
                    System.out.println("I am performing XOR between flag and popped  result is flag = " + flag);
                    System.out.println("Queue contents now are...");
                    q.print();
                }
                // If flag = 1, then flip the current index
                if(flag == 1)
                {
                    System.out.println("flag already seems to be 1, so let me flip arr["+i+"] = " + arr[i]);
                    arr[i] ^= 1;
                    System.out.println("Now arr["+i+"] = "+arr[i]);
                    printArray(arr);
                }
                // Finally, if arr[i] = 0, then we need to flip
                if(arr[i] == 0) {
                    System.out.println("arr["+i+"] is zero now, so");
                    // Check if k elements are left
                    if(i + k > n)
                    {
                        System.out.println("i + k > n, so returning -1");
                        return -1;
                    }
                    System.out.println("increasing result by 1");
                    res += 1;
                    System.out.println("result = "+res);
                    // Flip flag so that upcoming elements are also flipped
                    System.out.println("flipping flag "+flag);
                    flag ^= 1;
                    System.out.println("flag = "+flag);
                    // If we flip, push 1 to the queue
                    arr[i] ^= 1;
                    printArray(arr);
                    q.enqueue(1);
                    System.out.println("Since flag has been pushed, let me push 1 to Queue. Queue contents so far are ");
                    q.print();
                }
                else {

                    // If we don't flip, push 0 to queue
                    q.enqueue(0);
                    System.out.println("Pushing 0 to Queue. Queue contents so far are");
                    q.print();
                    printArray(arr);
                }
            }
            System.out.println("Finally, result is "+res);
            return res;
        }
        catch (Exception e){
            return -1;
        }
    }

    private static void printArray(int[] arr)
    {
        System.out.println("Printing array");
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //int[] arr_testcase1 = {1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1};
        int[] arr_testcase1 = {1, 1, 0, 0};

        //int[] arr_testcase2 = {0, 0, 1, 1, 1, 0, 0};
        System.out.println(kBitFlips(arr_testcase1, 3));
        //System.out.println(kBitFlips(arr_testcase2, 3));
    }
}