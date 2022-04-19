class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
     int start =0 , end = 0, max =0,res =0;
     for(int i:nums){
         if(i==0){
             start=end+1;
         }
            max = end-start+1;
            res = Math.max(max,res);
            end++;
        }
        return res;
    }
}