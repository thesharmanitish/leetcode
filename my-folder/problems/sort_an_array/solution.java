class Solution {
	    public static  int[] sortArray(int[] nums) {
            if (nums == null || nums.length == 0) return nums;
	         quickSort(nums, 0, nums.length-1);
	         return nums;   
	    }
	    public static  void quickSort(int[] nums, int start, int end) {
            int pivot = partition(nums, start , end);
            
            if(start< pivot-1)
                quickSort(nums, start, pivot-1);
            if(end> pivot)
                quickSort(nums, pivot, end);
	            
	    }	    
	 	public static  int partition(int[] nums, int start, int end) {
            int pivot = nums[(end+start)/2];
            
            while(start<=end){
                while(nums[start]<pivot)
                    start++;
                while(nums[end]>pivot)
                    end--;
                if(start<=end){
                    swap(nums, start++, end--);
                    
                }
            }
            return start;
        }
    
	    public static  void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
	    }    
}