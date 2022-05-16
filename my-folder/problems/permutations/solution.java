class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  result  = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums, used, result, new ArrayList());
        
        return result;
    }
    
    public void permuteHelper(int[] nums,boolean[] used, List<List<Integer>> result, List<Integer> current) {
        if(current.size()  == nums.length){
            result.add(new ArrayList(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])
                continue;
            current.add(nums[i]);
            used[i] = true;
            permuteHelper(nums, used, result, current);            
            used[i] = false;
            current.remove(current.size()-1);
        }
        
    }    
}