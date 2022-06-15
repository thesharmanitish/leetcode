class Solution {
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, (o1,o2) -> o1.length()- o2.length());
        
        Map<String,Integer> map = new HashMap<>();
        int res = 0;
        for(String word:words){
            int count =0;
            for(int i=0;i<word.length();i++){
                String prev = word.substring(0,i)+word.substring(i+1);
                count =Math.max(count, map.getOrDefault(prev,0)+1);
            }
            map.put(word,count);
            res = Math.max(res, count);
        }
        
        return res;
        
        
    }
}