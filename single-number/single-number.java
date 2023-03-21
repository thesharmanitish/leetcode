class Solution {
    public int singleNumber(int[] nums) {
        int pos = 0;
        
        for(int num:nums){
            pos = pos ^ num;
            
        }
        return pos;
    }
}