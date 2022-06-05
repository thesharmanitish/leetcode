class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer> map = new HashMap<>();
        int i=0;
        for(int num:nums){
            map.put(num, i++);
        }
        for(int[] o:operations){
            int v = map.get(o[0]);
            map.remove(o[0]);
            map.put(o[1],v);
        }
        int[] res = new int[nums.length];
        for(Map.Entry<Integer, Integer> m:map.entrySet()){
            res[m.getValue()] = m.getKey();
        }
        return res;
    }
}