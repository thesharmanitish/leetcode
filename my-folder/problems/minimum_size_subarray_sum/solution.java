class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n= nums.length, ret = Integer.MAX_VALUE, sum=0, start = 0;
        
        for(int i=0;i<n;i++){
            sum += nums[i];
            while(sum>=target){
                ret = Math.min(ret, i-start+1);
                sum -= nums[start];
                start+=1;
            }
        }
        return ret==Integer.MAX_VALUE?0 : ret;
    }
}