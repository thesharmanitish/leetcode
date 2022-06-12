class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] arr = new boolean[1<<20];
        int start=0, sum =0, max= 0;
        for (int end = 0; end < nums.length; end++){
                while(arr[nums[end]]){
                   arr[nums[start]] = false;
                   sum -= nums[start++] ;
                }
                arr[nums[end]] = true;
                sum += nums[end];        
            max = Math.max(max, sum);
        }
        
        
        return max;
    }
}