class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, t=0;
        int sum = (n*(n+1)) >>1;
        for(int x:nums)
            t+=x;
        return sum-t;
        
    }
}