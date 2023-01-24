class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1)
            return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone:stones)
            pq.offer((stone));
        
        while(pq.size()>1){
            int x = pq.poll();
            x = x - pq.poll();
            if(x!=0);
              pq.offer(x);
        }
        return pq.isEmpty()?0:pq.poll();
    }
}