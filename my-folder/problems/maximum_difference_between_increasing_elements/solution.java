class Solution {
    public int maximumDifference(int[] nums) {
        int start =0, end = 0, max=-1;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[start]){
                max = Math.max(max, nums[i]-nums[start]);
            }
            else{
                start = i;
            }
        }
        return max;
    }
}