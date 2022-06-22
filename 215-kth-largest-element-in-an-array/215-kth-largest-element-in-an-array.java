class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k);
        for(int num : nums){
            if(minHeap.size()==k){
                if(num<minHeap.peek()) continue;
                minHeap.add(num);
                minHeap.poll();
            }
            else minHeap.add(num);
        }
        return minHeap.peek();
        
    }
}