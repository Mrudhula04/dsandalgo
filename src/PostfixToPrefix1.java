public class PostfixToPrefix1 {
        private String[] arr;
        private int top;
        private int capacity;
        public PostfixToPrefix1(int size){
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
            return ch=='+' || ch=='*'|| ch=='/'||ch=='-'||ch=='^';
        }
        public String convertToPrefix(String postfix){
            for(int i=0;i<postfix.length();i++){
                char temp=postfix.charAt(i);
                if(isOperator(temp)){
                    String right=pop();
                    String left=pop();
                    String result=temp+left+right;
                    push(result);
                }
                else{
                    push(""+temp);
                }
            }
            return peek();
        }
        public static void main(String[] args){
            PostfixToPrefix1 ptp=new PostfixToPrefix1(100);
            System.out.print(ptp.convertToPrefix("ab+"));
            System.out.println();
            System.out.print(ptp.convertToPrefix("76+942/-*"));
            System.out.println();
            System.out.print(ptp.convertToPrefix("ab*c+"));
            System.out.println();
            System.out.print(ptp.convertToPrefix(" "));
            System.out.println();
            System.out.print(ptp.convertToPrefix("a"));
            System.out.println();
            System.out.print(ptp.convertToPrefix("ab+cd-*"));
            System.out.println();
            System.out.print(ptp.convertToPrefix("ab+cde++*"));
        }
    }
