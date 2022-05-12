class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        permuteUnique(nums, used, result,new ArrayList<>());
        return result;
    }
    
    public void permuteUnique(int[] nums, boolean[] used , List<List<Integer>> result, List<Integer> current) {
        if(current.size() ==nums.length){
            result.add(new ArrayList<Integer>(current));
            return ;
        }
        
        for(int ind=0;ind<nums.length;ind++){
            if(used[ind])
                continue;
            if(ind>0 && nums[ind] == nums[ind-1] && !used[ind-1])
                continue;
            used[ind] = true;
            current.add(nums[ind]);
            permuteUnique(nums, used, result,current);
            used[ind] = false;
            current.remove(current.size()-1);
        }
    }    
}