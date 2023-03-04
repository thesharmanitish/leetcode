class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;

        int maxInd = -1, minInd = -1, startInd = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<minK || nums[i]> maxK){
                maxInd = -1; minInd = -1; startInd = i+1;
                continue;
            }
            if(maxK == nums[i]) maxInd = i;
            if(minK == nums[i]) minInd = i;

            if(minInd == -1 || minInd == -1 || startInd >maxInd || startInd > minInd)
                continue;
            
            count += Math.min(maxInd, minInd) - startInd +1;

        }
        return count;
    }
}