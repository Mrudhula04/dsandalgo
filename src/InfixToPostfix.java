public class InfixToPostfix {
    public static boolean isOperators(char ch){
        return ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^';
    }

    public static void InfixToPostfix(MyStack Operands, MyStack Operators){
    String parent=Operators.pop();
    String right=Operands.pop();
    String left=Operands.pop();
    String result=left+right+parent;
    Operands.push(result);
}
public static boolean isThisAOpenBracket(char c){
        return c=='(';
    }
public static String ConvertToPostfix(String infix) {
    MyStack Operands = new MyStack(infix.length());
    MyStack Operators = new MyStack(infix.length());
    for (int i = 0; i < infix.length(); i++) {
        char ch = infix.charAt(i);
        if (Character.isLetterOrDigit(ch)) {
            Operands.push("" + ch);
        } else if (ch == '(') {
            Operators.push("" + ch);
        } else if (ch == ')') {
            while (!Operators.isEmpty() && !Operators.peek().equals("(")) {
                InfixToPostfix(Operands, Operators);
            }
            if (!Operators.isEmpty() && Operators.peek().equals("(")) {
                Operators.pop();
            }
        }
        if (isOperators(ch)) {
            while (!Operators.isEmpty() && !isThisAOpenBracket(Operators.peek().charAt(0))) {
                InfixToPostfix(Operands, Operators);
            }
            Operators.push("" + ch);
        }
    }

    while (!Operators.isEmpty()) {
        InfixToPostfix(Operands, Operators);
    }
    if (!Operands.isEmpty()) {
        return Operands.pop();
    } else {
        return "";
    }
}
    public static void main (String[] args){
        //System.out.println(ConvertToPostfix("(1+2)*(3+4)"));
        //System.out.println(ConvertToPostfix("(1+2)*3"));
        //System.out.println(ConvertToPostfix("((1+2)*(3-4))/5"));
        PostfixToInfix pti=new PostfixToInfix(100);
        System.out.println(pti.convertToInfix(ConvertToPostfix("((1+2)*(3-4))/5))")));

    }
}