class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=n-1;i>=0;i--){
            if(!queue.isEmpty()){
                queue.add(nums[2*i+1]);
                nums[2*i+1] = queue.poll();
            }
            queue.add(nums[2*i]);
            nums[2*i] = nums[i];
        }
        return nums;
    }
}