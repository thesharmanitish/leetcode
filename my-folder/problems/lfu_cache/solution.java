class LFUCache {
    int capacity = 0;
    int i = 0;
    Map<Integer, int[]> vMap;     // key value ind
    TreeMap<Integer, LinkedHashSet<Integer>> freqMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        vMap = new HashMap<>();
        freqMap = new TreeMap<>();
    }
    
    public int get(int key) {
        if(vMap.isEmpty() || !vMap.containsKey(key))
            return -1;
        
        int[] arr = vMap.get(key);
        arr[1] = i++;
        LinkedHashSet<Integer> set = freqMap.get(arr[2]);
        set.remove(key);
        freqMap.put(arr[2], set);
        arr[2] += 1;
        set = freqMap.get(arr[2]);
        if(set == null) 
            set = new LinkedHashSet<>();

        set.add(key);
        freqMap.put(arr[2], set);
        vMap.put(key, arr);
        return arr[0];

    }
    
    public void put(int key, int value) {
        if(capacity<1)
            return;

        if(vMap.isEmpty()){
            vMap.put(key, new int[]{value, i++, 1});
            LinkedHashSet<Integer> set= new LinkedHashSet<>();
            set.add(key);
            freqMap.put(1, set);

        }else if(vMap.containsKey(key)){
            int[] arr = vMap.get(key);
            arr[1] = i++;
            arr[0] = value;
            LinkedHashSet<Integer> set = freqMap.get(arr[2]);
            set.remove(key);
            freqMap.put(arr[2], set);
            arr[2] += 1;
            set = freqMap.get(arr[2]);
            if(set == null) 
                set = new LinkedHashSet<>();
            set.add(key);
            freqMap.put(arr[2], set);
            vMap.put(key, arr);
            
        }else{
            while(vMap.size()>=capacity){
                LinkedHashSet<Integer> set = freqMap.firstEntry().getValue();
                if(set.isEmpty()){
                    freqMap.remove(freqMap.firstKey());
                    continue;
                }
                Integer x = set.stream().findFirst().get();
                if(x == null){
                    freqMap.remove(freqMap.firstKey());
                    continue;
                }
                set.remove(x);
                if(!set.isEmpty())
                    freqMap.put(freqMap.firstKey(), set);
                vMap.remove(x);
            }            
            vMap.put(key, new int[]{value, i++, 1});

            LinkedHashSet<Integer> set= freqMap.get(1);
            if(set == null)
                set= new LinkedHashSet<>();
            set.add(key);
            freqMap.put(1, set);            
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */