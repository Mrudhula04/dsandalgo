public class EvaluationOfPostfix {
    public int convertToInteger(String input){
        if(input.equals("0")){
            return 0;
        }
        if(input.equals("1")){
            return 1;
        }
        if(input.equals("2")){
            return 2;
        }
        if(input.equals("3")){
            return 3;
        }
        if(input.equals("4")){
            return 4;
        }
        if(input.equals("5")){
            return 5;
        }
        if(input.equals("6")){
            return 6;
        }
        if(input.equals("7")){
            return 7;
        }
        if(input.equals("8")){
            return 8;
        }
        if(input.equals("9")){
            return 9;
        }
        return 0;
    }

    public boolean isOperator(char ch){
        return ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='%'||ch=='^';
    }
    public String evaluatePostfix(String input){
        MyStack stack = new MyStack(input.length());
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(isOperator(ch)){
               int right=convertToInteger(stack.pop());
               int left=convertToInteger(stack.pop());
               int finalResult=getFinalResult(left, right, ch);
               stack.push(finalResult+"");
            }
            else if (isNumber(ch)){
                stack.push(""+ch);
            }
            else{
                return "Invalid input. returning 0 as error";
            }
        }
        return stack.peek();
    }

    private boolean isNumber(char ch) {
        return ch=='0'||ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'||ch=='7'||ch=='8'||ch=='9';
    }

    private int getFinalResult(int left, int right, char ch)
    {
        if(ch=='+'){
            return left+right;
        }
        if(ch=='-'){
            return left-right;
        }
        if(ch=='*'){
            return left*right;
        }
        if(ch=='/'){
            return left/right;
        }

        return left%right;

    }

    public static void main(String[] args) {
        EvaluationOfPostfix obj = new EvaluationOfPostfix();
        System.out.println(obj.evaluatePostfix("123+*"));
        System.out.println(obj.evaluatePostfix("156+34+/*"));
        System.out.println(obj.evaluatePostfix("1)2"));
    }

}
