class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int gift:gifts)
            pq.add(gift);
        while(!pq.isEmpty() && k-->0){
            pq.add((int)Math.sqrt(pq.poll()));
        }
        long result = 0;
        while(!pq.isEmpty())
            result += (long)pq.poll();
        
        return result;
    }
}