class Solution {
    Set<String> wordSet;
    int length =  Integer.MAX_VALUE;
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        wordSet = new HashSet<>();
        for(String word:words){
            wordSet.add(word);
            length = Math.min(word.length(), length);
        }
        ArrayList<String> result = new ArrayList<>();
        for(String word:words){
            if(word.length()== length)
                continue;
            if(checkPrefixInADict(word, false))
                result.add(word);
        }
        return result;
    }
    public boolean  checkPrefixInADict(String word, boolean flag) {
        if(wordSet.contains(word) && flag)
            return true;
        for(int i=length-1;i<word.length()-length;i++){
            if(wordSet.contains(word.substring(0,i+1)))
                if(wordSet.contains(word.substring(i+1))  || checkPrefixInADict(word.substring(i+1), true))
                    return true;
        }
        return false;
    }
}