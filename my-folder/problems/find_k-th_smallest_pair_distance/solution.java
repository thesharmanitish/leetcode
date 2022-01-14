class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length-1]-nums[0];
        while (left < right) {
            int distance = (left + right) / 2, need = 1, cur = 0;
            
        int count = 0, r=1;
        for(int l=0;l<nums.length;l++){
            while(r < nums.length && nums[r]-nums[l] <= distance) r++;
                count+=r-l-1;
        }
        
            
        if (count < k) left = distance + 1;
        else right = distance;

        }
        return left;
        
    }
    

}