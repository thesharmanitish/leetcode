class Solution {
    public int minDeletion(int[] nums) {
        int count = 0, n = nums.length;
        for(int i=0;i<n;){
            if(i+1<n && nums[i] == nums[i+1]){
                count++;
                i+=1;
            }else
                i+=2;
        }
        if((n-count)%2==1)
            return count+1;
        return count;
        
    }
}