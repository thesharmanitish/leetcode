class Solution {
    public int findMin(int[] nums) {

        if(nums.length ==1 || nums[0] < nums[nums.length-1])
            return nums[0];
        int start = 0, end = nums.length-1, res=-1;
        
//                 while(start<end-1){
//             int mid= start+ (end-start)/2;
//             while(start+1 < nums.length  && nums[start]==nums[start+1])
//                 start++;
//             while(end >0 && nums[end]==nums[end-1])
//                 end--;
            
//             if(nums[mid]>nums[end]){ //left smaller
//                 start = mid +1;
//             }else if(nums[mid]<nums[end]){
//                 end = mid;
//             }

//         }
//          return nums[start]>nums[end]?nums[end]:nums[start];
//     }
    
        while(start<end){
            int mid= start+ (end-start)/2;

            if(nums[mid]>nums[end]){
                start = mid+1;
            }
            else if(nums[mid]<nums[start]){
                end = mid;
                start++;
            }else{
                end--;
            }
        }
        return nums[start];
    }
}