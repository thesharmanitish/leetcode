class Solution {
    public long zeroFilledSubarray(int[] nums) {
//         long res =0;
        
//         for (int i = 0, j = 0; i < nums.length; ++i) {
//             if (nums[i] != 0)
//                 j = i + 1;
//              res += i - j + 1;
//         }      
//         return res;
        
        long count =0, result = 0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
                count++;
            else
            {
                result=result+(count*(count+1))/2;
                count=0;
            }
            
        }
        return result+(count*(count+1))/2;
        
        
    }
}