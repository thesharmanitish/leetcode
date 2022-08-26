class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length-1;
        if(nums.length<2)
            return 0;
        while(start<end){
            int mid = start + (end-start)/2;
            if(mid>0 && nums[mid]>nums[mid-1] && mid <nums.length && nums[mid] > nums[mid+1])
                return mid;
            if(nums[mid]>nums[mid+1] ){
                 end = mid ;                                
            }
            else if(nums[mid]<nums[mid+1] ){
                start = mid +1;
            }
            
        }
        return start;
    }
}