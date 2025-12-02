public class TwoStacksDemo
{
    public static boolean isOperator(String c)
    {
        return c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/")||c.equals("^");
    }

    public static String convertInfixToPostfix_by_chatGPT(final String infix) {
        MyStack s1 = new MyStack(infix.length()); // operands
        MyStack s2 = new MyStack(infix.length()); // operators

        for (int i = 0; i < infix.length(); i++) {

            String temp = infix.charAt(i) + "";

            // =================
            //   OPERATOR CASE
            // =================
            if (isOperator(temp)) {
                s2.push(temp);
            }
            // =================
            //   OPERAND CASE
            // =================
            else {
                s1.push(temp);

                // whenever possible, combine (left, right, operator)
                while (!s2.isEmpty() && s1.size() >= 2) {
                    String op = s2.pop();
                    String right = s1.pop();
                    String left = s1.pop();
                    s1.push(left + right + op);
                }
            }
        }

        // Combine remaining operators at the end
        while (!s2.isEmpty()) {
            String op = s2.pop();
            String right = s1.pop();
            String left = s1.pop();
            s1.push(left + right + op);
        }

        return s1.peek();
    }

    public static String convertInfixToPostfix(final String infix)
    {
        MyStack s1 = new MyStack(infix.length());
        MyStack s2 = new MyStack(infix.length());
        boolean left_visited = true;
        for(int i=0;i<infix.length();i++)
        {
            String temp = infix.charAt(i)+"";
            if(isOperator(temp))
            {
                s2.push(temp+"");
            }
            else
            {
                s1.push(temp+"");
                while(!s2.isEmpty() && temp.equals(")"))
                {
                    String parent = s2.pop();
                    String right_child = s1.pop();
                    String left_child = s1.pop();
                    String postfix = left_child+""+right_child+""+parent;
                    s1.push(postfix);
                    left_visited = false;
                }
            }

        }
        while(!s2.isEmpty())
        {
            String parent = s2.pop();
            String right_child = s1.pop();
            String left_child = s1.pop();
            String postfix = left_child+""+right_child+""+parent;
            s1.push(postfix);
        }
        return s1.peek();
    }
    public static void main(String[] args)
    {
        //System.out.println(convertInfixToPostfix("1+2"));
        System.out.println(convertInfixToPostfix_by_chatGPT("(1+2)*(3+4)"));
        System.out.println(convertInfixToPostfix_by_chatGPT("1+2*3+4/5+6*7+8"));
    }
}

