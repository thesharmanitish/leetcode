class Solution {
    public int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> set = new HashMap<>();
        int[] res = new int[2];
        int i=0;
        for(int num:nums){
            if(set.containsKey(target-num)){
                res[1] = i;
                res[0] = set.get(target-num);
                return res;
            }
            set.put(num, i++);
        }
        return res;
    }
}