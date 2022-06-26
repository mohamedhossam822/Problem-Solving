class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int max1Add=0;
        int max2Add=0;
        int sum1Add=0;
        int sum2Add=0;
        int sum1=0;
        int sum2=0;
        for(int i=0;i<nums1.length;i++){
            sum1+=nums1[i];
            sum2+=nums2[i];
            int diff=nums2[i]-nums1[i];
            //nums
            if(sum1Add+diff>=0){
                sum1Add+=diff;
                if(sum1Add>max1Add) max1Add=sum1Add;
            } else sum1Add=0;
            
            diff=nums1[i]-nums2[i];
            if(sum2Add+diff>=0){
                sum2Add+=diff;
                if(sum2Add>max2Add) max2Add=sum2Add;
            }else sum2Add=0;
        }
        
        return Math.max((sum1+max1Add),(sum2+max2Add));
    }
}