class Solution {
    public int searchInsert(int[] nums, int target) {
        int start =0 , end = nums.length-1;
        if(nums == null || nums.length == 0) return 0;

        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target)
                end = mid;
            
            else 
                start = mid+1;
        }
        return nums[start] >= target? start : start+ 1;
    }
}