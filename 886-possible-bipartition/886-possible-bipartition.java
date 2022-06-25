class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> peopleDislike=new ArrayList<>(n);
        for(int i=0;i<n+1;i++) peopleDislike.add(new ArrayList<>());
        for(int i=0;i<dislikes.length;i++){
            peopleDislike.get(dislikes[i][0]).add(dislikes[i][1]);
            peopleDislike.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        
        int[] color=new int[n+1];
        
        for(int i=1;i<n+1;i++){
            if(color[i]!=0) continue;
            if(!dfs(0,i,color,peopleDislike)) return false;
        }
        return true;
    }
    
    public boolean dfs(int preColor,int index,int[] color,List<List<Integer>> peopleDislike){
        if(color[index]!=0){
            if(preColor==color[index]) return false;
            return true;
        }
        boolean res=true;
        int newColor= preColor==1 ? 2 : 1;
        color[index]=newColor;
        for(int i=0;i<peopleDislike.get(index).size();i++){
            res&=dfs(newColor,peopleDislike.get(index).get(i),color,peopleDislike);
        }
            
        return res;
    }
    
}