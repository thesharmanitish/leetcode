class MedianFinder {
    PriorityQueue<Double> minHeap;
    PriorityQueue<Double> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        minHeap.add((double)num);
        maxHeap.add(minHeap.poll());
        if(minHeap.size()<maxHeap.size())
            minHeap.add(maxHeap.poll());
    }
    
    public double findMedian() {
        if(minHeap.size()== maxHeap.size())
            return (minHeap.peek() + maxHeap.peek())/2;
        else
            return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */