class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for(int pile:piles){
            pq.add(pile);
            sum += pile;
        }
        
        while(k-->0){
            sum -=pq.peek();
            int x = (int) Math.ceil(pq.poll()/2.0);
            pq.add(x);
            sum+=x;
        }
        // while(!pq.isEmpty())
        //     sum+= pq.poll();
        return sum;
    }
}