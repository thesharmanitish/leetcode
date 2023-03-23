class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                continue;
            nums[start++] = nums[i];
        }
        for(;start<nums.length;start++){
            nums[start] = 0;
        }
    }
}