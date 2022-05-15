class Solution {
    public int largestCombination(int[] candidates) {
        int max = 0, cur;
        for(int i=0;i<32;i++){
            cur = 0;
            for(int j=0;j<candidates.length;j++){
                if((candidates[j] & (1<<i)) !=0)
                    cur+=1;
                
            }
            max = Math.max(cur, max);
            
            
        }
        return max;
    }
}