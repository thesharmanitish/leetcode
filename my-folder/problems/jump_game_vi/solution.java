class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        priorityQueue.add(new int[] { nums[0], 0 });
        int score = nums[0];
        for(int i=1;i<nums.length;i++){
            while(priorityQueue.peek()[1]<i-k){
                priorityQueue.remove();
            }
            score = nums[i] + priorityQueue.peek()[0]; 
            priorityQueue.add(new int[]{score,i});
        }
        return score;
    }
}