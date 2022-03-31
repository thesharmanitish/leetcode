class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int count=Integer.MAX_VALUE,start =0,sum = 0, n = nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            while(sum>=target){
                count = Math.min(count,i-start+1);
                sum-=nums[start];
                start +=1;
                
            }
        }
    return count==Integer.MAX_VALUE?0:count;
    }
}