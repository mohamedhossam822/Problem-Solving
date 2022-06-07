class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=m+n-1; //Index of last element of result array
        int i=m-1; //Index of last element of first array
        int j=n-1; //Index of last element of second array
        while(k>i){
            if(i==-1 || nums2[j]>=nums1[i]  ){
                nums1[k]=nums2[j];
                k--;
                j--;
            }
            else if(j==-1 || nums2[j]<nums1[i]){
                nums1[k]=nums1[i];
                k--;
                i--;
            }
        }
    }
}