class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        result = new HashSet<>();
        findSubsequences(nums, 0, new ArrayList(), Integer.MIN_VALUE);

        return result.stream().toList();
    }
    Set<List<Integer>> result;
    public void findSubsequences(int[] nums, int ind, List<Integer> list, int prev) {
        if(list.size()>1){
            result.add(new ArrayList<>(list));
        }
        
        for(int i=ind; i<nums.length;i++){
            if(prev>nums[i])
                continue;
            list.add(nums[i]);
            findSubsequences(nums, i+1, list, nums[i]);
            list.remove(list.size()-1);
        }


    }    
}