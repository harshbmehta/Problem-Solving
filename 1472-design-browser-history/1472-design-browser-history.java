/*
Using Dynamic Array

lastURL is used to keep the track of last index on right further which we should not move in forward operation even if there are elements.
The reason behind that is we do not want to return string beyond that point when we insert the url manually in browser, it overrides the forward operation
*/
class BrowserHistory {
    ArrayList<String> visitedURLs;
    int currURL, lastURL;

    public BrowserHistory(String homepage) {
        // 'homepage' is the first visited URL.
        visitedURLs = new ArrayList<String>(Arrays.asList(homepage));
        currURL = 0; 
        lastURL = 0;
    }
    
    public void visit(String url) {
        currURL += 1;
        if (visitedURLs.size() > currURL) {
            // We have enough space in our array to overwrite an old 'url' entry with new one.
            visitedURLs.set(currURL, url);
        } else {
            // We have to insert a new 'url' entry at the end.
            visitedURLs.add(url);
        }
        // This 'url' will be last URL if we try to go forward.
        lastURL = currURL;
    }
    
    public String back(int steps) {
        // Move 'currURL' pointer in left direction.
        currURL = Math.max(0, currURL - steps);
        return visitedURLs.get(currURL);
    }
    
    public String forward(int steps) {
        // Move 'currURL' pointer in right direction.
        currURL = Math.min(lastURL, currURL + steps);
        return visitedURLs.get(currURL);
    }
}
/*
Using two-stacks
*/
// Slower runtime compared to Dynamic array approach
// class BrowserHistory {
//     Stack<String> history, forward;
//     String currUrl;

//     public BrowserHistory(String homepage) {
//         history = new Stack<>();
//         forward = new Stack<>();
//         currUrl = homepage;
//     }
    
//     public void visit(String url) {
//         history.push(currUrl);
//         forward.clear();
//         currUrl = url;
//     }
    
//     public String back(int steps) {
//         while(steps > 0 && !history.isEmpty()) {
//                 forward.push(currUrl);
//                 currUrl = history.pop();
//                 steps--;
//         }
//         return currUrl;      
//     }
    
//     public String forward(int steps) {
//         while(steps > 0 && !forward.isEmpty()) {
//                 history.push(currUrl);
//                 currUrl = forward.pop();
//                 steps--;
//         }
//         return currUrl;
//     }
// }

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */