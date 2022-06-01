class MedianFinder {
    PriorityQueue<Integer> minHeap; //Heaps of thebiggerOnes
    PriorityQueue<Integer> maxHeap; //Heaps of thesmallerOnes
    int median;
    public MedianFinder() {
        minHeap= new PriorityQueue<Integer>();
        maxHeap= new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(minHeap.size()==maxHeap.size()){
            if(minHeap.size()==0) minHeap.add(num);
            else if(num>minHeap.peek()) minHeap.add(num);
            else maxHeap.add(num);
        }
        else{
            int num2;
            if(minHeap.size()>maxHeap.size()) num2=minHeap.poll();
            else  num2=maxHeap.poll();
            if(num2>num) {
                minHeap.add(num2);
                maxHeap.add(num);
            }else{
                maxHeap.add(num2);
                minHeap.add(num);
            }
        }
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()) {
            if(minHeap.size()==0) return 0;
            return ((double)(minHeap.peek()+maxHeap.peek()))/2;
        }
        else{
            if(minHeap.size()>maxHeap.size()) return minHeap.peek();
            else  return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */