class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int i=0, min = Integer.MAX_VALUE, cur = 0;
        Integer end = null, start = null;
        if(word1.equals(word2)){
            for(String word:wordsDict){
                if(word.equals(word1)){
                    if(start!=null){
                        min = Math.min(min, cur-start);
                    }
                    start = cur;
                    
                }
                cur++;
            }
            return min;
        }
            
        for(String word:wordsDict){
            if(word.equals(word1))
                start = i;
            else if(word.equals(word2))
                end = i;
            if(start!=null && end !=null)
                min = Math.min(min, Math.abs(end-start));
            
            i++;
        }
        return min;        
    }
}