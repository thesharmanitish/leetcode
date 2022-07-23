class NumberContainers {
    
    
    Map<Integer, Integer> bucketMap;
    Map<Integer, TreeSet<Integer>> valueMap;
    boolean flag = false;
    int prev, preValue;
    public NumberContainers() {
        bucketMap = new HashMap(); 
        valueMap = new HashMap<>();
        
    }
    
    public void change(int index, int number) {
        
        int v =-1;
        TreeSet<Integer> p;
        if(bucketMap.get(index) !=null){
            v= bucketMap.get(index);
            p = valueMap.get(v);
            if(p != null){
                p.remove(index);
                valueMap.put(v, p);
                flag =true;
            }
        }
        bucketMap.put(index, number);
        p =  valueMap.get(number);
        if(p==null){
            p = new TreeSet<>();
        }
        p.add(index);
        valueMap.put(number, p);
    }
    
    public int find(int number) {
        if(prev ==number && !flag)
            return preValue;
        if(valueMap.get(number) == null)
            return -1;
        TreeSet<Integer> ret = valueMap.get(number);
        if (ret == null || ret.isEmpty()|| ret.first() == null)
            return -1;
        prev = number;
        preValue = ret.first();
        flag = false;
        return preValue;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */