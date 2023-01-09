class Solution {
    public int maximumCount(int[] nums) {
        int start = 0, end = nums.length-1;
        if(nums[0]>0 || nums[nums.length-1]<0)
            return nums.length;
        
        while(start < end){
            int mid = start + (end-start)/2;
            if(nums[mid]>=0){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        int neg = start;
        // if(neg ==0){
            
        //     int ind = Arrays.binarySearch(nums, 1);
        //     if(ind >=0)
        //         return nums.length-1-ind;
        //     else if(ind<-1 || ind>=nums.length)
        //         return 0;
        //     else return nums.length;
        // }
        start = 0; end = nums.length-1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(nums[mid]>0){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        // while(nums[start]==0)
        //     start++;
        if(end == nums.length-1)
            return 0;
        return Math.max(neg, nums.length-end);
    }
}