class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] visited = new boolean[128];
        int start = 0, max = 0;
        for(int end=start;end<s.length();end++){
            while(visited[s.charAt(end)]){
                visited[s.charAt(start)] = false;
                start++;
            }
            visited[s.charAt(end)] = true;
            max = Math.max(max, end-start+1);
                
        }
        return max;
    }
}