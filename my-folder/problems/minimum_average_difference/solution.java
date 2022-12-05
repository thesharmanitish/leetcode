class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0, left = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        int min = Integer.MAX_VALUE;
        int ind = 0, i=0;
        for(i=0;i<nums.length-1;i++){
            left+=nums[i];
            long temp = Math.abs(left/(i+1) -  (sum-left)/(nums.length-i-1));
            
            if(min>temp){
                min = (int)temp;
                ind = i;
            }
        }
        left+=nums[nums.length-1];
        if(min> (left/(i+1)))
            ind = i;
        return (int)ind;
    }
}