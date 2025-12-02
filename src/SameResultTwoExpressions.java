// Java program to check if two expressions 
// evaluate to same.
import java.io.*;
import java.util.Stack;

class SameResultTwoExpressions
{

    static final int MAX_CHAR = 26;

    // Return local sign of the operand. For example,
    // in the expr a-b-(c), local signs of the operands
    // are +a, -b, +c
    static boolean adjSign(String s, int i)
    {
        if (i == 0)
            return true;
        if (s.charAt(i - 1) == '-')
            return false;
        return true;
    }

    // Evaluate expressions into the count vector of
    // the 26 alphabets.If add is true, then add count
    // to the count vector of the alphabets, else remove
    // count from the count vector.
    static void eval(String s, int[] v)
    {

        // stack stores the global sign
        // for operands.
        Stack<Boolean> stk = new Stack<>();
        stk.push(true);

        // + means true
        // global sign is positive initially

        int i = 0;
        while (i < s.length())
        {
            if (s.charAt(i) == '+' || s.charAt(i) == '-')
            {
                i++;
                continue;
            }
            if (s.charAt(i) == '(')
            {

                // global sign for the bracket is
                // pushed to the stack
                if (adjSign(s, i))
                    stk.push(stk.peek());
                else
                    stk.push(!stk.peek());
            }

            // global sign is popped out which
            // was pushed in for the last bracket
            else if (s.charAt(i) == ')')
                stk.pop();

            else
            {

                // global sign is positive (we use different
                // values in two calls of functions so that
                // we finally check if all vector elements
                // are 0.
                if (stk.peek())
                    v[s.charAt(i) - 'a'] += (adjSign(s, i) ? 1 : -1);

                    // global sign is negative here
                else
                    v[s.charAt(i) - 'a'] += (adjSign(s, i) ? -1 : 1);
            }
            i++;
        }
    }

    // Returns true if expr1 and expr2 represent
    // same expressions
    static boolean areSame(String expr1, String expr2)
    {

        // Create a vector for all operands and
        // initialize the vector as 0.
        int[] v_expression1 = new int[MAX_CHAR];
        int[] v_expression2 = new int[MAX_CHAR];



        // Put signs of all operands in expr1
        eval(expr1, v_expression1);

        // Subtract signs of operands in expr2
        eval(expr2, v_expression2);

        // If expressions are same, vector must
        // be 0.
        for (int i = 0; i < MAX_CHAR; i++)
            if (v_expression1[i] != v_expression2[i])
                return false;

        return true;
    }

    // Driver Code
    public static void main(String[] args)
    {

        String expr1 = "-(a+b+c)", expr2 = "-a-b-c";
        if (areSame(expr1, expr2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
