// class Solution {
//     public int maxSubArray(int[] nums) {
//         if(nums.length ==0)
//             return -1;
//         int curMax = 0, max = nums[0];
        
//         for(int i=0;i<nums.length;i++){
//             curMax = Math.max(nums[i], curMax +nums[i]);
//             max = Math.max(max, curMax)    ;
//         }
//         return max;
//     }
// }

class Solution {
    public int maxSubArray(int[] nums) {
        return findBestSubarray(nums, 0, nums.length - 1);
    }
    
    private int findBestSubarray(int[] nums, int left, int right) {
        // Base case - empty array.
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        
        int mid = (left+right) >>1;
        int leftHalf = 0, rightHalf = 0, sum = 0;
        for(int i= mid-1;i>=left;i--){
            sum += nums[i];
            leftHalf = Math.max(leftHalf, sum);
        }
        sum = 0;
        for(int i = mid+1;i<=right;i++){
            sum += nums[i];
            rightHalf = Math.max(rightHalf, sum);
        }
        int max = leftHalf+rightHalf+nums[mid];
        
        leftHalf = findBestSubarray(nums, left, mid-1);
        rightHalf = findBestSubarray(nums, mid+1, right);
        return Math.max(max, Math.max(leftHalf, rightHalf));
    }
}