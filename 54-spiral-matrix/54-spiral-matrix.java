class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int startCol=0,endCol=matrix[0].length;
        int startRow=0,endRow=matrix.length;
        while(startCol<endCol && startRow<endRow){
            for(int i=startCol;i<endCol;i++) res.add(matrix[startRow][i]);
            startRow++;
            endCol--;
            
            for(int i=startRow;i<endRow;i++) res.add(matrix[i][endCol]);
            endRow--;
            
            if(endRow<startRow) break;
            for(int i=endCol-1;i>=startCol;i--) res.add(matrix[endRow][i]);
            
            if(startCol>=endCol) break;
            for(int i=endRow-1;i>=startRow;i--) res.add(matrix[i][startCol]);
            startCol++;
        }
        return res;
    }
}