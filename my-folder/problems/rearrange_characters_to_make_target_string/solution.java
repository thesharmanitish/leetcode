class Solution {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int count =0;
        while(true){
            for(char c:target.toCharArray()){
                if(map.get(c)==null || map.get(c)==0)
                    return count;
                else{
                    map.put(c, map.get(c)-1);
                }
            }
            count++;
        }
    }
}