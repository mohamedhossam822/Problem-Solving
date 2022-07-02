class Solution {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        PriorityQueue<Integer> pqNegative=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            if(pq.size()==3){
                if(nums[i]>pq.peek()){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
            else pq.add(nums[i]);
            
            if(pqNegative.size()==2){
                if(nums[i]<pqNegative.peek()){
                    pqNegative.poll();
                    pqNegative.add(nums[i]);
                }
            }
            else pqNegative.add(nums[i]);
        }
        int num1=pq.poll();
        int num2=pq.poll();
        int num3=pq.poll();
        return Math.max((num1*num2*num3),(num3*pqNegative.poll()*pqNegative.poll()));
    }
}