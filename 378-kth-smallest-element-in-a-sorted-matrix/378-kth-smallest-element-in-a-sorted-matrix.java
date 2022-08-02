class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                int number=matrix[i][j];
                if(maxHeap.size()<k) maxHeap.add(number);
                else{
                    if(number<maxHeap.peek()){
                        maxHeap.poll();
                        maxHeap.add(number);
                    }
                }
            }
        
        return maxHeap.peek();
    }
}