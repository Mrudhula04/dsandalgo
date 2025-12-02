public class InfixToPrefix {
    public static boolean isOperator(char c){
        return c=='+'||c=='-'||c=='*'||c=='/'||c=='^';
    }
    public static boolean isOpenBracket(char ch){
        return ch=='(';
    }
    public static void InfixToPrefix(MyStack operands, MyStack operators) {
        String parent = operators.pop();
        String right = operands.pop();
        String left = operands.pop();
        String result = parent + left + right;
        operands.push(result);
    }
    public static String ConvertToPrefix(String infix){
        MyStack operands= new MyStack(infix.length());
        MyStack operators=new MyStack(infix.length());
        for(int i=0;i<infix.length();i++){
            char temp=infix.charAt(i);
            if(Character.isLetterOrDigit(temp)){
                operands.push(""+temp);
            }
            if(temp== '('){
                operators.push(""+temp);
            }
            else if(temp==')'){

                while(!operators.isEmpty() && !operators.peek().equals("(") )
                {
                    InfixToPrefix(operands, operators);
                }
                if(!operators.isEmpty() && operators.peek().equals("(")){
                    operators.pop();
                }
            }
            else if(isOperator(temp)){
                while(!operators.isEmpty() && !isOpenBracket(operators.peek().charAt(0))){
                    InfixToPrefix(operands, operators);
                }
                operators.push(""+temp);
            }
        }
        while(!operators.isEmpty()){
            InfixToPrefix(operands, operators);
            }
        if(!operands.isEmpty()){
            return operands.pop();
        }
        else{
            return "";
        }
    }
    public static void main(String[] args) {
        System.out.println(ConvertToPrefix("(1+2)*(3+4)/5"));

    }
}
