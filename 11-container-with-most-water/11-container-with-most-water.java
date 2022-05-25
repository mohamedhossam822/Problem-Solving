class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1,max=0,val=0,old;
        while(l<r){
            val=Math.min(height[l],height[r])*(r-l);
            if(val>max) max=val;
            
            if(height[l]<height[r]){
                old=height[l];
                l++;
                while(height[l]<=old)l++; 
            } 
            val=Math.min(height[l],height[r])*(r-l);
            if(val>max) max=val;
            
            if(height[l]>height[r]){
                old=height[r];
                r--;
                while(height[r]<=old) r--;
            } 
            val=Math.min(height[l],height[r])*(r-l);
            if(val>max) max=val;
            
            if(height[l]==height[r]) r--;
        }
        return max;
    }
}