public class Browser
{
    private String[] arr;
    private int capacity;
    private int top;

    public Browser(int size)
    {
        capacity=size;
        arr=new String[size];
        top=-1;
    }
    public void browse(String url)
    {
        if(isFull())
        {
            System.out.println("browser is full");
            return;
        }
        top++;
        arr[top]=url;
    }

    public String back()
    {
        if(isEmpty()){
            System.out.println("browser is empty");
            return "-1";
        }
        if(top==0){
            System.out.println("no back history");
            return arr[top];
        }
        else {
            top--;
            return arr[top];
        }

    }
    public String forward()
    {
        if(isEmpty()){
            System.out.println(" is empty");
            return "-1";
        }
        if(top==capacity-1){
            System.out.print("no history to ");
            return " ";
        }
        top++;
        return arr[top];
    }

    public void printHistory()
    {
        if(isEmpty())
        {
            System.out.println("browser is empty");
            return;
        }
        for(int i=0;i<=top;i++)
        {
            System.out.println(arr[i]);
        }

    }
    public boolean isFull()
    {
        return top==capacity-1;
    }
    public boolean isEmpty()
    {
        return top==-1;
    }

    public static void main(String[] args)
    {
        Browser browser=new Browser(6);
        browser.browse("www.youtube.com");
        browser.browse("www.amazon.com");
        browser.browse("www.instagram.com");
        browser.browse("www.twitter.com");
        browser.browse("www.facebook.com");
        browser.browse("www.linkedin.com");
        browser.printHistory();
        System.out.println();
        for(int i=0;i<=6;i++)
            System.out.println("back: "+browser.back());
        for(int i=0;i<=6;i++)
            System.out.println("forward: "+browser.forward());
        browser.printHistory();
    }
}
