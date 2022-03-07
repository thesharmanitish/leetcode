class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
       int[] res = new int[nums.length] ;
        int j=0, k= nums.length-1;
       for(int i=0;i<nums.length;i++) {
           if(nums[i]<pivot)
               res[j++] = nums[i];
       }
       for(int i=nums.length-1;i>=0;i--) {
           if(nums[i]>pivot){
               res[k--] = nums[i];
           }
       }
        for(int i=j;i<=k;i++)
            res[i] = pivot;
    return res;
    }
}