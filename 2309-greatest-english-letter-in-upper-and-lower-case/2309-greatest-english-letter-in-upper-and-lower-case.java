class Solution {
    public String greatestLetter(String s) {
        boolean[] lwrCaseChars=new boolean[26];
        boolean[] UpCaseChars=new boolean[26];
        for(char ch: s.toCharArray()){
            if(ch < 'a') UpCaseChars[ch-'A']=true;
            else lwrCaseChars[ch-'a']=true;
        }
        for(int i=25;i>=0;i--){
            if(lwrCaseChars[i] && UpCaseChars[i]) {
                 return Character.toString((char) (i+'A'));
            }
        }
        return "";
    }
}