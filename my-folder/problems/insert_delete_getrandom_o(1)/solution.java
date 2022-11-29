class RandomizedSet {
    Map<Integer, Integer> map;
    TreeMap<Integer, Integer> tmap;
    int ind = 0;
    public RandomizedSet() {
        map = new HashMap<>();
        tmap = new TreeMap<>();
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val, ind);
                    
        tmap.put(ind++, val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;   
        tmap.remove(map.get(val));     
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        if(map.isEmpty())
            return -1;
        int r = tmap.firstKey() + (int)(Math.random() * ((tmap.lastKey() - tmap.firstKey()) + 1));
        // int r = rand.nextInt(ind);
        Integer fentry = tmap.floorKey(r);
        
        if( fentry==null)
            fentry = tmap.ceilingKey(r);
        // System.out.println(r +" "+ fentry +" "+ tmap.get(fentry))    ;
        return fentry!=null ? tmap.get(fentry) : -1;

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */