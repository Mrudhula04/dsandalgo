public class BrowserStarting {
    private String[] history;
    private int top;
    private int capacity;

    public BrowserStarting(int size) {
        capacity = size;
        history = new String[size];
        top = -1;
    }

    public void browse(String url) {
        // TODO: Add URL to history
    }

    public String back() {
        // TODO: Go back to previous URL
        return null;
    }

    public String forward() {
        // TODO: Go forward to next URL
        return null;
    }

    public void printHistory() {
        // TODO: Print browsing history
    }

    public static void main(String[] args) {
        BrowserStarting browser = new BrowserStarting(5);
        // TODO: Test the browser functionality
    }
}