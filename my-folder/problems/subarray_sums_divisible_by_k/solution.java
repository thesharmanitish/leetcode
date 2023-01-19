class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int count = 0, prefixSum = 0;
        int[] res =new int[k];
        res[0] = 1;
        for(int i=0;i<nums.length;i++){
            prefixSum += nums[i];
            int remainder = ((prefixSum % k)+k)%k;
            count+=res[remainder];
            res[remainder] +=1;
            
        }
        return count;
    }
}