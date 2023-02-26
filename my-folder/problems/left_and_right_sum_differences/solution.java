class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int[] lSum = new int[nums.length];
        int[] rSum = new int[nums.length];
        
        for(int i=1;i<nums.length;i++){
            lSum[i] = nums[i-1] + lSum[i-1];
            rSum[nums.length-1-i] = nums[nums.length-i] + rSum[nums.length-i];
        }
        
        for(int i=0;i<nums.length;i++){
            nums[i] = lSum[i]>rSum[i] ? lSum[i]-rSum[i]:rSum[i]-lSum[i];
        }
        return nums;
    }
}

/**
10 4 8 3
0  10 14


*/