class Solution {
    public int myAtoi(String s) {
        StringBuilder str=new StringBuilder();
        int len=-1,res=0,counter=0;
        boolean whitespace=true;
        boolean noSign=true;
        boolean noNumber=true;
        char c;
        int sign=1;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(whitespace && c==' ') continue;
            whitespace=false;
            if(noSign & (c=='+' || c=='-')){
                noSign=false;
                if(c=='-') sign=-1;
                continue;
            }
            noSign=false;
            if(!Character.isDigit(c)) break;
            if(noNumber && c=='0') continue;
            noNumber=false;
            len++;
            str.append(c);   
        }
        if(len==-1) return 0;
        while(len>=0){
            c=str.charAt(counter);
            counter++;
            res+=Character.getNumericValue(c)*Math.pow(10,len)*sign;
            len--;
        }
        return res;
    }
}