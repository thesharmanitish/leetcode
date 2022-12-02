class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length())
            return false;
        if (s.equals(goal)) {
            Set<Character> set = new HashSet<Character>();
            for (char c : s.toCharArray()) set.add(c);
            return set.size() < s.length();
        }        
        int[] freq = new int[26];
        int count = 0;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            freq[goal.charAt(i)-'a']--;
            if(s.charAt(i) != goal.charAt(i))
                count++;
            if(count>2)
                return false;            
        }
        for(int a:freq)
            if(a!=0)    
                return false;
        return true;

    }
}