class Solution {
    HashMap<String,Integer> cache;
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n=heights.length;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(ladders+1);
        int bricksNeeded=0;
        for(int i=0;i<n-1;i++){
            if(heights[i+1]<=heights[i]) continue;
            minHeap.add(heights[i+1]-heights[i]);
            if(minHeap.size()>ladders){
                int smallest=minHeap.poll();
                bricksNeeded+=smallest;
                if(bricksNeeded>bricks) return i;
            }
        }
        
        return n-1;
    }
    
}