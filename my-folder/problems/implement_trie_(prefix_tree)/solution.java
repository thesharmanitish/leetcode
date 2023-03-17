class Node{
    char c;
    Node[] child;
    boolean isWord;

    public Node(char ch){
        c = ch;
        child = new Node[128];
    }
}

class Trie {
    Node root;
    public Trie() {
        root = new Node(' ');
    }
    
    public void insert(String word) {
        Node node = root;
        for(char c:word.toCharArray()){
            if(node.child[c]==null){
                node.child[c] = new Node(c);
            }
            node = node.child[c];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        Node node = find(word);
        if(node ==null  || !node.isWord)
            return false;
        return true;        
    }
    
    public boolean startsWith(String prefix) {
        Node node = find(prefix);
        if(node ==null)
            return false;
        return true;
    }
    public Node find(String word) {
        Node node = root;
        for(char c:word.toCharArray()){
            if(node.child[c]==null){
                return null;
            }
            node = node.child[c];
        }
        return node;        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */