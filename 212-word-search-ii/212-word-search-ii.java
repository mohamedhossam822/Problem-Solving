class Solution {
    HashSet<String> res=new HashSet<>();
    int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int n,m;
    public List<String> findWords(char[][] board, String[] words) {
        
        Trie WordMap=new Trie();
        for(String word : words) WordMap.insert(word);
        m=board.length;
        n=board[0].length;
        boolean[][] visited=new boolean[m][n];
        StringBuilder str=new StringBuilder();
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(!WordMap.trie.containsKey(board[i][j])) continue;
                visited[i][j]=true;
                str.append(board[i][j]);
                dfs(i,j,str,board,visited,WordMap.trie.get(board[i][j]));
                visited[i][j]=false;
                str.deleteCharAt(0);
            }
        
        return new ArrayList<String>(res);
    }
    
    private void dfs(int i, int j,StringBuilder str,char[][] board,boolean[][] visited,Trie WordMap){
        if(WordMap.isWord) res.add(new String(str.toString()));
        
        for(int[] dim : dir){
            int x=i+dim[0];
            int y=j+dim[1];
            if(x<0 || y<0 || x>=m || y>=n) continue;
            if(visited[x][y]) continue;
            if(!WordMap.trie.containsKey(board[x][y])) continue;
            visited[x][y]=true;
            str.append(board[x][y]);
            dfs(x,y,str,board,visited,WordMap.trie.get(board[x][y]));
            visited[x][y]=false;
            str.deleteCharAt(str.length() - 1);
        }
        
    }
    
}

class Trie {
    HashMap<Character,Trie> trie;
    boolean isWord;
    public Trie() {
        trie=new HashMap<>();
        isWord=false;
    }
    
    public void insert(String word) {
        Trie root=this;
        for(char ch: word.toCharArray()){
            if(!root.trie.containsKey(ch))root.trie.put(ch,new Trie());
             root=root.trie.get(ch);
        }
        root.isWord=true;
    }
}