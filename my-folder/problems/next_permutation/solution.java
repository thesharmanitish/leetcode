class Solution {
    public void nextPermutation(int[] nums) {
        int i=0;
        for( i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1])
               break;
        }
        if(i== nums.length-1){
            Arrays.sort(nums);
            return;
        }
        for(i=nums.length-1;i>0;i--){
            if(nums[i]> nums[i-1]){
                int start =i;
                while(start<nums.length && nums[start] >nums[i-1])
                    start++;                
                swap(nums, i-1, start-1);
                reverse(nums, i);   
                return;
            }
        }
    }

    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    } 
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }       
}