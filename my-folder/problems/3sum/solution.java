class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if(nums.length<3)
            return new ArrayList<>(res);
        
        Arrays.sort(nums);
        if( nums[0]>0)
            return new ArrayList<>(res);
        
        for(int i=0;i<nums.length-2 && nums[i]<=0;i++){
            int j=i+1, k= nums.length-1;
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            while(j<k){
                int sum = nums[i]+nums[j] + nums[k];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                    while(j<k && nums[j]==nums[j-1])
                        j++;
                }else if(sum<0)
                    j++;
                else 
                    k--;
            }
        }
        return new ArrayList<>(res);
    }
}