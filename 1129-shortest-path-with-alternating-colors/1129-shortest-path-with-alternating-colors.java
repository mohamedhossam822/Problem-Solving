class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> redDir=new ArrayList<>(n);
        List<List<Integer>> blueDir=new ArrayList<>(n);
        int[] minDistance=new int[n];
        Arrays.fill(minDistance,-1);
        
        //Create Adj lists
        for(int i=0;i<n;i++) {
            redDir.add(new ArrayList<>());
            blueDir.add(new ArrayList<>());
        }
        for(int i=0;i<redEdges.length;i++)
            redDir.get(redEdges[i][0]).add(redEdges[i][1]);
        for(int i=0;i<blueEdges.length;i++)
            blueDir.get(blueEdges[i][0]).add(blueEdges[i][1]);
        
        //Make a 2d array to know hat is visted
        // 0 red
        // 1 blue
        boolean[][] visited=new boolean[2][n];
        visited[0][0]=true;
        visited[1][0]=true;
        
        //Add 0
        Point temp=new Point(0,false,0);
        Queue<Point> q=new LinkedList<>();
        q.add(temp);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                temp=q.poll();
                //Update the min distance 
                if(minDistance[temp.value]==-1) minDistance[temp.value]=temp.len;
                else minDistance[temp.value]=Math.min(minDistance[temp.value],temp.len);
                
                //Mark the node as visited from either red or blue
                if(temp.EdgeColor) visited[0][temp.value]=true;
                else visited[1][temp.value]=true;
                
                //Visit the other nodes from the current node
                
                //if its coming from red
                //Don't explore the node if its already coming from red
                if(temp.value==0 || temp.EdgeColor){
                    for(int j: blueDir.get(temp.value)){
                        
                        if(visited[1][j]) continue;
                        q.add(new Point(j,false,temp.len+1));
                    }
                        
                }
                
                //if its coming from blue
                //Don't explore the node if its already coming from blue
                if(temp.value==0 || !temp.EdgeColor){
                    for(int j: redDir.get(temp.value)){
                        if(visited[0][j]) continue;
                        q.add(new Point(j,true,temp.len+1)); 
                    }
                        
                }
                
            }
        }
        return minDistance;
        
    }
}
public class Point{
    int value;
    //red true
    //blue false
    boolean EdgeColor;
    int len;
    public Point(int value,boolean EdgeColor,int len){
        this.value=value;
        this.EdgeColor=EdgeColor;
        this.len=len; 
    }
}