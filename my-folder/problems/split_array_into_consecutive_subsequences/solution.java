class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> subsequences = new HashMap<>();
        Map<Integer, Integer> frequency = new HashMap<>();
        
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums) {
            if(frequency.get(num)==0)
                continue;
            
            else if(subsequences.getOrDefault(num-1,0)>0){
                subsequences.put(num-1, subsequences.getOrDefault(num-1,0)-1);
                subsequences.put(num, subsequences.getOrDefault(num, 0) + 1);
            }
            
            else if(frequency.getOrDefault(num+1,0)>0 
                    && frequency.getOrDefault(num+2, 0)>0){
                subsequences.put(num + 2, subsequences.getOrDefault(num + 2, 0) + 1);
                frequency.put(num+1, frequency.getOrDefault(num+1,0)-1);
                frequency.put(num+2, frequency.getOrDefault(num+2, 0)-1);
            }
            else
                return false;
           frequency.put(num, frequency.get(num)-1);
        }
        return true;
    }
}