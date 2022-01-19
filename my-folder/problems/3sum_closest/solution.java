class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int max = 0;
        if(nums.length<3) return max;
        Arrays.sort(nums);
        boolean flag = false;
        for(int i=0;i<nums.length-2;i++){
            int j=i+1,k=nums.length-1;
            
            while(j<k){
                
                    
                int sum = nums[i]+nums[j]+nums[k];
                if(!flag) {
                    flag =true;
                    max = sum;
                }
                if(sum<target) j++;
                else if(sum>target)k--;
                else return sum;
                    
                if(Math.abs(max-target)>Math.abs(sum-target))
                    max = sum;
                
            }
        
        
        }
        return max;
        
    }
}