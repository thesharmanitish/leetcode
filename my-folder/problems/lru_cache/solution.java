// class LRUCache {
//     LinkedHashMap<Integer, Integer> cache;
//     int capacity;
//     public LRUCache(int capacity) {
//         cache = new LinkedHashMap();    
//         this.capacity = capacity;
//     }
    
//     public int get(int key) {
//         Integer value = cache.get(key);
//         if(value == null)
//             return -1;
//         cache.remove(key);
//         cache.put(key, value);
//         return value;
//     }
    
//     public void put(int key, int value) {
//         cache.remove(key);
//         cache.put(key, value);
//         if(cache.size() > capacity){
//             int y = 0;
//             for(int i:cache.keySet()){
//                 y=i;
//                 break;
//             }
//             cache.remove(y);
//         }
//     }
// }

// class LRUCache {
//     LinkedHashMap<Integer, Integer> cache;
//     public LRUCache(int capacity) {
//         cache = new LinkedHashMap<>(capacity, 0.74f, true){
//             protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry){
//                 return capacity<size();
//             }
//         };
//     }
    
//     public int get(int key) {
//         return cache.getOrDefault(key, -1);
//     }
    
//     public void put(int key, int value) {
//         cache.put(key, value);
//     }
// }


class Node{
    int key;
    int value;
    Node next;
    Node prev;
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}


class LRUCache {
    Node head, tail;
    int size, capacity;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node ==null)
            return -1;
        remove(node);
        addToFront(node);
        return node.value;
    }    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node !=null)
            remove(node);
        else if(size==capacity){
            map.remove(tail.key);
            remove(tail);
        }
        addToFront(new Node(key, value));
        map.put(key, head);
    }

    public void remove(Node root) {
        if(head == null)
            return;        
        else if(head==tail){
            head = null;
            tail = null;
        }
        else if(tail == root){
            tail = tail.prev;
            tail.next = null;
            root.prev = null;
        }else if(head == root){
            head = head.next;
            head.prev = null;
            root.next = null;
        }else{
            Node prev = root.prev, next = root.next;
            prev.next = next;
            next.prev = prev;
            root.next = null;
            root.prev = null;
        }  
        size--;
    }

    public void addToFront(Node temp) {
        if(head ==null){
            head = temp;
            tail = temp;
            
        }else{
            temp.next = head;
            head.prev = temp;
            head = temp;        
        }
        size++;
        
    }

}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */