class Solution {
    
    /**************************************************************************
    A class for each point where len is the actual distance we travelled
    Distance is the theortical distance - manhatan distance (exit - entrance)
    When we continue exploring other points we will add the value of length 
    to the theortical distance
    **************************************************************************/
    class Pair implements Comparable<Pair>{
        int[] point;
        int len;
        int distance;
        Pair(int[] point,int len,int distance){
            this.point=point;
            this.len=len;
            this.distance=distance;
        }
        public int compareTo(Pair o){
            return this.distance - o.distance;
        }
    }
    
    
    public int nearestExit(char[][] maze, int[] entrance) {
        int min=Integer.MAX_VALUE;
        
        //Dimensions
        int m=maze.length;
        int n=maze[0].length;
        int distance;
        
        //Directions
        int[][] dir = {{0, -1}, {-1, 0},{0, 1},{1, 0}};
        
        //Min heap that will be constructed Using the theortical distance
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        
        
        //Add the exits to our priorty queue with the theortical distance
        for(int i=0;i<m;i++){
           if(maze[i][0]=='.'&& (entrance[0]!=i || entrance[1]!=0)){
               distance=Math.abs(i-entrance[0])+Math.abs(0-entrance[1]);
               pq.add(new Pair(new int[]{i,0},0,distance));
           }
            if(maze[i][n-1]=='.' && (entrance[0]!=i || entrance[1]!=n-1)){
                distance=Math.abs(i-entrance[0])+Math.abs((n-1)-entrance[1]);
                pq.add(new Pair(new int[]{i,n-1},0,distance));
           }
        }
        for(int j=1;j<n-1;j++){
            if(maze[0][j]=='.' && (entrance[0]!=0 || entrance[1]!=j)){
               distance=Math.abs(0-entrance[0])+Math.abs(j-entrance[1]);
               pq.add(new Pair(new int[]{0,j},0,distance)); 
            }
            if(maze[m-1][j]=='.' && (entrance[0]!=m-1 || entrance[1]!=j)){
                distance=Math.abs((m-1)-entrance[0])+Math.abs(j-entrance[1]);
                pq.add(new Pair(new int[]{m-1,j},0,distance));
                
            }
        }
        
        
        //Start exploring the exits starting from the one with the least theortical Distance
        Pair curPoint;
        while(!pq.isEmpty()){
            curPoint=pq.poll();
            int x=curPoint.point[0];
            int y=curPoint.point[1];
            //If the point we are exploring is the entrance then we found the minimum path 
            //Since other points will have higher distance anyway
            if(x==entrance[0] && y==entrance[1]) return curPoint.len;
            
            //Explore the 4 other directions 
            for(int[] r : dir){
                int i=r[0]+x;
                int j=r[1]+y;
                if(i<0 || j<0 || i>m-1 || j>n-1) continue;
                if(maze[i][j]=='.') {
                    distance=Math.abs(i-entrance[0])+Math.abs(j-entrance[1]);
                    pq.add(new Pair(new int[]{i,j},curPoint.len+1,curPoint.len+1+distance)); 
                    maze[i][j]='+';
                }
            }
        }
        
        return -1;
    }
}