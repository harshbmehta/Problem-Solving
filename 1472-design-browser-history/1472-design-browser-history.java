
/*
Using two-stacks
*/
class BrowserHistory {
    Stack<String> history, forward;
    String currUrl;

    public BrowserHistory(String homepage) {
        history = new Stack<>();
        forward = new Stack<>();
        currUrl = homepage;
    }
    
    public void visit(String url) {
        history.push(currUrl);
        forward.clear();
        currUrl = url;
    }
    
    public String back(int steps) {
        while(steps > 0 && !history.isEmpty()) {
                forward.push(currUrl);
                currUrl = history.pop();
                steps--;
        }
        return currUrl;      
    }
    
    public String forward(int steps) {
        while(steps > 0 && !forward.isEmpty()) {
                history.push(currUrl);
                currUrl = forward.pop();
                steps--;
        }
        return currUrl;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */