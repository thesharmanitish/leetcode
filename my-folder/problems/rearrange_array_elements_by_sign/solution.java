class Solution {
    public int[] rearrangeArray(int[] nums) {
        int j=0, k=1;
        int[] res = new int[nums.length];
        for( int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                res[j] =nums[i];
                j+=2;
            }else {
                res[k] =nums[i];
                k+=2;
            }
            
        }
        return res;
    }
}