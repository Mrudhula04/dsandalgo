public class PostfixToInfix {
    private String[] arr;
    private int capacity;
    private int top;
    public PostfixToInfix(int size){
        capacity=size;
        arr=new String[size];
        top=-1;
    }
    public void push(String input){
        if(isFull()){
            System.out.println("Stack is Overflow");
            return;
        }
        top++;
        arr[top]=input;
    }
    public String pop(){
        if(isEmpty()){
            System.out.println("Stack is Underflow");
            return "";
        }
        String input=arr[top];
        top--;
        return input;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==capacity-1;
    }
    public String peek(){
        if(isEmpty()){
            System.out.println("Stack is Underflow");
            return "";
        }
        return arr[top];
    }
    public boolean isOperator(char ch){
        return ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^';
    }
    public String convertToInfix(String Postfix)
    {
        for(int i=0;i<Postfix.length();i++)
        {
            char temp=Postfix.charAt(i);
            if(isOperator(temp))
            {
                String right=pop();
                String left=pop();
                String result="("+left+temp+right+")";
                push(result);
            }
            else
            {
                push(""+temp);
            }
        }
        return peek();
    }
    public static void main(String[] args){
        PostfixToInfix pti=new PostfixToInfix(100);
        System.out.print(pti.convertToInfix("ab+"));
        System.out.println();
        System.out.print(pti.convertToInfix("76+942/-*"));
        System.out.println();
        System.out.print(pti.convertToInfix("ab*c+"));
        System.out.println();
        System.out.print(pti.convertToInfix(" "));
        System.out.println();
        System.out.print(pti.convertToInfix("12+34-*"));
    }
}
