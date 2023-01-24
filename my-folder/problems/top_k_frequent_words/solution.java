class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        
        for(String word:words ){
            freqMap.put(word, freqMap.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Object[]> pq = new PriorityQueue<>((a,b)-> (int)b[1] == (int)a[1]? String.valueOf(a[0]).compareTo(String.valueOf(b[0])) :(int)b[1]- (int)a[1]);

        for(Map.Entry<String, Integer> entry:freqMap.entrySet()){
            pq.add(new Object[]{entry.getKey(), entry.getValue()});
        }
        List<String> result = new ArrayList<>();
        while(k-->0){
            
            result.add(String.valueOf(pq.poll()[0]));
        }
        // Collections.sort(result, (a,b) -> a.compareTo(b));
        return result;
    }
}