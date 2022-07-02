class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long  maxH=horizontalCuts[0];
        long  maxW=verticalCuts[0];
        for(int i=0;i<horizontalCuts.length;i++){
            int nextH;
            if((i+1)>=horizontalCuts.length) nextH=h;
            else nextH=horizontalCuts[i+1];
            nextH=nextH-horizontalCuts[i];
            if(nextH>maxH) maxH=nextH;
        }
        
        for(int i=0;i<verticalCuts.length;i++){
            int nextW;
            if(i+1>=verticalCuts.length) nextW=w;
            else nextW=verticalCuts[i+1];
            nextW=nextW-verticalCuts[i];
            if(nextW>maxW) maxW=nextW;
        }
        
        return(int)((maxH * maxW) % 1000000007);
    }
}