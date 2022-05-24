class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int cIndex=0,skip=numRows+numRows-2,sSkip=0;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<numRows;i++){
            cIndex=i;
            sSkip=i+i;
            while(cIndex<s.length()){
                res.append(s.charAt(cIndex));
                cIndex+=skip;
                if(cIndex-sSkip<s.length() && i!=0 && i!=numRows-1) {
                    res.append(s.charAt(cIndex-sSkip));
                }
            }
        }
        return res.toString();
        
    }
}