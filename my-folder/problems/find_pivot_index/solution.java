class Solution {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int cursum = 0;
        
        for(int i=0;i<nums.length;i++){
            
            sum -= nums[i];
            if(cursum ==sum)
                return i;
            cursum += nums[i];
        }
        return -1;
    }
}