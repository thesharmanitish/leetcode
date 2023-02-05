class Solution {
    public int firstUniqChar(String s) {
        Boolean[] visited = new Boolean[26];
        for(char c:s.toCharArray()){
            if(visited[c-'a'] == null)
                visited[c-'a'] = true;
            else if(visited[c-'a'])
                visited[c-'a'] = false;
        }
        int i = 0;
        for(char c:s.toCharArray()){
            if(visited[c-'a'] == true)
                return i;
            i++;
        }
        return -1;
    }
}