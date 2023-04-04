class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(char c:s.toCharArray()){
            if(set.contains(c)){
                set.clear();
                count++;        
            }
            set.add(c);
        }
        return set.isEmpty()?count:count+1;
    }
}