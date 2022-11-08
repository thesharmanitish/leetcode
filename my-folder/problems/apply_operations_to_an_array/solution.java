class Solution {
    public int[] applyOperations(int[] nums) {
        if(nums.length<=1)
            return nums;
        int start = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i] *=2;
                nums[i+1] = 0;
            }
            if(nums[i]!=0)
                nums[start++] = nums[i];
        }
        nums[start++] = nums[nums.length-1];
        for(int i=start;i<nums.length;i++)
            nums[i] = 0;

        return nums;
    }
}