class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength=matrix.length;
        if(rowLength==0) return false;
        int colLength=matrix[0].length;
        int mid=0;
        for(int i=0;i<rowLength;i++){
            int l=0;
            int r=colLength-1;
            //If first element of row is bigger than target then target doesn't exist
            if(matrix[i][0]>target) return false;
            //If last element of row is smaller than row doesn't have target -> skip row
            if(matrix[i][colLength-1]>=target){
                while(l<=r){
                mid=l+(r-l)/2;
                if(matrix[i][mid]==target) return true;
                else if(matrix[i][mid]>target) r=mid-1;
                else l=mid+1;
            }
            } 
            
        }
        return false;
    }
}