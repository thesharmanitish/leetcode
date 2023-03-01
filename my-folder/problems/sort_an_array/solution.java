class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length<2) 
            return nums;
        // quickSort(nums, 0, nums.length-1);
        partition1(nums, 0, nums.length-1);
        return nums;
    }
    public void partition1(int[] nums, int start, int end) {
        if(start>=end)
            return;
        int mid = start + (end-start)/2;

        partition1(nums, start, mid);
        partition1(nums, mid+1, end);

        merge(nums, start, end);
    }
    public void merge(int[] nums, int start,  int end) {
        
        int mid = start + ((end-start)>>1);
        int start2 = mid + 1, k = 0;
        int[] tmp = new int[end - start + 1];
        int i = start, j = end;


        while(start <=mid && start2<=end){
            if(nums[start]>nums[start2]){
                tmp[k++] = nums[start2++];
            }else 
                tmp[k++] = nums[start++];
        }

        while(start<=mid)
            tmp[k++] = nums[start++];
        while(start2<=end)
            tmp[k++] = nums[start2++];

        System.arraycopy(tmp, 0, nums, i, j - i + 1);


    }
    public void quickSort(int[] nums, int start, int end) {
        if(start >=end)
            return;
        
        int partition = partition(nums, start, end);

        if(start< partition-1)
            quickSort(nums, start, partition-1);
        if(end > partition)
           quickSort(nums, partition, end);
    }    
    public int partition(int[] nums, int start, int end) {
        int pivot = nums[(start+end)/2];
        while(start<=end){
            
            while(nums[start]<pivot)
                start++;

            while(nums[end]>pivot)
                end--;

            if(start<=end)
                swap(nums, start++, end--);
        }
        return start;

    }
    public void swap(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

}