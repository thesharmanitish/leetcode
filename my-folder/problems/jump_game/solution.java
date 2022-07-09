enum Index {
    GOOD, BAD, UNKNOWN
}
class Solution {
    Index[] memo;
    int[] dp;
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }
        int furthestJump = Math.min(nums[position]+position,nums.length-1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if(canJumpFromPosition(nextPosition, nums)){
                 memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }
    
    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;        
        return canJumpFromPosition(0, nums);
        
        
        
        // int len = nums.length;
        // int max = 0;
        // for(int i=0; i<=max; i++){
        //     max = Math.max(max, i+nums[i]);
        //     if(max >= len-1)  return true;
        // }
        // return false;
        
        
        
//         if(nums.length <=1)
//             return true;
//         if(nums[0] ==0)
//             return false;
//         boolean flag =false;
//         for(int i=nums.length-1;i>0;i--){
//             if(nums[i]!=0)
//                 continue;
//             int t = 1;
//             flag  = true;
//             int prev = i;
//             while(--i>=0){
//                 if(nums[i]>t){
//                     flag = false;
//                     break;
//                 }else if(nums[i]==t &&  prev == nums.length-1){
//                     flag = false;
//                     break;
//                 }
//                 t++;
//             }
//             if(flag)
//                 return false;
//         }
        
//             return true;
    }
}