class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }
    public void permuteHelper(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] visited) {
        if(current.size() == nums.length){
            result.add(new ArrayList(current));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(visited[i])
                continue;
            visited[i] = true;
            current.add(nums[i]);
            
            permuteHelper(nums, current, result, visited);
            
            visited[i] = false;
            current.remove(current.size()-1);            
        }
            
    }
}