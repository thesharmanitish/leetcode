class Solution {
	    public static  int[] sortArray(int[] nums) {
            if (nums == null || nums.length == 0) return nums;
	         quickSort(nums, 0, nums.length-1);
	         return nums;   
	    }
	    public static  void quickSort(int[] nums, int start, int end) {
             int pivot = partition(nums, start, end);
             if(start< pivot-1)
	            quickSort(nums, start, pivot-1);
             if(pivot<end)
                quickSort(nums,pivot, end);
	            
	    }	    
	 	public static  int partition(int[] nums, int start, int end) {
            int i = start, j = end;
            int pivot = nums[(start + end) / 2];
            int temp;
            while(i<=j){
                while(nums[i] < pivot)
                    i++;
                while(nums[j] > pivot)
                    j--;
                if (i <= j) {
                    temp = nums[i];
                    nums[i]  = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;       
                }
            }
            return i;           
        }
}