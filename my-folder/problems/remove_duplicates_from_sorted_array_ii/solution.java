class Solution {
    public int removeDuplicates(int[] nums) {
        int start =0, end = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[start]){
                nums[++end] = nums[i];
                start = end;               
            }else if(end>start){
                continue;
            }else{
                nums[++end] = nums[i];
            }
        
        }
        return end+1;
    }
}