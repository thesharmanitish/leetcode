class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean flag = false;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<= nums[i])
                continue;
            
            if(flag)
                return false;
            
            if(i>1 && nums[i-2]>nums[i]){
                nums[i] = nums[i-1];
            }else 
                nums[i-1] = nums[i];
            
            flag = true;
        }
        return true;
    }
}