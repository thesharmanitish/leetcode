class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length, lbs = 0; // lbs -> longest bitomic subsequence
        int [] left = new int[n], right = new int[n]; // dp[i] -> lis end at index i, dp2[i] -> lds end at index i
        List<Integer> lis = new ArrayList<>();
        
        for(int i=0;i<n-1;i++){
            
            
            if(lis.isEmpty() || lis.get(lis.size()-1) < nums[i])
                lis.add(nums[i]);
            else{
                int ind = Collections.binarySearch(lis,nums[i]);
                if(ind<0)
                    lis.set(-ind-1, nums[i]);
            }
            left[i] = lis.size();
            
        }
        
        lis = new ArrayList<>();
        for(int i=n-1;i>=1;i--){
                                    
            if(lis.isEmpty() || lis.get(lis.size()-1) < nums[i])
                lis.add(nums[i]);
            else{
                int ind = Collections.binarySearch(lis,nums[i]);
                if(ind<0)
                    lis.set(-ind-1, nums[i]);
            }
            right[i] = lis.size();
            
            if(left[i]>1 && right[i]>1)
                lbs = Math.max(lbs, left[i]+right[i]-1);
        }

        return n-lbs;
    }
    
}