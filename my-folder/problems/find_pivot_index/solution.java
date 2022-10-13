class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num:nums)
            sum+=num;
        int cursum = 0;
        
        for(int i=0;i<nums.length;i++){
            
            sum -= nums[i];
            if(cursum ==sum)
                return i;
            cursum += nums[i];
        }
        return -1;
        
//         int[] left = new int[nums.length];
//         int[] right = new int[nums.length];
        
//         for(int i=1;i<nums.length;i++){
//             left[i] =left[i-1] + nums[i-1];
//             right[nums.length-1-i] = right[nums.length-i]+ nums[nums.length-i];
//         }
        
//         for(int i=0;i<nums.length;i++){
//             if(left[i] == right[i])
//                 return i;
//         }
//         return -1;
    }
    
}