class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] =  nums[j];
        nums[j] = temp;
    }
    public int missingNumber(int[] nums) {
        int i=0;
        int n = nums.length;
        while(i<n)
        {
			int correctIdx = nums[i]; //where this element should be in sorted array
            if(correctIdx<n && correctIdx != i) //if not already at correct position and correct position < n
            {
                swap(nums, i,correctIdx); //put current element at correct position
            } 
			else
				i++; // move to next index
        }
        for(i=0;i<n; i++)
            if(nums[i]!=i)
                return i;
        return n;
        
    }
}