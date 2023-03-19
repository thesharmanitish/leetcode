class TrieNode {
    Map<Character, TrieNode> children = new HashMap();
    boolean word = false;
    public TrieNode() {}
}

class WordDictionary {
    TrieNode trie;
    public WordDictionary() {
        trie = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode t = trie;
        for(char c: word.toCharArray()){
            t.children.computeIfAbsent(c, v-> new TrieNode());
            t = t.children.get(c);
        }
        t.word = true;
    }
    
    public boolean search(String word) {
        TrieNode t = trie;
        return searchHelper(t, word);
    }  
    public boolean searchHelper(TrieNode t, String word) {
        for(int i=0;i<word.length();i++){   
            char c = word.charAt(i);
            if(t.children.containsKey(c)){
                t = t.children.get(c);
            }else{      
                if(c == '.')        {
                    for(char ch:t.children.keySet()){
                        if(searchHelper(t.children.get(ch), word.substring(i+1)))
                            return true;
                    }
                }

                return false;  
            }
        }
        return t.word;
    }    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */