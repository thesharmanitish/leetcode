class Solution {
    public int[] twoSum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i=0;
        for(int num:nums){
            if(map.containsKey(k-num))
                return new int[]{i, map.get(k-num)};
            map.put(num, i);
            i++;
        }
        return new int[]{-1,-1};
    }
}