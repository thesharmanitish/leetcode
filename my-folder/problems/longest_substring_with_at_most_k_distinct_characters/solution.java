class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        
        int start = 0, max = 0, n = s.length();
        
        for(int end = 0;end<n;end++){
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);
            while(map.size()>k){
                    map.put(s.charAt(start),map.getOrDefault(s.charAt(start),0)-1);
                    if(map.get(s.charAt(start))==0){        
                       map.remove(s.charAt(start));
                    }
                    start++;
            }
          
            max = Math.max(max, end-start+1);
        }
        return max;        
    }
}