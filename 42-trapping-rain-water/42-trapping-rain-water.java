class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] left=new int[n];
        left[0]=0;
        int max=height[0];
        for(int i=1;i<n;i++){
            left[i]=max;
            if(height[i]>max) max=height[i];
        }
        
        max=height[n-1];
        int sum=0;
        for(int i=n-2;i>=1;i--){
            int val=Math.min(max,left[i])-height[i];
            if(val>0) sum+=val;
            if(height[i]>max) max=height[i];
        }
        
        return sum;
    }
}