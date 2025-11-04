//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    IO.println(String.format("Hello and welcome!"));

   /* int a = 4;
    boolean result = a == 4;
    System.out.println(result);
// result will be 1
// This is equivalent to
    int b;

    if (a == 4 && result == true) {
        b = 1;
        System.out.println(b);
    } else {
        b = 8;
        System.out.println(b);
    }*/


    int arr[]={2,3,4,5,6};
    boolean b[]= new boolean[arr.length];
    for(int i=0; i<arr.length; i++) {
        if (arr[i] % 2 == 0 ) {
            b[i] = true;
            System.out.println(b[i]);

        }
        else {
            b[i] = false;
            System.out.println(b[i]);
        }
    }



}
