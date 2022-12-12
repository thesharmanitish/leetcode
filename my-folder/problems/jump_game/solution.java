class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length <2)
            return true;
        int x=0;
        boolean flag = true;
        for(int i= nums.length-2;i>=0;i--){
            flag = false;
            if(nums[i]>x){
                x=0;
                flag = true;
            }
            else
                x++;
        }
        return flag;
    }
}