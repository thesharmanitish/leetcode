class Solution {
    public int missingNumber(int[] nums) {
        // boolean[] arr = new boolean[100000];
        // for(int n:nums){
        //     arr[n] = true;
        // }
        // for(int i=0;i<arr.length;i++){
        //     if(!arr[i])
        //         return i;
        // }
        // return -1;
        int sum = 0;
        for(int n:nums)
            sum+=n;
        
        int target = nums.length *( nums.length+1);
        target >>>=1;
        
        return target -sum;
            
    }
}