class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        int start = 0, curr=0, count =-1;
        for(int end=0;end<nums.length;end++){
            curr += nums[end];
            
            while(curr>sum-x && start<=end){
                curr -= nums[start++];
            }
            
            if(curr == sum-x)
                count = Math.max(count, end-start+1);
            
        }
        return count != -1 ? nums.length - count : -1;
    }
}