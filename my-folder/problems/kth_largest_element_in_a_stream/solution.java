class KthLargest {
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1,o2)-> {return  o1 - o2; });
    int size;
    public KthLargest(int k, int[] nums) {
            minHeap.addAll(Arrays.stream(nums).boxed()
        .collect(Collectors.toCollection(PriorityQueue::new)));
        while(minHeap.size()>k)
            minHeap.poll();
        size = k;
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size()>size){
            minHeap.poll();
        }
        return minHeap.isEmpty()?-1:minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */