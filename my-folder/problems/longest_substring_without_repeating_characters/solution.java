class Solution {
    public int lengthOfLongestSubstring(String s) {
        Deque<Character> set =new LinkedList<>();
        int max= 0;
        for(char c:s.toCharArray()){
            if(set.contains(c)){
                max=Math.max(max, set.size());
                while(set.pop()!= c);
                    
                }
            set.add(c);
                
        }
        return Math.max(max, set.size());
    }
}