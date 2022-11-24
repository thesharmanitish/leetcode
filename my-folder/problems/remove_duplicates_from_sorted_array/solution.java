class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0], start = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>prev){
                nums[start++] = nums[i];
                prev = nums[i];
            }
        }
        return start;
    }
}