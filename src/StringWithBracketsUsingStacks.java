public class StringWithBracketsUsingStacks {
    public static void main(String[] args) {
        String str = "[[a+b]+[c+d]]";
        try {
            System.out.println(getClosedBracketIndex(str, 1));
        } catch (MrudusStackUnderflowException | MrudusStackOverflowException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int getClosedBracketIndex(String str, int index) throws MrudusStackOverflowException, MrudusStackUnderflowException {
        MyIntStack s = new MyIntStack(str.length());
        for (int i = index; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '[') {
                s.push(i);
            } else if (ch == ']') {
                s.pop();
            }
            if (s.isEmpty()) {
                return i;
            }

        }
        return index;
    }
}
