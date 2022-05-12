class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> Row=new ArrayList<Integer>();
        List<Integer> preRow;
        Row.add(1);
        result.add(Row);
        
        for(int i=1;i<numRows;i++){
            preRow=result.get(i-1);
            Row=new ArrayList<Integer>();
            
            Row.add(1);
            for(int j=1;j<i;j++){
                Row.add(j,preRow.get(j-1)+preRow.get(j));
            }
            Row.add(1);
            
            result.add(Row);
        }
        return result;
    }
}

//1=0+1
//1=0+1 2=1+2
//1=0+1 2=1+2 3=2+3