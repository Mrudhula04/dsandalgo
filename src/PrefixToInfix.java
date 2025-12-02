public class PrefixToInfix{
    private String[] arr;
    private int capacity;
    private int top;
    public PrefixToInfix(int size){
        arr=new String[size];
        capacity=size;
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
        String result=arr[top];
        top--;
        return result;
    }
    public String peek(){
        if(isEmpty()){
            System.out.println("Stack is Underflow");
            return "";

        }
        return arr[top];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==capacity-1;
    }
    public boolean isOperator(char ch){
        return ch=='+'|| ch=='-'||ch=='/'||ch=='^'||ch=='*';
    }
    public String convertToInfix(String prefix)
    {
        for(int i=prefix.length()-1;i>=0;i--)
        {
            char temp=prefix.charAt(i);
            if(isOperator(temp))
            {
                String left=pop();
                String right=pop();
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
        PrefixToInfix prti=new PrefixToInfix(100);
        System.out.print(prti.convertToInfix("*+12-34"));
        System.out.println();
        System.out.print(prti.convertToInfix("*+ab+c+de"));
        System.out.println();

    }
}
