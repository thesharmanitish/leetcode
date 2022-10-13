class Solution {
    public int lengthOfLIS(int[] nums) {
//         int[] dp = new int[nums.length];
        
//         Arrays.fill(dp,1);
//         int max = dp[0];
        
//         for(int i=1;i<nums.length;i++){
//             for(int j=0;j<i;j++){
//                 if(nums[i]>nums[j])
//                     dp[i] = Math.max(dp[i], dp[j]+1);
//             }
//             max = Math.max(max, dp[i]);
//         }
//         return max;
        
        
//         int[] tails = new int[nums.length];
// 	    int size = 0;
// 	    for(int num:nums) {
// 	    	int i=0, j= size;
// 	    	while(i<j) {
// 	    		int mid = (i+j)/2;
// 	    		if(num>tails[mid]) {
// 	    			i = mid+1;
// 	    		}else {
// 	    			j= mid;
// 	    		}
// 	    	}
// 	    	if(i==size) size++;
// 	    	tails[i] = num;
	    
// 	    }
// 	    return size;
        
        TreeSet<Integer> set = new TreeSet<>();
        for(int num:nums){
            Integer x = set.ceiling(num);
            if(x!=null)
                set.remove(x);
            set.add(num);
        }
        return set.size();
    }
}