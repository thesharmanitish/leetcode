class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] tails = new int[nums.length];
	    int size = 0;
	    for(int num:nums) {
	    	int i=0, j= size;
	    	while(i<j) {
	    		int mid = (i+j)/2;
	    		if(num>tails[mid]) {
	    			i = mid+1;
	    		}else {
	    			j= mid;
	    		}
	    	}
	    	if(i==size) size++;
	    	tails[i] = num;
	    
	    }
	    return size;
        
        // TreeSet<Integer> tset = new TreeSet<>();
        // for(int i=0;i<nums.length;i++){
        //     Integer x = tset.ceiling(nums[i]);
        //     if(x !=null){
        //         tset.remove(x);
        //     }
        //     tset.add(nums[i]);
        // }
        // return tset.size();
    }
}