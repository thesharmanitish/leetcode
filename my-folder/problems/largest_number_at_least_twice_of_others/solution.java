class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE+1, smax = Integer.MIN_VALUE, ind =-1, i=0;
        if(nums.length<2)
            return 0;
        for(int num:nums){
            if(max<num){
                smax =max;
                max = num;
                ind = i;
            }else if(smax<num)
                smax = num;
            i++;
        }
        if(smax<=(max>>1))
            return ind;
        return -1;
    }
}