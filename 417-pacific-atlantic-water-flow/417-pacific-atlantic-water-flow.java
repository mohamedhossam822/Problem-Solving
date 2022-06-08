class Solution {
    int m,n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m=heights.length;
        n=heights[0].length;
        List<List<Integer>> res=new ArrayList<>();
        boolean[][] isPacific=new boolean[m][n];
        boolean[][] isAtlantic=new boolean[m][n];
        for(int i=0;i<m;i++){
            dfs(i,0,heights,-1,isPacific);
        }
        for(int j=1;j<n;j++){
            dfs(0,j,heights,-1,isPacific);
        }
        for(int i=0;i<m;i++){
            dfs(i,n-1,heights,-1,isAtlantic);
        }
        for(int j=0;j<n-1;j++){
            dfs(m-1,j,heights,-1,isAtlantic);
        }

        List<Integer> temp;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(isPacific[i][j] && isAtlantic[i][j]){
                    temp=new ArrayList<>(2);
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
        return res;
    }
    public void dfs(int i,int j,int[][] heights,int preVal,boolean[][] isTrue){
        if(i<0 || j<0 || i>m-1 || j>n-1) return;
        if(isTrue[i][j]) return;
        if(heights[i][j]<preVal) return;
        isTrue[i][j]=true;
        dfs(i,j-1,heights,heights[i][j],isTrue);
        dfs(i-1,j,heights,heights[i][j],isTrue);
        dfs(i,j+1,heights,heights[i][j],isTrue);
        dfs(i+1,j,heights,heights[i][j],isTrue);
    }
}