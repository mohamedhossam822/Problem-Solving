import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(n, Collections.reverseOrder());
        for(int i=0;i<n;i++) queue.add(nums[i]);
        int val=0;
        for(int i=0;i<k;i++) val=queue.poll();
        return val;
        
    }
}