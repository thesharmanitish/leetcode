class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b)-> { return b.getValue() == a.getValue()? a.getKey().compareTo(b.getKey()):b.getValue().compareTo(a.getValue());});
        HashMap<String, Integer> map = new HashMap<>();
        for(String word:words)
            map.put(word, map.getOrDefault(word, 0)+1);
        
        for(Map.Entry<String,Integer> entry:map.entrySet())
            pq.add(entry);
        List<String> result = new ArrayList<>();
        if(k>pq.size())
            return result;
        for(int i=0;i<k;i++)
            result.add(pq.poll().getKey());
        return result;
    }
}