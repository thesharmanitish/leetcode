
class Trie{
    class Node{
        Node[] children = new Node[26];
        boolean isWord = false;
        
    } 
    Node root, curr;
    
    public Trie(){
        root = new Node();
        
    }
    
    public void insert(String s){
        curr = root;
        for(char c:s.toCharArray()){
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new Node();
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
    }
    List<String> getWordsStartingWith(String prefix) {
        curr = root;
        resultBuffer = new ArrayList<String>();
        // Move curr to the end of prefix in its trie representation.
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null)
                return resultBuffer;
            curr = curr.children[c - 'a'];
        }
        dfsWithPrefix(curr, prefix);
        return resultBuffer;
    }  
    List<String> resultBuffer;
    void dfsWithPrefix(Node curr, String word) {
        if(resultBuffer.size()==3)
            return;
        if(curr.isWord)
            resultBuffer.add(word);
        for(char c = 'a';c<='z';c++){
            if(curr.children[c-'a']!=null){
                dfsWithPrefix(curr.children[c-'a'], word+c);
            }
        }
    }    
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        // Add all words to trie.
        for (String w : products)
            trie.insert(w);
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.getWordsStartingWith(prefix));
        }
        return result;
        
        
//         List<List<String>> res = new ArrayList<>();
//         TreeMap<String, Integer> map = new TreeMap<>();
//         Arrays.sort(products);
//         List<String> productsList = Arrays.asList(products);

//         for (int i = 0; i < products.length; i++) {
//             map.put(products[i], i);
//         }

//         String key = "";

//         for(char c:searchWord.toCharArray()){
//             key += c;
//             String ceiling = map.ceilingKey(key);
//             String floor = map.floorKey(key+'{');
            
//             if(ceiling == null )
//                 break;
//             res.add(productsList.subList(map.get(ceiling),Math.min(map.get(ceiling)+3,map.get(floor)+1)));
//         }
//         while (res.size() < searchWord.length()) res.add(new ArrayList<>());

//         return res;        
    }
}