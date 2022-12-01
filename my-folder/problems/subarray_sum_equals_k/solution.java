class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        map.put(0,1);
        for(int num:nums){
            sum+=num;
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
                
            }
            map.put(sum, map.getOrDefault(sum, 0 )+1);
        } 
        return count;  
    }


    //     public int subarraySum(int[] nums, int k) {
    //     int[] dp = new int[nums.length+1];
    //     if(nums.length ==1)
    //         return nums[0] == k?1:0;
    //     for(int i=1;i<=nums.length;i++){
    //         dp[i] = dp[i-1] +nums[i-1];
    //     }
    //     int count = 0;
    //     for(int i=1;i<dp.length;i++){
    //         for(int j=i-1;j>=0;j--){
    //             if(dp[i]-dp[j] == k)
    //                 count++;
    //         }
    //     }
    //     return count;
    // }
}