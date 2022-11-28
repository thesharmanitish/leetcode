
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, Integer>[] map = new HashMap[nums.length];
        long count = 0;
        for(int i=0;i<nums.length;i++){
            map[i] = new HashMap<Integer, Integer>();

            for(int j=0;j<i;j++){
                long delta = (long)nums[i]-(long)nums[j];
                if(delta< Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }     
                int diff = (int) delta;           
                int start = map[j].getOrDefault(diff, 0);
                int end = map[i].getOrDefault(diff, 0);
                
                map[i].put(diff, end+start+1);
                count+=start;
            }
        }
        return (int)count;
    }
}