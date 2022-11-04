class MovingAverage {
    Deque<Integer> list;
    int start =0, end =0, s = 0;
    double sum = 0;
    public MovingAverage(int size) {
        list =  new LinkedList<>();
        s = size;
    }
    
    public double next(int val) {
        if(end<s){
            list.add(val);
            end++;
            sum += val;
        }else{
            sum += val- list.getFirst();
            list.removeFirst();
            list.add(val);
        }
        return sum/end;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */