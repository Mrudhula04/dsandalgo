public class twoStacks {
    private int[] arr;
    private int top1;
    private int top2;
    private int capacity;
    public twoStacks(int size){
        capacity=size;
        arr=new int[size];
        top1=-1;
        top2=size;
    }

}
