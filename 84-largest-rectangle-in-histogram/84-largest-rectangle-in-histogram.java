class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Col> stack=new Stack<>();
        int max=0;
        
        //Going from left to right
        for(int i=0;i<heights.length;i++){
            
            if(heights[i]>max) max=heights[i];
            
            Col current=new Col(heights[i],i);
            
            //popping ever element that is bigger than the current col
            while(!stack.empty() && stack.peek().height>=heights[i]){
                Col old=(Col) stack.pop();
                int height=old.height*(i-old.index);
                if(height>max) max=height;
                current.index=old.index;
            }
            stack.push(current);
        }
        int index=heights.length;
        while(!stack.empty()){
            Col old=(Col) stack.pop();
            int height=old.height*(index-old.index);
            if(height>max) max=height;
        }
        
        return max;
    }
    
    private class Col{
        int height;
        int index;
        public Col(int height, int index){
            this.height=height;
            this.index=index;
        }
        
    }
}