class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int value;
        int left;
        int right;
        int level=triangle.size()-1;
        List<Integer> row=new ArrayList<>(triangle.get(level));
        
        while(level>0){
            level--;
            for(int i=0;i<triangle.get(level).size();i++){
                value=triangle.get(level).get(i);
                left=row.get(i);
                right=row.get(i+1);
                row.set(i,Math.min(left,right)+value);
            }
        }
        
        return row.get(0);
        
    }
}