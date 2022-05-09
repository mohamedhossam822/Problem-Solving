class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder result;
        List<StringBuilder> list=new ArrayList<>();
        StringBuilder temp= new StringBuilder();
        int curNumber=0;
         int reminder=0;
        long ten=1;
        int zero=0;
        int fN,lN;
        
        int num1N=num1.length()-1;
        int num2N=num2.length()-1;
        
        while(num1N>-1){
            fN=Character.getNumericValue(num1.charAt(num1N));
            for(int i=0;i<zero;i++){
                temp.append('0');
            }
            num2N=num2.length()-1;
            while(num2N>-1){
                lN= Character.getNumericValue(num2.charAt(num2N));
                curNumber=fN*lN+reminder;
                
                reminder=curNumber/10;
                curNumber=curNumber%10;  
                temp.append((char) ('0' + curNumber));
                num2N--;
            }
            if(reminder>0) temp.append((char) ('0' + reminder));
            list.add(new StringBuilder(temp.reverse()));
            temp.setLength(0);
            reminder=0;
            num1N--;
            zero++;
        }
        
        result=new StringBuilder(list.get(0));
        for(int i=1;i<list.size();i++){
            num1N=list.get(i).length()-1;
            num2N=result.length()-1;
            while(num1N>-1 || num2N>-1 || reminder==1){
                fN= num1N>-1 ? Character.getNumericValue(list.get(i).charAt(num1N)):0;
                lN= num2N>-1 ? Character.getNumericValue(result.charAt(num2N)):0;
                curNumber=fN+lN+reminder;
                reminder=curNumber/10;
                curNumber=curNumber%10;
                temp.append((char) ('0' + curNumber));
                num1N--;
                num2N--;
            }
            result=new StringBuilder(temp.reverse());
            temp.setLength(0);
        }
        if(result.charAt(0)=='0') return "0";
        return result.toString();
        
    }
}