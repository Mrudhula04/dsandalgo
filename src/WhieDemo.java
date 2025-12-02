public class WhieDemo
{
    public static void main(String[] args)
    {
        MyStack myStack = new MyStack(10);
        myStack.push(")");
        myStack.push("+");
        myStack.push("*");
        myStack.push("-");
        myStack.push("/");
        while(!myStack.isEmpty())
        {
            System.out.println(myStack.pop());
        }
    }
}
