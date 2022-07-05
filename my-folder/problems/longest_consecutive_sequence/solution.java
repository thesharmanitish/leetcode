class Solution {
    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> tset = new TreeSet<>();
        for(int n:nums)
            tset.add(n);
        
        int max =0, curr = 1, prev = Integer.MIN_VALUE;
        for(int i:tset){
            if(i==prev+1)
                curr++;
            else curr = 1;
            
            prev = i;
            max = Math.max(curr, max);
                
        }
        return max;
    }
}