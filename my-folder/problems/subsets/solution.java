class Solution {
    // public List<List<Integer>> subsets(int[] nums) {
    //     result = new ArrayList<>();
    //     result.add(new ArrayList<>());
    //     for(int i=0;i<nums.length;i++)
    //         subsetsHelper(nums, i, new ArrayList<>(), new boolean[nums.length]);
    //     return result;
    // }
    // List<List<Integer>> result;
    // public void subsetsHelper(int[] nums, int ind, List<Integer> list, boolean[] visited) {
    //     if(ind == nums.length || visited[ind])
    //         return;
    //     visited[ind] = true;
    //     list.add(nums[ind]);
    //     result.add(new ArrayList<Integer>(list));
    //     for(int i=ind;i<nums.length;i++)
    //         subsetsHelper(nums, i, list, visited);
    //     list.remove(list.size()-1);
    //     visited[ind] = false;
    // }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // Arrays.sort(nums);
        backtrack(nums, res, new ArrayList<>(), 0);
        return res;
    }
    
     public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> ll, int ind) {
         res.add(new ArrayList<>(ll));
         for(int i=ind;i<nums.length;i++){
             ll.add(nums[i]);
             backtrack(nums, res, ll, i+1);
             ll.remove(ll.size()-1);
         }
    }
}