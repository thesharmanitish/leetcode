class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, curMax = 0;
        if(nums.length<=1)
            return nums[0];
        for(int i=0;i<nums.length;i++){
            curMax = curMax+nums[i];
            max = Math.max(max, curMax);
            if(curMax<0)
                curMax = 0;
        }

        return max;
        
        
        
        
        
//                 int n = nums.length;
//         int max = Integer.MIN_VALUE, sum = 0;
        
//         for(int i=0;i<n;i++){
//             sum += nums[i];
//             max = Math.max(sum,max);
            
//             if(sum<0) sum = 0;
//         }
        
//         return max;
    }
}