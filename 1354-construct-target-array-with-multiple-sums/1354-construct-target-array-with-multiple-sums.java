class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        int sum=0;
        if(target.length==1 && target[0]!=1) return false;
        
        //Sum of the whol array
        //Insert the array into heap
        for(int num : target){
            sum+=num;
            maxHeap.add(num);
        } 
        
        
        while(!maxHeap.isEmpty()){
            int current=maxHeap.poll();
            //Edge case
            if(sum - current == 1) return true;
            if(current==1) break;
            int newNumber=current%(sum-current);
            if(newNumber==0 || newNumber==current) return false;
            sum+=newNumber;
            sum-=current;
            if(newNumber==1) continue;
            maxHeap.add(newNumber);
        }
        return true;
    }
}