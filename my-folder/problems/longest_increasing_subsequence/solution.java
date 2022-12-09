class Solution {
    public int lengthOfLIS(int[] nums) {
        // TreeSet<Integer> tset = new TreeSet<>();

        // for(int num:nums){
        //     Integer x = tset.ceiling(num);
        //     if(x!=null)
        //         tset.remove(x);
        //     tset.add(num);
        // }
        // return tset.size();
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<=i;j++){
                if(nums[i]>nums[j]){
                    dp[i] =Math.max(dp[i],1+dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;


    }
}