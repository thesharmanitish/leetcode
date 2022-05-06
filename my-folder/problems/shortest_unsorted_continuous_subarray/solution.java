class Solution {
   
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int start = 0, end = 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            max = Math.max(max, nums[i]);
            if(nums[i]<max){
                end = i;
            }
            
            min = Math.min(min, nums[n-i-1]);
            if(min<nums[n-i-1])
                start = n-i-1;
        }
        return end>start?end-start+1:0;    

    }    
    
// public int findUnsortedSubarray(int[] nums) {
      
//     int l =-1, h=-2, n = nums.length, start = nums[0], end = nums[n-1];
//     for(int i=1;i<nums.length;i++){
//         start = Math.max(start,nums[i]);
//         end = Math.min(end,nums[n-i-1]);
        
//         if(nums[i]<start)
//             h = i;
//         if(nums[n-i-1]>end)
//             l = n-i-1;
        
//     }
//     return h - l + 1;
// }
    
    
// public int findUnsortedSubarray(int[] nums) {
//         int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//         for (int i = 1; i < nums.length; i++) {
            
//             if(i>0 && nums[i] <nums[i-1]){
//                 min = Math.min(min,nums[i]);
                
//             }
            
//         }
    
//         for (int i = nums.length - 2; i >= 0; i--) {
//             if(i<nums.length-1 && nums[i] >nums[i+1]){
//                 max = Math.max(max,nums[i]);
//             }
//         }
    
//         int i=0, j=0;
//         for ( i = 0; i< nums.length; i++) {
//             if(min<nums[i])
//                 break;

//         }
//         for ( j = nums.length - 1; j >= 0; j--) {
//                 if(max>nums[j])
//                     break;
//         }
//         return j > i ? j - i + 1 : 0;
//     }
    
//     public int findUnsortedSubarrayBrute(int[] nums) {
//         int start = nums.length, end = 0;
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[i] > nums[j]){
//                     start = Math.min(start, i);
//                     end = Math.max(end, j);
//                 }
                
//             }
//         }
//         return end - start <0?0:end-start+1;
//     }
}