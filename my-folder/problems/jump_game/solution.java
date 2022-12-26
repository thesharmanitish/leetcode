class Solution {
    public boolean canJump(int[] nums) {
        

        boolean flag = false;
        int count = 1;
        for(int i= nums.length-2;i>=0;i--){
            if(nums[i]>=count){
                count = 1;
                continue;
            }
            count++;
        }
        return count<2;
    }
}