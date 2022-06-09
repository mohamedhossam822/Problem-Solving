class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int min=Integer.MAX_VALUE;
        //Dimensions
        int m=maze.length;
        int n=maze[0].length;
        //Directions
        int[][] dir = {{0, -1}, {-1, 0},{0, 1},{1, 0}};
        //Make a queue
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(entrance,0));
        //Temp point
        Pair curPoint;
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                curPoint=q.poll();
                int x=curPoint.point[0];
                int y=curPoint.point[1];
                //Check if point is exit
                if(x==0 || y==0 || x==m-1 || y==n-1){
                    if(x!=entrance[0] || y!=entrance[1]){
                        min=Math.min(min,curPoint.len);
                    }
                }
                for(int[] r : dir){
                    int i=r[0]+x;
                    int j=r[1]+y;
                    if(i<0 || j<0 || i>m-1 || j>n-1) continue;
                    if(maze[i][j]=='.') {
                        q.add(new Pair(new int[]{i,j},curPoint.len+1));
                        maze[i][j]='+';
                        
                    }
                }
                size--;
            }
        }
        if(min==Integer.MAX_VALUE) return -1;
        return min;
    }
    
    private class Pair{
        int[] point;
        int len;
        public Pair(int[] point,int len){
            this.point=point;
            this.len=len;
        }
    }
}