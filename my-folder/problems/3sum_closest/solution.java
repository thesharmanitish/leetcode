class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0, diff = Integer.MAX_VALUE, min = 0;
        for(int  i=0;i<nums.length;i++){
        int j=i+1, k=nums.length-1;    
            while(j<k){
                sum = nums[i]+nums[j]+nums[k];
                int t = target-sum;
                
                if(Math.abs(t) < Math.abs(diff))
                    diff = t;
                if(sum < target){
                    j++;
                }else{
                    k--;
                }               
            }
        }
        return target - diff;
    }
}

// -5 -5 -4 0 0 3 3 4 5-