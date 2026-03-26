import java.util.*;

class BrowserHistory {

    private Deque<String> back;
    private Deque<String> forward;
    private String current;

    public BrowserHistory(String homepage) {
        back = new ArrayDeque<>();
        forward = new ArrayDeque<>();
        current = homepage;
    }

    public void visit(String url) {
        back.push(current);
        current = url;
        forward.clear();
    }

    public String back(int steps) {
        while (steps > 0 && !back.isEmpty()) {
            forward.push(current);
            current = back.pop();
            steps--;
        }
        return current;
    }

    public String forward(int steps) {
        while (steps > 0 && !forward.isEmpty()) {
            back.push(current);
            current = forward.pop();
            steps--;
        }
        return current;
    }
}
