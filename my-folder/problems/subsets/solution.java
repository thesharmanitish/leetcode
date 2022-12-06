class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0, new ArrayList<>());
        return result;
    }
    public void subsets(int[] nums, int ind, List<Integer> list) {
        if(ind>nums.length)
            return;
        result.add(new ArrayList<>(list));
        
        for(int i=ind;i<nums.length;i++){

            list.add(nums[i]);
            subsets(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }    
}