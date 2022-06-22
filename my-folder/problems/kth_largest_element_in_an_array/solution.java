class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length <1)
            return -1;
        else if(nums.length ==1 && k==1)
            return nums[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{return o1-o2;});
        int size = nums.length-k;
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
            if(pq.size() >k)
                pq.poll();
        }
        return pq.poll();
    }
}