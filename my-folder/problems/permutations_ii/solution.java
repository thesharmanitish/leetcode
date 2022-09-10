class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        permute(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
   Map<String, String> set = new HashMap<>();    
   public void permute(int[] nums, List<List<Integer>> res,List<Integer> suffix, int ind) {
        if(suffix.size()==nums.length){
            StringBuilder sb = new StringBuilder();
            for(Integer i:suffix)
                sb.append(i);
            // String s = suffix.stream().map(key -> key+"")
            //         .collect(Collectors.joining(", "));
            if(!set.containsKey(sb.toString())){
                set.put(sb.toString(),"1");
                res.add(suffix);
            }
            return;
        }
       int num = nums[ind];
       for(int i=0;i<=suffix.size();i++){
           List<Integer> ll = new ArrayList<>(suffix);
           ll.add(i,num);
           permute(nums, res, ll, ind+1)    ;
       }
    }
    
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         List<List<Integer>> res = new ArrayList<List<Integer>>();
//         if(nums==null || nums.length==0) return res;
//         boolean[] used = new boolean[nums.length];
//         List<Integer> list = new ArrayList<Integer>();
//         Arrays.sort(nums);
//         list.add(nums[0]);
//         res.add(list);
        
//         for(int i=1;i<nums.length;i++){  // elements
//             List<List<Integer>> tmp_res = new ArrayList<>();
//             for(int j=0;j<=i;j++){  //position
//                 int x = j;
//                 for(List<Integer> ll:res){
//                     if(nums[i] ==nums[i-1])
//                         j++; 
// 					List<Integer> new_l = new ArrayList<Integer>(ll);
                   
// 					new_l.add(j, nums[i]);
// 					tmp_res.add(new_l);                    
                                       
//                 }
//                 if(nums[i] ==nums[i-1])
//                     j=x;                
                
//             }
//             System.out.print(tmp_res);
//             res = tmp_res;
//         }
        
        
//         return res;
//     }
    
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         List<List<Integer>> res = new ArrayList<List<Integer>>();
//         if(nums==null || nums.length==0) return res;
//         boolean[] used = new boolean[nums.length];
//         List<Integer> list = new ArrayList<Integer>();
//         Arrays.sort(nums);
//         dfs(nums, used, list, res);
//         return res;
//     }

//     public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
//         if(list.size()==nums.length){
//             res.add(new ArrayList<Integer>(list));
//             return;
//         }
//         for(int i=0;i<nums.length;i++){
//             if(used[i]) continue;
//             if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
//             used[i]=true;
//             list.add(nums[i]);
//             dfs(nums,used,list,res);
//             used[i]=false;
//             list.remove(list.size()-1);
//         }
//    }
}
