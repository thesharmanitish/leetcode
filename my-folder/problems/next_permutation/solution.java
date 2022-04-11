class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = findPeek(nums)-1;
        if(pivot!=-1){
            int x = findNextBig(nums, nums[pivot]);
            swap(nums, x, pivot)    ;
            
        }
        reverseSuffix(nums,pivot+1);
        // Arrays.stream(nums).forEach(System.out::print);
    }
    public int  findPeek(int[] nums){
        for(int i=nums.length-1;i>0;i--)
            if(nums[i-1]<nums[i])
                return i;
        return 0;
    }
     public int  findNextBig(int[] nums, int num){
         for(int i=nums.length-1;i>=0;i--)
            if(nums[i]>num)
                return i;
        return -1;
     }
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    /** Reverse numbers starting from an index till the end. */
    void reverseSuffix(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}