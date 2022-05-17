import java.util.HashMap; 
class Solution {
    HashMap<ArrayList<Integer>, Integer> cache;
    int[][] grid;
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        cache = new HashMap<>();
        grid=new int[m][n];
        ArrayList<Integer> list=new ArrayList<>(2);
        list.add(1);
        list.add(1);
        cache.put(list,1);
        return visit(m,n);   
    }
    public int visit(int i,int j){
        if(i<0 || j<0) return 0;
        ArrayList<Integer> list=new ArrayList<>(2);
        list.add(i);
        list.add(j);
        if(cache.containsKey(list)) return cache.get(list);
        int val=visit(i-1,j)+visit(i,j-1);
        cache.put(list,val);
        return val;
    }
}