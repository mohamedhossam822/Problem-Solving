import java.util.Hashtable;
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] l=new int[n];
        int[] r=new int[n];
        int tallest=0;
        int sum=0;
        int i;
        
        for(i=0;i<n;i++){
             if(height[i]>tallest){
                 tallest=height[i];
             }    
            l[i]=tallest;
        }
        
        tallest=0;
        for(i=n-1;i>=0;i--){
             if(height[i]>tallest){
                 tallest=height[i];
             }    
            r[i]=tallest;
        }
        
        for(i=0;i<height.length;i++){
           sum=sum+Math.min(l[i],r[i])-height[i]; 
        }
        return sum;
    }
}
