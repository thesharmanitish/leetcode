class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        int prev =0;
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(checkAnagram(words[prev],words[i])){
                continue;
            }
            else {
                    
                    prev = i;
                    result.add(words[prev]);
                    
                 }
        }
        return result;
    }
    public boolean checkAnagram(String word1, String word2) {
        Map<Character,Integer> map = new HashMap<>();
        if(word1.length() != word2.length())
            return false;
        
        for(char c:word1.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);
        
        for(char c: word2.toCharArray()){
            if(map.get(c)==null)
                return false;
            
            map.put(c, map.get(c)-1);
            if(map.get(c) ==0)
                map.remove(c);
        }
        if(!map.isEmpty())
            return false;
        
        return true;
        
    }
}