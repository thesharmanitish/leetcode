class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0, cur = 0, i=0;
        for(int num:nums){
            if(num==0){
                count++;
                cur+=i;
                i++;
            }else{
                count+=Math.max(cur, 0);
                cur = 0;
                i=0;
            }
        }
        count+=Math.max(cur, 0);
        return count;
    }
}