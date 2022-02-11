class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return PredictTheWin(nums, 0, nums.length-1, 1) >=0;

    }
    public int PredictTheWin(int[] nums, int start, int end, int turn) {
        if(start == end) 
            return turn * nums[start];
        int a = turn*nums[start] + PredictTheWin(nums, start+1,end,(-1)*turn);
        int b = turn*nums[end] + PredictTheWin(nums, start,end-1,(-1)*turn);
        return turn * Math.max(turn*a,turn*b);
        
    }
}