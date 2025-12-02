public class InfixToPostfixConverter {

    // You already have this class.
    // Replace StringStack with your stack class name if it is different.
    // class StringStack { ... }

    // Check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Return precedence of operators
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    // Main conversion method: infix -> postfix
    public static String convert(String infix) {
        // Using two stacks of Strings
        MyStack operators = new MyStack(infix.length());
        MyStack operands  = new MyStack(infix.length());

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // ignore spaces
            /*if (Character.isWhitespace(ch)) {
                continue;
            }*/

            // If operand (like A, B, 1, 2 ...)
            if (Character.isLetterOrDigit(ch)) {
                operands.push(String.valueOf(ch));
            }
            // If '('
            else if (ch == '(') {
                operators.push("(");
            }
            // If ')'
            else if (ch == ')') {
                // Process until '('
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    makePostfixStep(operators, operands);
                }
                // Pop the '('
                if (!operators.isEmpty() && operators.peek().equals("(")) {
                    operators.pop();
                }
            }
            // If operator +, -, *, /, ^
            else if (isOperator(ch)) {
                // While top of operator stack has higher or equal precedence,
                // combine top 2 operands with that operator into postfix
                while (!operators.isEmpty()
                        && isOperator(operators.peek().charAt(0))) {
                    makePostfixStep(operators, operands);
                }
                operators.push(String.valueOf(ch));
            }
        }

        // Process any remaining operators
        while (!operators.isEmpty()) {
            makePostfixStep(operators, operands);
        }

        // Final postfix expression is on top of operands stack
        if (!operands.isEmpty()) {
            return operands.pop();
        } else {
            return "";
        }
    }

    // Helper: pop one operator and two operands, build postfix, push back
    private static void makePostfixStep(MyStack operators, MyStack operands) {
        String op = operators.pop();

        String right = operands.pop();  // second operand
        String left  = operands.pop();  // first operand

        String combined = left + right + op;  // postfix: left right op
        operands.push(combined);
    }

    // Simple test
    public static void main(String[] args) {
        System.out.println(convert("(1+2)*(3+4)"));      // ABC*+
        System.out.println(convert("(1+2)*3"));    // AB+C*
        System.out.println(convert("((1+2)*(3-4))/5"));  // ABC*+DE/-
    }
}
