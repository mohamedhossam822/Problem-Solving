class Solution {
    int oldColor;
    int[][] imageVisited;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        oldColor=image[sr][sc];
        imageVisited= new int[image.length][image[sr].length];
        
        if(sr<0 || sr>image.length-1 || sc<0 || sc>image[sr].length-1) return image;
        if(image[sr][sc]==oldColor && imageVisited[sr][sc]==0){
            imageVisited[sr][sc]=1;
            image[sr][sc]=newColor;
            fill(image,sr,sc-1,newColor);
            fill(image,sr,sc+1,newColor);
            fill(image,sr-1,sc,newColor);
            fill(image,sr+1,sc,newColor);
        }
        return image;
    }
    private void fill(int[][] image, int sr, int sc, int newColor){
        if(sr<0 || sr>image.length-1 || sc<0 || sc>image[sr].length-1) return;
        if(image[sr][sc]==oldColor && imageVisited[sr][sc]==0){
            imageVisited[sr][sc]=1;
            image[sr][sc]=newColor;
            fill(image,sr,sc-1,newColor);
            fill(image,sr,sc+1,newColor);
            fill(image,sr-1,sc,newColor);
            fill(image,sr+1,sc,newColor);
        }
    }
}