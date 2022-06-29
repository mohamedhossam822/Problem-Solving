class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n=people.length;
        
        Arrays.sort(people, (a, b) ->{
            if(a[0]==b[0]) return a[1]<=b[1] ? -1:1;
            return a[0]-b[0];
        });
        
        
        int[][] res=new int[n][2];
        
        for(int i=0;i<n;i++) res[i][0]=-1;
        
        
        for(int i=0;i<n;i++){
            
            int leftCount=people[i][1];
            
            int j=0;
            while(res[j][0]!=-1 || leftCount>0){
                if(res[j][0]==-1 || res[j][0]>=people[i][0]) 
                    leftCount--;
                j++;
            }
            
            res[j][0]=people[i][0];
            res[j][1]=people[i][1];
        }
            
        return res;
    }
}