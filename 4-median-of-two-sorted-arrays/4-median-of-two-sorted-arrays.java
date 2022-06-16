class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;
        int val,index1=0,index2=0;
        int target,target2=0;
        int res=0;
        
        if(n%2==0){
            target=n/2 -1;
            target2=n/2;
        }else target=n/2;
        
        
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
            
            if(n%2==0){
                if(i==target) res+=val;
                else if(i==target2) return ((double)(res+val))/2;
            }else if(i==target) return (double)val;
        }
        return -1;
    }
}