class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxVal = 0, max=-1;
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            if((num&1)==0){
                if(maxVal < map.get(num) || (maxVal == map.get(num)  && max > num)){
                    maxVal = map.get(num);
                    max = num;
                }
            }
        }
        return max;
    }
}