class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res=new ArrayList<>(n);
        char[][] temp=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                temp[i][j]='.';
        BackTrack(0,temp,new boolean[n][n],n);
        return res;
    }
    
    //Back tracking function visit each possible node once in a row
    void BackTrack(int i,char[][] grid,boolean[][] visited,int n){
        if(i==n) {
            res.add(TurnToListString(grid,n));
            return;
        }
        List<List<Integer>> points;
        for(int j=0;j<n;j++){
            if(!visited[i][j]){
                grid[i][j]='Q';
                points=mark(i,j,visited,n);
                BackTrack(i+1,grid.clone(),visited.clone(),n);
                unmark(points,visited);
                grid[i][j]='.';
            }
        }
    }
    //Get point to be marked & unmarked
    //mark 
    List<List<Integer>> mark(int x,int y,boolean[][] visited,int n)
    {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp;
        //mark the whole col
        for(int k=0;k<n;k++) {
            if(visited[k][y]==false){
                temp=new ArrayList<>();
                temp.add(k);
                temp.add(y);
                res.add(temp);
            }
            visited[k][y]= true;
        }
        int i=x;
        int j=y;
        while(i>0 && j>0 ) {
            if(visited[i-1][j-1]==false){
                temp=new ArrayList<>();
                temp.add(i-1);
                temp.add(j-1);
                res.add(temp);
            }
            visited[i-1][j-1]= true ;
            i--;
            j--;
        }
        i=x;
        j=y;
        while(i>0 && j<n-1 ) {
            if(visited[i-1][j+1]==false){
                temp=new ArrayList<>();
                temp.add(i-1);
                temp.add(j+1);
                res.add(temp);
            }
            visited[i-1][j+1] = true ;
            i--;
            j++;
        }
        i=x;
        j=y;
        while(i<n-1 && j>0 ){
            if(visited[i+1][j-1]==false){
                temp=new ArrayList<>();
                temp.add(i+1);
                temp.add(j-1);
                res.add(temp);
            }
            visited[i+1][j-1]= true;
            i++;
            j--;
        } 
        i=x;
        j=y;
        while(i<n-1 && j<n-1) {
            if(visited[i+1][j+1]==false){
                temp=new ArrayList<>();
                temp.add(i+1);
                temp.add(j+1);
                res.add(temp);
            }
            visited[i+1][j+1]=true;
            i++;
            j++;
        }
        return res;
    }
    void unmark(List<List<Integer>> points,boolean[][] visited)
    {
        //mark the whole col
        for(List temp: points){
            visited[(int)temp.get(0)][(int)temp.get(1)]=false;
        }
    }
    //Turn to List<String>
    List<String> TurnToListString(char[][] grid,int n){
        List<String> res=new ArrayList<>(n);
        StringBuilder temp;
        for(int i=0;i<n;i++){
            temp=new StringBuilder(); 
            for(int j=0;j<n;j++){
               temp.append(grid[i][j]);
            }
            res.add(temp.toString());
        }
        return res;
        
    }
    //Close Function mark all points that i can't visit
    
}