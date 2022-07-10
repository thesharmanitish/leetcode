class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    int max = 0;
    public SmallestInfiniteSet() {
         pq = new PriorityQueue<>((o1,o2)-> {return o1-o2;});
         for(int i=1;i<=10;i++)
            pq.add(i);
        max =10;
    }
    
    public int popSmallest() {
         
        int x = pq.poll();
        if(x==max){
            for(int i=1;i<=10;i++)
                if(!pq.contains(x+i) )
                    pq.add(x+i);
            max = x+10;
        }
        
        return x;
    }
    
    public void addBack(int num) {
        if(num>max)
            return;
        if(!pq.contains(num))
            pq.add(num);
    }
}

// class SmallestInfiniteSet {
//       PriorityQueue<Integer> queue;
//     int current;

//     public SmallestInfiniteSet() {
//         queue = new PriorityQueue<>();
//         current = 1;
//     }

//     public int popSmallest() {
//         int result = current;

//         if (!queue.isEmpty() && queue.peek() < current)
//             result = queue.poll();
//         else
//             current++;

//         while (!queue.isEmpty() && queue.peek() == result)
//             queue.poll();

//         return result;
//     }

//     public void addBack(int num) {
//         queue.add(num);
//     }
// }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */