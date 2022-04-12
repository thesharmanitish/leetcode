class Solution {
    
    
        
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        permute(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
   public void permute(int[] nums, List<List<Integer>> res,List<Integer> suffix, int ind) {
        if(suffix.size()==nums.length){
            res.add(suffix);
            return;
        }
       int num = nums[ind];
       for(int i=0;i<=suffix.size();i++){
           List<Integer> ll = new ArrayList<>(suffix);
           ll.add(i,num);
           permute(nums, res, ll, ind+1)    ;
       }
    }
}