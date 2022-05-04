class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1, ind = -1;
        boolean flag = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i] !=0){
                prod *= nums[i];
                
            }else {
                if(flag){
                    return new int[nums.length];
                }
                flag = true;
                ind = i;
            
            }
        }
        if(!flag){
           for(int i=0;i<nums.length;i++)
               nums[i] = prod/nums[i];
        }else{
           nums = new int[nums.length];
           nums[ind] = prod;
        }
        return nums;
    }
}