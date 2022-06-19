class Solution {
    public int longestSubsequence(String s, int k) {
        StringBuilder str=new StringBuilder();
        int oneCounter=0;
        int counter=0;
        int value;
        boolean closed=false;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1') {
                if(closed) continue;
                str.append('1');
                String temp=str.reverse().toString();
                str.reverse(); 
                try {
                    value=Integer.parseInt(temp,2);
                    if(value>k){
                        str.deleteCharAt(str.length()-1);
                        closed=true;
                    }
                    else oneCounter++;
                }
                catch(Exception e) {
                    str.deleteCharAt(str.length()-1);
                    closed=true;
                }
                
                
            }
            else{
                counter++;
                str.append('0');
            }
        }
        return counter+oneCounter;
    }
}