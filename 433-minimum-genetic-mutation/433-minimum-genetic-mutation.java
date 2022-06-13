class Solution {
    char[] chars=new char[]{'A','C','G','T'};
    //Set containing the gene bank
    Set<String> visited = new HashSet<>();
    HashSet<String> bankSet=new HashSet<>();
    //min number of mutation
    int min;
    public int minMutation(String start, String end, String[] bank) {
        min=Integer.MAX_VALUE;
        //enter each string in the bank in the hashset
        bankSet.add(start);
        for(String str : bank) bankSet.add(str);
        backTrack(0,new StringBuilder(start),end);
        if(min==Integer.MAX_VALUE) return -1;
        return min;
    }
    
    public void backTrack(int mutationNo,StringBuilder gene,String end){
        String temp=gene.toString();
        if(visited.contains(temp)) return;
        if(!bankSet.contains(temp)) return;
        if(end.equals(temp)){
            if(mutationNo<min) min=mutationNo;
            return;
        }
        visited.add(temp);
        char ogChar;
        for(int i=0;i<8;i++){
            ogChar=gene.charAt(i);
            for(char c : chars){
                if(ogChar!=c){
                    gene.setCharAt(i,c);
                    backTrack(mutationNo+1,gene,end);
                    gene.setCharAt(i,ogChar);
                } 
            }
        }
    }
}