public class Editor {
    private String[] arr;
    private String[] arr_temp;
    private int top;
    private int capacity;
    private int top_temp;
    private int capacity_temp;

    public Editor(int size) {
        arr = new String[size];
        arr_temp = new String[size];
        capacity = size;
        capacity_temp = size;
        top = -1;
        top_temp=-1;
    }

    public void type(String input){
        if(isFull()){
            System.out.println("editor is full");
        }
        top++;
        arr[top] = input;
        print();
    }
    public String undo(){
        if(isEmpty()){
            System.out.println("editor is empty");
            return "-1";
        }
        top--;
        print();
        if(top>=0) {
            pushIntoTempStack(arr[top]);
            return arr[top];
        }
        else {
            return "-1";
        }
    }
    public void pushIntoTempStack(String input){
        if (isFull_temp()) {
            System.out.println("Stack Overflow");
            return;
        }
        top_temp++;
        arr_temp[top_temp] = input;
    }
     public void redo(){
        String popped = popFromTempArray();
        if(popped.equals("-1"))
        {
            System.out.println("nothing to redo");
        }
        else{
            type(popped);
        }
     }
    public String popFromTempArray() {
        if (isEmpty_temp()) {
            System.out.println("Temporary Stack Underflow");
            return "-1";
        }
        top_temp--;
        if(top_temp>=0) {
            return arr_temp[top_temp];
        }
        else{
            System.out.println("nothing to pop");
            return "-1";
        }

    }
    public void print(){
        System.out.println();
        System.out.println(".......................");
        if(isEmpty()){
            System.out.println("editor is empty");
            return;
        }
        for(int i=0;i<=top; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
        System.out.println(".......................");
        System.out.println();
    }

     public String peek() {
        if(isEmpty()){
            System.out.println("editor is empty");
            return "-1";
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        if(top == capacity-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isFull_temp(){
        if(top_temp== capacity_temp-1){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isEmpty_temp(){
        return top_temp==-1;
    }

    public static void main(String[] args) {
        Editor editor = new Editor(5);

        editor.type("Mrudu");
        System.out.println();
        editor.type("devansh");
        System.out.println();
        editor.type("sridevi");
        System.out.println();
        editor.type("sneha");
        System.out.println();
        editor.type("durga");
        System.out.println();
        //editor.print();
        //System.out.println("Peek: " + stack.peek());
        System.out.println();
        editor.undo();
        System.out.println();
        editor.undo();
        System.out.println();
        editor.undo();
        System.out.println();


       System.out.println();
        editor.redo();
        System.out.println();
        editor.redo();
        System.out.println();
        editor.redo();
        System.out.println();







        /*editor.undo();
        System.out.println();
        editor.undo();
        System.out.println();
        editor.undo();
        System.out.println();
        editor.undo();
        System.out.println();
        editor.redo();
        System.out.println();
        editor.redo();
        System.out.println();
        editor.redo();
        System.out.println();
        editor.redo();
        System.out.println();
        editor.redo();
        System.out.println();
        editor.redo();
        System.out.println();
        editor.redo();
        System.out.println();*/

    }


}