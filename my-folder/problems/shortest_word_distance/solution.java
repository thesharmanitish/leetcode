class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i=0, min = Integer.MAX_VALUE;
        Integer end = null, start = null;
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