class Node{
    int val;
    int min;
    Node next;
    public Node(int val){
        this.val = val;
        this.min = val;
    }
}

class MinStack {
    //best solution
    Node root;
    public MinStack() {
    }    
    public MinStack(int val) {
        root = new Node(val);
    }
    
    public void push(int val) {
        if(root == null)
            root = new Node(val);
        else{
            Node nxt = new Node(val);
            nxt.next = root;
            root = nxt;
            root.min = Math.min(root.val, root.next.min);
        }
    }
    
    public void pop() {
        if(root ==null)
            return;
        root = root.next;
    }
    
    public int top() {
       if(root ==null)
            return -1;
       return root.val;
    }
    
    public int getMin() {
        if(root ==null)
            return -1;
        return root.min;
    }    
    
    
    
    
/**
    My Solution
    Deque<Long> stack;
    PriorityQueue<Long> pq;
    public MinStack() {
        stack = new LinkedList<>();
        pq = new PriorityQueue<Long>((o1, o2) -> {
			return o1.intValue() > o2.intValue()?1:-1;
		});
    }
    
    public void push(int val) {
        stack.addFirst((long)val);
        pq.add((long)val);
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            long val = stack.pop();
            pq.remove(val);
        }
    }
    
    public int top() {
       int res = -1;
       if(!stack.isEmpty())
            res = (int) (long)stack.peek();   
        return res;
    }
    
    public int getMin() {
        int res = -1;
          if(!stack.isEmpty())
             res = (int) (long) pq.peek();
        return res;
    }
    **/
    
    /**
    // Another solution
    Stack<Integer> stack = new Stack<Integer>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public void push(int val) {
        stack.push(val);
        pq.add(val);
    }
    
    public void pop() {
        pq.remove(stack.pop());
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
    
    */
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */