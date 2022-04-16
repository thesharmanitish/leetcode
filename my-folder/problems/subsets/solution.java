class Solution {
    
// 	public List<List<Integer>> subsets(int[] S) {
// 		List<List<Integer>>  res = new ArrayList<>();
// 		res.add(new ArrayList<>());
// 		for(int num:S) {
// 			List<List<Integer>>  t = new ArrayList<>();
// 			for(int i=0;i<res.size();i++) {
// 				List<Integer> tmp = new ArrayList<>(res.get(i));
// 				tmp.add(num);
// 				t.add(tmp);
// 			}
// 			res.addAll(t);
// 		}
// 		return res;
		
// 	}
    
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