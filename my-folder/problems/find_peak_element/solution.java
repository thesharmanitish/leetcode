class Solution {
    public int findPeakElement(int[] nums) {
          int max = 0, ind = -1;
          if(nums.length<2) return 0;
          // for(int i=0;i<nums.length;i++){   // find max, and it will be greater than every other no.
          //     if(max<nums[i]){            // O(n)
          //         max= nums[i];
          //        ind = i;
          //         }
          //  }
          // return ind==Integer.MIN_VALUE?-1:ind;
          int i=0, j=nums.length-1, mid =0;
        while(i<j){
            mid = i+(j-i)/2;
            if(nums[mid] > nums[mid+1]){
                j = mid;
            }
            else if(nums[mid] <nums[mid+1]){
                i=mid+1;
                
            }
            
        }
        return nums[i]>nums[j]?i:j;
    }
}