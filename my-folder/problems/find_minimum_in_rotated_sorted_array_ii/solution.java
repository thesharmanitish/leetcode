class Solution {
    public int findMin(int[] nums) {
      int i = 0;
        int j = nums.length - 1;
        int min = nums[i];
        while(i<=j) {
            min = Math.min(min, Math.min(nums[i++], nums[j--]));
        }
        return min;
    }
}