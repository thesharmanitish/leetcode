class BrowserHistory {
    List<String> queue;
    int size, current =-1;
    public BrowserHistory(String homepage) {
        queue = new ArrayList<>();
        queue.add(homepage);
        size =1;
        current = 0;
    }
    
    public void visit(String url) {
        if(size>current+1){
            size  = current+1;
        }
        
        current+=1;
        queue.add(current, url);
        size +=1;
    }
    
    public String back(int steps) {
        if(steps>current){
            current = 0;
            return queue.get(0);
        }
        current -= steps;
        return queue.get(current);
    }
    
    public String forward(int steps) {
        if(current+steps>size-1){
            current = size-1;
            return queue.get(current);
        }
        current += steps;
        
        return queue.get(current);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */