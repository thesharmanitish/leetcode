class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 1, res = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] < nums[i]){
                ++max;
            }else{
                res = Math.max(max, res);
                max =1;
            }
        }
        return res>max ?res:max;
    }
}