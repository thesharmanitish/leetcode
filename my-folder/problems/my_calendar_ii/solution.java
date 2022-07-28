class MyCalendarTwo {
    Node root;
    
    public MyCalendarTwo() {
        root = new Node(0, 1_000_000_000);
    }
    
    public boolean book(int start, int end) {
        if(isTriple(root, start, end - 1)) return false;
        insert(root, start, end - 1);
        return true;
    }
    
    private boolean isTriple(Node root, int left, int right) {
        if(root == null || root.left > right || root.right < left) return false;
        if(root.lazy > 0) {
            root.overlap += root.lazy;
            if(root.left < root.right) {
                root.lch().lazy += root.lazy;
                root.rch().lazy += root.lazy;
            }
            root.lazy = 0;
        }
        if(left <= root.left && root.right <= right) return root.overlap > 1;
        int mid = root.mid();
        if(mid >= right) return isTriple(root.lch, left, right);
        else if(mid < left) return isTriple(root.rch, left, right);
        else return isTriple(root.lch, left, mid) || isTriple(root.rch, mid + 1, right);
    }
    
    private void insert(Node root, int left, int right) {
        if(root.lazy > 0) {
            root.overlap += root.lazy;
            if(root.left < root.right) {
                root.lch().lazy += root.lazy;
                root.rch().lazy += root.lazy;
            }
            root.lazy = 0;
        }
        if(left <= root.left && root.right <= right) {
            root.overlap++;
            if(root.left < root.right) {
                root.lch().lazy++;
                root.rch().lazy++;
            }
            return;
        }
        int mid = root.mid();
        if(mid >= right) insert(root.lch(), left, right);
        else if(mid < left) insert(root.rch(), left, right);
        else {
            insert(root.lch(), left, mid);
            insert(root.rch(), mid + 1, right);
        }
        root.overlap = Math.max(root.lch().overlap, root.rch().overlap);
    }
    
    class Node {
        int left;
        int right;
        int overlap;
        int lazy;
        Node lch, rch;
        
        public Node(int l, int r) {
            this.left = l;
            this.right = r;
        }
        
        public int mid() {
            return left + (right - left) / 2;
        }
        
        public Node lch() {
            if(lch == null) lch = new Node(left, mid());
            return lch;
        }
        
        public Node rch() {
            if(rch == null) rch = new Node(mid() + 1, right);
            return rch;
        }
    }
}

// class MyCalendarTwo {
//     TreeMap<Integer, Integer> calendar;
//     public MyCalendarTwo() {
//         calendar = new TreeMap<>();
//     }
    
//     public boolean book(int start, int end) {
//         calendar.put(start, calendar.getOrDefault(start, 0)+1);
//         calendar.put(end, calendar.getOrDefault(end, 0)-1);
        
//         int count = 0;
//         for(Map.Entry<Integer, Integer> entry:calendar.entrySet()){
//             count += entry.getValue();
//             if(count>2){
//                 calendar.put(start, calendar.get(start)-1);
//                 calendar.put(end, calendar.get(end)+1);
//                 if(calendar.get(start)==0)
//                     calendar.remove(start);
//                 return false;
//             }
//         }
//         return true;
//     }
// }

// /**
//  * Your MyCalendarTwo object will be instantiated and called as such:
//  * MyCalendarTwo obj = new MyCalendarTwo();
//  * boolean param_1 = obj.book(start,end);
//  */