class Solution {
    public int maxSubArray(int[] nums) {
        return findBestSubarray(nums, 0, nums.length - 1);
    }
    
    private int findBestSubarray(int[] nums, int left, int right) {
        // Base case - empty array.
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        int mid = (left + right) >>1;
        int cur =0, maxLeft=0, maxRight=0, max= 0;
        
        for(int i=mid-1;i>=left;i--){
            cur += nums[i];
            maxLeft = Math.max(cur, maxLeft);
        }
        cur =0;
        for(int i=mid+1;i<=right;i++){
            cur += nums[i];
            maxRight = Math.max(cur, maxRight);            
        }
        max = nums[mid]+maxLeft+maxRight;
        
        int leftHalf = findBestSubarray(nums, left, mid - 1);
        int rightHalf = findBestSubarray(nums, mid + 1, right);        
        
        return Math.max(max, Math.max(leftHalf, rightHalf));
    }
}