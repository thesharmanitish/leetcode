class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDupHelper(nums,0 , new ArrayList<>());
        return result;
    }
    public void subsetsWithDupHelper(int[] nums, int ind, List<Integer> set) {
        if(ind>nums.length)
            return;
        result.add(new ArrayList(set));

        for(int i=ind; i<nums.length;i++){
            if (i != ind && nums[i] == nums[i - 1]) {
                continue;
            }
            set.add(nums[i]);
            subsetsWithDupHelper(nums,i+1 , set);
            set.remove(set.size()-1);
        }

    }
}


// class Solution {
//     Set<List<Integer>> result = new HashSet<>();
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         Arrays.sort(nums);
//         subsetsWithDupHelper(nums,0 , new ArrayList<>());
//         return result.stream().toList();
//     }
//     public void subsetsWithDupHelper(int[] nums, int ind, List<Integer> set) {
//         if(ind>nums.length)
//             return;
//         result.add(new ArrayList(set));

//         for(int i=ind; i<nums.length;i++){
//             set.add(nums[i]);
//             subsetsWithDupHelper(nums,i+1 , set);
//             set.remove(set.size()-1);
//         }

//     }
// }



















// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         Arrays.sort(nums);
//         backtrack(nums, res, new ArrayList<>(), 0);
//         return res;
//     }
    
//      public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> ll, int ind) {
//          // if(!res.contains(ll))
//             res.add(new ArrayList<>(ll));
//          for(int i=ind;i<nums.length;i++){
             
//                          // If the current element is a duplicate, ignore.
//             if (i != ind && nums[i] == nums[i - 1]) {
//                 continue;
//             }
//              ll.add(nums[i]);
//              backtrack(nums, res, ll, i+1);
//              ll.remove(ll.size()-1);
//          }
//     }
// }