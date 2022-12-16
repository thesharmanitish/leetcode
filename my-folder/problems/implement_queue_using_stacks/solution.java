class MyQueue {
    
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 =  new Stack<>();
        stack2 =  new Stack<>();
    }
    
    public void push(int x) {
        stack2.push(x);
        if(stack1.isEmpty()){
            populateStack();
        }
    }
    
    public int pop() {
        if(stack1.isEmpty()){
            populateStack();
        }
        if(stack1.isEmpty()){
            return -1;
        }        
        return stack1.pop();
    }
    
    public int peek() {
        if(stack1.isEmpty()){
            populateStack();
        }
        if(stack1.isEmpty()){
            return -1;
        }        
        return stack1.peek();        
    }
    
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty())
            return true;
        return false;
    }
    public void populateStack(){

        while(!stack2.isEmpty())
            stack1.push(stack2.pop());        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */