class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int start = 0, max = 0, n = s.length();
        
        for(int end = 0;end<n;end++){
            map.put(s.charAt(end), end);
            while(map.size()>2){
                int ind = Collections.min(map.values());
                map.remove(s.charAt(ind));
                start = ind+1;
            }
          
            max = Math.max(max, end-start+1);
        }
        return max;
    }
}