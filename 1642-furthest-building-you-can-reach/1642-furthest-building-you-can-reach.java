class Solution {
    HashMap<String,Integer> cache;
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(ladders+1);
        int bricksNeeded=0;
        for(int i=1;i<heights.length;i++){
            if(heights[i]<=heights[i-1]) continue;
            minHeap.add(heights[i]-heights[i-1]);
            if(minHeap.size()>ladders){
                int smallest=minHeap.poll();
                bricksNeeded+=smallest;
                if(bricksNeeded>bricks) return i-1;
            }
        }
        
        return heights.length-1;
    }
    
}