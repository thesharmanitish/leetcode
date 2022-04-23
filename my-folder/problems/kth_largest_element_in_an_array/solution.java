class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> {return o1 - o2;});
        if(k >nums.length)
            return -1;
        for(int num:nums){
            pq.offer(num);
            if(pq.size() >k)
                pq.poll();
        }
        return pq.poll();
    }
}