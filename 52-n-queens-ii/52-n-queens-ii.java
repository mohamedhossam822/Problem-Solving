class Solution {
    HashSet<Integer> colsUsed=new HashSet<>();
    HashSet<Integer> downWardDiag=new HashSet<>(); //r-c -> j-i
    HashSet<Integer> upWardDiag=new HashSet<>(); //r+c -> j+i
    public int totalNQueens(int n) {
        return Backtrack(0,n);
    }
    
    public int Backtrack(int i,int n){
        if(i==n) return 1;
        int res=0;
        for(int j=0;j<n;j++){
            if(colsUsed.contains(j) || downWardDiag.contains(j-i) || upWardDiag.contains(j+i)) continue;
            colsUsed.add(j);
            downWardDiag.add(j-i);
            upWardDiag.add(j+i);
            res+=Backtrack(i+1,n);
            colsUsed.remove(j);
            downWardDiag.remove(j-i);
            upWardDiag.remove(j+i);
        }    
        return res;
    }
}