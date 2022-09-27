class WordDistance {
    Map<String,List<Integer>>  wordMap;
    public WordDistance(String[] wordsDict) {
        wordMap = new HashMap<>();
        int i=0;
        for(String word:wordsDict){
            wordMap.computeIfAbsent(word, (k)-> new ArrayList<Integer>());
            List<Integer> l = wordMap.get(word);
            l.add(i);
            wordMap.put(word, l);
            i++;
        }
        
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> loc1 = wordMap.get(word1);
        List<Integer> loc2 = wordMap.get(word2);

        int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;
        while (l1 < loc1.size() && l2 < loc2.size()) {
            minDiff = Math.min(minDiff, Math.abs(loc1.get(l1) - loc2.get(l2)));
            if (loc1.get(l1) < loc2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }

        return minDiff;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */