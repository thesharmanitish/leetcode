class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int n:map.values()){
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