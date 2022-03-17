class Solution {
    public int[] sortArray(int[] nums) {
        int prev = 0;
        for(int i=1;i<nums.length;i++){
            prev = i-1;
            int temp = nums[prev+1];
            while(prev>=0){
                //swap(nums, prev, prev+1);
                if(nums[prev] >temp){
                   nums[prev+1] = nums[prev];
                    prev--;
                }else 
                    break;
            }
            nums[prev+1] = temp;
        }
        return nums;
    }
    public void swap(int[] arr, int a, int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
}