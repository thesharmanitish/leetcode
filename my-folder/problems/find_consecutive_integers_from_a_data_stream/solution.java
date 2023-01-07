class DataStream {
    Queue<Integer> queue = new LinkedList<>();
    int size = 0, value = -1;
    public DataStream(int value, int k) {
        size = k;
        this.value = value;
    }
    
    public boolean consec(int num) {
        if(num == value){
            queue.add(num);
            if(queue.size()>= size){
                queue.poll();
                return true;
            }
        }else{
            queue.clear();
        }
        return false;
        
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */