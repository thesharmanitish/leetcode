class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b)-> {return b-a;});
        minHeap = new PriorityQueue<>((a,b)-> {return a-b;});
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        
        minHeap.add(maxHeap.poll());
        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        return maxHeap.size()>minHeap.size() ? maxHeap.peek():((double) maxHeap.peek()+minHeap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */