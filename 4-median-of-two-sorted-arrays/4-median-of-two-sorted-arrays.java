class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;
        int val=0,pre=0,index1=0,index2=0;
        int target=n/2;
        int res=0;
        
        
        
        for(int i=0;i<n;i++){
            if(index1==nums1.length){
                val=nums2[index2];
                index2++; 
            }
            else if(index2==nums2.length || nums1[index1]<=nums2[index2]){
                val=nums1[index1];
                index1++;
            }else{
                val=nums2[index2];
                index2++;
            }
            if(i==target) break;
            pre=val;
        }
        if(n%2==0) return ((double)(val+pre))/2;
        return val;
    }
}