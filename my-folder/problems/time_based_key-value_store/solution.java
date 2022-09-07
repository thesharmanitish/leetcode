class TimeMap {
//     private Map<String, TreeMap<Integer, String>> map;
//     public TimeMap() {
//         map = new HashMap<>();
//     }
    
//     public void set(String key, String value, int timestamp) {
//         TreeMap<Integer, String> tm;
        
//         if(!map.containsKey(key))
//             tm = new TreeMap<>();
//         else
//             tm = map.get(key);
        
//         tm.put(timestamp, value);
//         map.put(key, tm);        
//     }
    
//     public String get(String key, int timestamp) {
//         if(!map.containsKey(key))
//             return "";
//         TreeMap<Integer, String> tm = map.get(key);
        
//         if(tm.floorEntry(timestamp) == null)
//             return "";
        
//         return tm.floorEntry(timestamp).getValue();
                
                
    // }
    private static final String EMPTY_STR = "";
    private Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return EMPTY_STR;
        Map.Entry<Integer, String> e = map.get(key).floorEntry(timestamp);
        return e != null ? e.getValue() : EMPTY_STR;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */