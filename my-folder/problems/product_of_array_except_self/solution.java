class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        boolean flag = false, multizero  =false;
        for(int i=0;i<nums.length;i++){
            if(nums[i] !=0){
                prod *= nums[i];
                
            }else {
                if(flag)
                    multizero = true;
                flag = true;
            
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(!flag)
                    nums[i] = prod/nums[i];
                else 
                    nums[i] = 0;
            }
            else{
                if(multizero)
                    nums[i] = 0;    
                else 
                    nums[i] = prod;
            }
        }
        return nums;
    }
}