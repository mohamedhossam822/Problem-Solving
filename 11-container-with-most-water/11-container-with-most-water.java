class Solution {
    public int maxArea(int[] height) {
        
        int l=0;
        int r=height.length-1;
        int max=0;
        int maxH=0;
        
        while(l<r){
            int currHeight=Math.min(height[l],height[r]);
            if(currHeight>maxH){
                maxH=currHeight;
                int area=Math.min(height[l],height[r])*(r-l);
                if(area>max) max=area;
            }
            
            if(height[r]>=height[l]) l++;
            else r--;
        }
        return max;
        
    }
}