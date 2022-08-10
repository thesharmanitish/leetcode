class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(char c:s.toCharArray())
            freq[c-'a'] +=1;
        
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int n:freq){
            if(!set.contains(n))
                set.add(n);
            else{
                while(set.contains(n) && n>0){
                    count+=1;
                    n-=1;
                }
                set.add(n);
            }
        }
        return count;
    }
}