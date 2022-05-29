class Solution {
    public int maxProduct(String[] words) {
        int max=0,val;
        int[][] chars=new int[words.length][26];
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                chars[i][words[i].charAt(j)-'a']++;
            }
        }
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if(isValid(i,j,chars)){
                    val=words[i].length()*words[j].length();
                    if(val>max) {
                        max=val;
                    }
                }
            }
        }
        
        return max;
    }
    
    private boolean isValid(int i,int j,int[][] chars){
        for(int k=0;k<26;k++){
            if(chars[i][k]!=0 && chars[j][k]!=0) return false;
        }
        return true;
    }
}