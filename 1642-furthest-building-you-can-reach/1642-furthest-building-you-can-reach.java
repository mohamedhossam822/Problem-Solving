class Solution {
    HashMap<String,Integer> cache;
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n=heights.length;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(ladders+1);
        int bricksNeeded=0;
        int next,current,smallest;
        for(int i=0;i<n-1;i++){
            next=heights[i+1];
            current=heights[i];
            if(next<=current) continue;
            minHeap.add(next-current);
            if(minHeap.size()>ladders){
                smallest=minHeap.poll();
                bricksNeeded+=smallest;
                if(bricksNeeded>bricks) return i;
            }
        }
        
        return n-1;
    }
    
}