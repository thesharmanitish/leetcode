class Solution {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap();
        int j=0;
        for(String word:words){
            TrieNode cur = root;
            for(int i= word.length()-1;i>=0;i--)
                    cur = cur.get(word.charAt(i));
            nodes.put(cur, j);
            j++;
        }
        int ans = 0;
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0)
                ans += words[nodes.get(node)].length() + 1;
        }
        return ans;
    }
}
class TrieNode{
    TrieNode[] children;
    int count;
    public TrieNode(){
        children = new TrieNode[26];
        count = 0;
    }
    public TrieNode get(char c) {
        if (children[c-'a'] == null) {
            children[c-'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }    
}