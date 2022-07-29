class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        int[] ref = getPattern(pattern); 
        List<String> result = new ArrayList<>();
        for(String word:words)
            if(Arrays.equals(getPattern(word), ref))
                result.add(word);
        
        return result;
    }
        public int[] getPattern(String pattern) {
        int[] index = new int[pattern.length()];
        TreeMap<Character, Integer> sequenceMap = new TreeMap<>();
        int i=0;    
        for(char c: pattern.toCharArray()){
            if(sequenceMap.get(c)!=null)
                index[i] = sequenceMap.get(c);
            else{
                sequenceMap.put(c, sequenceMap.size());
                index[i] =  sequenceMap.size();
            }
            i++;
        }
        return index;    
            
    }
}